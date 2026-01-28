package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerDAO.
 *
 * @author Rishit
 * @ClassName "CustomerDAO"
 */
public interface CustomerDAO {

    // MEthod level Commenting

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    void registerCustomer(GymCustomer customer);

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
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     */
    GymCustomer getCustomerByUsername(String username);

    // MEthod level Commenting

    /**
     * Update wallet balance.
     *
     * @param userId the user id
     * @param amount the amount
     */
    void updateWalletBalance(String userId, double amount);
}
