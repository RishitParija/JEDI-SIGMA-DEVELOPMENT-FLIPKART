package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminDAO.
 *
 * @author Rishit
 * @ClassName "AdminDAO"
 */
public interface AdminDAO {

    // Method level Commenting

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    // Method level Commenting

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner id
     */
    void approveGymOwner(String ownerId);

    // Method level Commenting

    /**
     * Approves gym centre.
     *
     * @param centreId the centre id
     */
    void approveGymCentre(String centreId);

    // Method level Commenting

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    List<GymOwner> getPendingGymOwners();

    // Method level Commenting

    /**
     * Gets all gym owners.
     *
     * @return the all gym owners
     */
    List<GymOwner> getAllGymOwners();

    // Method level Commenting

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    List<GymCentre> getPendingGymCentres();

    // Method level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    List<GymCentre> getAllGymCentres();
}
