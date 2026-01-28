package com.flipfit.dao;

import com.flipfit.bean.GymOwner;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface GymOwnerDAO.
 *
 * @author Rishit
 * @ClassName "GymOwnerDAO"
 */
public interface GymOwnerDAO {

    // Method level Commenting

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     */
    void registerGymOwner(GymOwner owner);

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
     * Gets gym owner by username.
     *
     * @param username the username
     * @return the gym owner by username
     */
    GymOwner getGymOwnerByUsername(String username);
}
