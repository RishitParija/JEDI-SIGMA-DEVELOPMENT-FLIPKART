package com.flipfit.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;
import com.flipfit.dao.CustomerDAO;
import com.flipfit.dao.CustomerDAOImpl;

public class GymCustomerServiceImpl implements GymCustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<GymCentre> getGymsByCity(String city) {
        List<GymCentre> result = new ArrayList<>();
        for (GymCentre centre : GymOwnerServiceImpl.gymCentreList) {
            if (centre.getCity().equalsIgnoreCase(city) && centre.isApproved()) {
                result.add(centre);
            }
        }
        return result;
    }

    @Override
    public boolean bookSlot(String gymId, String slotId, LocalDate date) {
        System.out.println("Please use the Booking Service directly or update this method to pass UserID.");
        return false;
    }

    @Override
    public void registerCustomer(GymCustomer customer) {
        customerDAO.registerCustomer(customer);
        System.out.println("Customer registered successfully for: " + customer.getName());
    }

    @Override
    public boolean validateCustomer(String username, String password) {
        return customerDAO.validateLogin(username, password);
    }

    @Override
    public GymCustomer getCustomerByUsername(String username) {
        return customerDAO.getCustomerByUsername(username);
    }

    @Override
    public void updateWallet(String userId, double amount) {
        customerDAO.updateWalletBalance(userId, amount);
        System.out.println("Wallet updated for User ID: " + userId);
    }
}