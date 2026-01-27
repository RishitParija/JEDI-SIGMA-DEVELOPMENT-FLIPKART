package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymOwnerDAOImpl implements GymOwnerDAO {

    @Override
    public void registerGymOwner(GymOwner owner) {
        String userSql = "INSERT INTO User (userId, username, name, email, hashedPassword) VALUES (?, ?, ?, ?, ?)";
        String ownerSql = "INSERT INTO GymOwner (userId, panCard, isVerified) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement uStmt = conn.prepareStatement(userSql);
                    PreparedStatement oStmt = conn.prepareStatement(ownerSql)) {

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

    @Override
    public boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE u.username = ? AND u.hashedPassword = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
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
