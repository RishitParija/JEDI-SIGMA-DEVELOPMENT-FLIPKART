package com.flipfit.dao;

import com.flipfit.bean.GymOwner;

// TODO: Auto-generated Javadoc
/**
 * The Interface GymOwnerDAO.
 *
 * @author Rishit
 * @ClassName "GymOwnerDAO"
 */
public interface GymOwnerDAO {

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     */
    void registerGymOwner(GymOwner owner);

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);
}
