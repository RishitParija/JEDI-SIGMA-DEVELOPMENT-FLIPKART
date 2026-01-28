package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface GymCentreDAO.
 *
 * @author Rishit
 * @ClassName "GymCentreDAO"
 */
public interface GymCentreDAO {

    // Method level Commenting

    /**
     * Adds the gym centre.
     *
     * @param centre the centre
     */
    void addGymCentre(GymCentre centre);

    // Method level Commenting

    /**
     * Gets gyms by owner id.
     *
     * @param ownerId the owner id
     * @return the gyms by owner id
     */
    List<GymCentre> getGymsByOwnerId(String ownerId);

    // Method level Commenting

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    List<GymCentre> getGymsByCity(String city);

    // Method level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    List<GymCentre> getAllGymCentres();
}
