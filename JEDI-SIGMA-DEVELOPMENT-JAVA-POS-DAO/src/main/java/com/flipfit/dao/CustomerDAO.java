package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;

public interface CustomerDAO {
    void registerCustomer(GymCustomer customer);

    boolean validateLogin(String username, String password);

    GymCustomer getCustomerByUsername(String username);

    void updateWalletBalance(String userId, double amount);
}
