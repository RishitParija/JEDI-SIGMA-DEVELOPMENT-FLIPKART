package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
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
 * The Class GymCentreDAOImpl.
 *
 * @author Rishit
 * @ClassName "GymCentreDAOImpl"
 */
public class GymCentreDAOImpl implements GymCentreDAO {

    // Method level Commenting

    /**
     * Adds the gym centre.
     *
     * @param centre the centre
     */
    @Override
    public void addGymCentre(GymCentre centre) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_GYM_CENTRE_QUERY)) {
            stmt.setString(1, centre.getCentreId());
            stmt.setString(2, centre.getOwnerId());
            stmt.setString(3, centre.getName());
            stmt.setString(4, centre.getCity());
            stmt.setBoolean(5, centre.isApproved());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method level Commenting

    /**
     * Gets gyms by owner id.
     *
     * @param ownerId the owner id
     * @return the gyms by owner id
     */
    @Override
    public List<GymCentre> getGymsByOwnerId(String ownerId) {
        List<GymCentre> centres = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_GYMS_BY_OWNER_QUERY)) {
            stmt.setString(1, ownerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GymCentre centre = new GymCentre();
                centre.setCentreId(rs.getString("centreId"));
                centre.setOwnerId(rs.getString("ownerId"));
                centre.setName(rs.getString("name"));
                centre.setCity(rs.getString("city"));
                centre.setApproved(rs.getBoolean("isApproved"));
                centres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }

    // Method level Commenting

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    @Override
    public List<GymCentre> getGymsByCity(String city) {
        List<GymCentre> centres = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_GYMS_BY_CITY_QUERY)) {
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GymCentre centre = new GymCentre();
                centre.setCentreId(rs.getString("centreId"));
                centre.setOwnerId(rs.getString("ownerId"));
                centre.setName(rs.getString("name"));
                centre.setCity(rs.getString("city"));
                centre.setApproved(rs.getBoolean("isApproved"));
                centres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }

    // Method level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    @Override
    public List<GymCentre> getAllGymCentres() {
        List<GymCentre> centres = new ArrayList<>();
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
                centres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }
}
