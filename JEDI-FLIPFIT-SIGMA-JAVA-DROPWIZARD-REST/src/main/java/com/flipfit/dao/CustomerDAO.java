package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerDAO.
 *
 * @author Rishit
 * @ClassName "CustomerDAO"
 */
public interface CustomerDAO {

    // Method level Commenting

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    void registerCustomer(GymCustomer customer);

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
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     */
    GymCustomer getCustomerByUsername(String username);

    // Method level Commenting

    /**
     * Update wallet balance.
     *
     * @param userId the user id
     * @param amount the amount
     */
    void updateWalletBalance(String userId, double amount);
}
