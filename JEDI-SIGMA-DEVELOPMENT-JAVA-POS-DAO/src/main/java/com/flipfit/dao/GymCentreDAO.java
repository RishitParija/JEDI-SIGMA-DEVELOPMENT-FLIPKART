package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import java.util.List;

/**
 * The Interface GymCentreDAO.
 *
 * @author Rishit
 * @ClassName "GymCentreDAO"
 */
public interface GymCentreDAO {
    /**
     * Adds the gym centre.
     *
     * @param centre the centre
     */
    void addGymCentre(GymCentre centre);

    /**
     * Gets gyms by owner id.
     *
     * @param ownerId the owner ID
     * @return the gyms by owner id
     */
    List<GymCentre> getGymsByOwnerId(String ownerId);

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    List<GymCentre> getGymsByCity(String city);

    /**
     * Gets all gym centres.
     *
     * @return the list of all gym centres
     */
    List<GymCentre> getAllGymCentres();
}
