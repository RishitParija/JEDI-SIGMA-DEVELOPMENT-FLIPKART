package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM User u JOIN GymAdmin a ON u.userId = a.userId WHERE u.username = ? AND u.hashedPassword = ?";
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

    @Override
    public void approveGymOwner(String ownerId) {
        String sql = "UPDATE GymOwner SET isVerified = TRUE WHERE userId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ownerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void approveGymCentre(String centreId) {
        String sql = "UPDATE GymCentre SET isApproved = TRUE WHERE centreId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, centreId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GymOwner> getPendingGymOwners() {
        List<GymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE o.isVerified = FALSE";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                GymOwner owner = new GymOwner(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getString("panCard"));
                owner.setIsVerified(false);
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingOwners;
    }

    @Override
    public List<GymCentre> getPendingGymCentres() {
        List<GymCentre> pendingCentres = new ArrayList<>();
        String sql = "SELECT * FROM GymCentre WHERE isApproved = FALSE";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
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
}
