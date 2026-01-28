package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminDAO.
 *
 * @author Rishit
 * @ClassName "AdminDAO"
 */
public interface AdminDAO {

    // MEthod level Commenting

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    // MEthod level Commenting

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner id
     */
    void approveGymOwner(String ownerId);

    // MEthod level Commenting

    /**
     * Approves gym centre.
     *
     * @param centreId the centre id
     */
    void approveGymCentre(String centreId);

    // MEthod level Commenting

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    List<GymOwner> getPendingGymOwners();

    // MEthod level Commenting

    /**
     * Gets all gym owners.
     *
     * @return the all gym owners
     */
    List<GymOwner> getAllGymOwners();

    // MEthod level Commenting

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    List<GymCentre> getPendingGymCentres();

    // MEthod level Commenting

    /**
     * Gets all gym centres.
     *
     * @return the all gym centres
     */
    List<GymCentre> getAllGymCentres();
}
