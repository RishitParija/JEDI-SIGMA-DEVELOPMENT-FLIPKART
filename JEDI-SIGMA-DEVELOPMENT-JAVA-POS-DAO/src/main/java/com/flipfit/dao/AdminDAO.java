package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminDAO.
 *
 * @author Shravya
 * @ClassName "AdminDAO"
 */
public interface AdminDAO {

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner ID
     */
    void approveGymOwner(String ownerId);

    /**
     * Approves gym centre.
     *
     * @param centreId the centre ID
     */
    void approveGymCentre(String centreId);

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    List<GymOwner> getPendingGymOwners();

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    List<GymCentre> getPendingGymCentres();
}
