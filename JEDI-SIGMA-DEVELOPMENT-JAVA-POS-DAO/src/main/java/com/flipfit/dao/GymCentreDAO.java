package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface GymCentreDAO.
 *
 * @author Rishit
 * @ClassName "GymCentreDAO"
 */
public interface GymCentreDAO {

    // MEthod level Commenting

    /**
     * Adds the gym centre.
     *
     * @param centre the centre
     */
    void addGymCentre(GymCentre centre);

    // MEthod level Commenting

    /**
     * Gets gyms by owner id.
     *
     * @param ownerId the owner id
     * @return the gyms by owner id
     */
    List<GymCentre> getGymsByOwnerId(String ownerId);

    // MEthod level Commenting

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    List<GymCentre> getGymsByCity(String city);

    // MEthod level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    List<GymCentre> getAllGymCentres();
}
