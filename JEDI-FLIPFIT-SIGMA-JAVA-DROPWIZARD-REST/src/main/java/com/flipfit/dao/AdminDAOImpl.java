package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class AdminDAOImpl.
 *
 * @author Rishit
 * @ClassName "AdminDAOImpl"
 */
public class AdminDAOImpl implements AdminDAO {

    // Method level Commenting

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
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADMIN_LOGIN_QUERY)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method level Commenting

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner id
     */
    @Override
    public void approveGymOwner(String ownerId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_OWNER_QUERY)) {
            stmt.setString(1, ownerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method level Commenting

    /**
     * Approves gym centre.
     *
     * @param centreId the centre id
     */
    @Override
    public void approveGymCentre(String centreId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_CENTRE_QUERY)) {
            stmt.setString(1, centreId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method level Commenting

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    @Override
    public List<GymOwner> getPendingGymOwners() {
        List<GymOwner> pendingOwners = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_PENDING_GYM_OWNERS_QUERY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GymOwner owner = new GymOwner(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getString("panCard"),
                        rs.getString("phoneNumber"),
                        rs.getString("aadharCard"));
                owner.setIsVerified(false);
                pendingOwners.add(owner);
            }
            if (pendingOwners.isEmpty()) {
                System.out.println("[DEBUG] No pending owners found in database.");
            } else {
                System.out.println("[DEBUG] Found " + pendingOwners.size() + " pending owners.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingOwners;
    }

    // Method level Commenting

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    @Override
    public List<GymCentre> getPendingGymCentres() {
        List<GymCentre> pendingCentres = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_PENDING_GYM_CENTRES_QUERY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GymCentre centre = new GymCentre();
                centre.setCentreId(rs.getString("centreId"));
                centre.setOwnerId(rs.getString("ownerId"));
                centre.setName(rs.getString("name"));
                centre.setCity(rs.getString("city"));
                centre.setApproved(false);
                pendingCentres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingCentres;
    }

    // Method level Commenting

    /**
     * Gets all gym owners.
     *
     * @return the all gym owners
     */
    @Override
    public List<GymOwner> getAllGymOwners() {
        List<GymOwner> allOwners = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_ALL_GYM_OWNERS_QUERY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GymOwner owner = new GymOwner(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getString("panCard"),
                        rs.getString("phoneNumber"),
                        rs.getString("aadharCard"));
                owner.setIsVerified(rs.getBoolean("isVerified"));
                allOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOwners;
    }

    // Method level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    @Override
    public List<GymCentre> getAllGymCentres() {
        List<GymCentre> allCentres = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_ALL_GYM_CENTRES_QUERY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GymCentre centre = new GymCentre();
                centre.setCentreId(rs.getString("centreId"));
                centre.setOwnerId(rs.getString("ownerId"));
                centre.setName(rs.getString("name"));
                centre.setCity(rs.getString("city"));
                centre.setApproved(rs.getBoolean("isApproved"));
                allCentres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCentres;
    }
}
