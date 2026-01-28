package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class GymOwnerDAOImpl.
 *
 * @author Rishit
 * @ClassName "GymOwnerDAOImpl"
 */
public class GymOwnerDAOImpl implements GymOwnerDAO {

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     */
    @Override
    public void registerGymOwner(GymOwner owner) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement uStmt = conn.prepareStatement(SQLConstants.REGISTER_USER_QUERY);
                    PreparedStatement oStmt = conn.prepareStatement(SQLConstants.REGISTER_GYM_OWNER_QUERY)) {

                uStmt.setString(1, owner.getUserId());
                uStmt.setString(2, owner.getUsername());
                uStmt.setString(3, owner.getName());
                uStmt.setString(4, owner.getEmail());
                uStmt.setString(5, owner.getPasswordHash());
                uStmt.executeUpdate();

                oStmt.setString(1, owner.getUserId());
                oStmt.setString(2, owner.getPanCard());
                oStmt.setBoolean(3, owner.getIsVerified());
                oStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    @Override
    public boolean validateLogin(String username, String password) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GYM_OWNER_LOGIN_QUERY)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
