package com.flipfit.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;
import com.flipfit.dao.CustomerDAO;
import com.flipfit.dao.CustomerDAOImpl;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.exception.UserNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class GymCustomerServiceImpl.
 *
 * @author Shravya
 * @ClassName "GymCustomerServiceImpl"
 */
public class GymCustomerServiceImpl implements GymCustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
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

    /**
     * Books slot.
     *
     * @param gymId  the gym ID
     * @param slotId the slot ID
     * @param date   the date
     * @return true, if successful
     */
    @Override
    public boolean bookSlot(String gymId, String slotId, LocalDate date) {
        System.out.println("Please use the Booking Service directly or update this method to pass UserID.");
        return false;
    }

    /**
     * Registers customer.
     *
     * @param customer the customer
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerCustomer(GymCustomer customer) {
        try {
            customerDAO.registerCustomer(customer);
            System.out.println("Customer registered successfully for: " + customer.getName());
        } catch (Exception e) {
            throw new RegistrationNotDoneException("Registration failed for customer: " + customer.getName());
        }
    }

    /**
     * Validates customer.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    @Override
    public boolean validateCustomer(String username, String password) {
        return customerDAO.validateLogin(username, password);
    }

    /**
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     * @throws UserNotFoundException if user is not found
     */
    @Override
    public GymCustomer getCustomerByUsername(String username) {
        GymCustomer customer = customerDAO.getCustomerByUsername(username);
        if (customer == null) {
            throw new UserNotFoundException("User with username " + username + " not found.");
        }
        return customer;
    }

    /**
     * Update wallet.
     *
     * @param userId the user ID
     * @param amount the amount
     */
    @Override
    public void updateWallet(String userId, double amount) {
        customerDAO.updateWalletBalance(userId, amount);
        System.out.println("Wallet updated for User ID: " + userId);
    }
}