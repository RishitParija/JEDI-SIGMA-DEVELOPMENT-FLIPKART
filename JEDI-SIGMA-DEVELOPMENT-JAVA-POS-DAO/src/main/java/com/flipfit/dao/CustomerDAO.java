package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerDAO.
 *
 * @author Shravya
 * @ClassName "CustomerDAO"
 */
public interface CustomerDAO {

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    void registerCustomer(GymCustomer customer);

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    /**
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     */
    GymCustomer getCustomerByUsername(String username);

    /**
     * Update wallet balance.
     *
     * @param userId the user ID
     * @param amount the amount
     */
    void updateWalletBalance(String userId, double amount);
}
