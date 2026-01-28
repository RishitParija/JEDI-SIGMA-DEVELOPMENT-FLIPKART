package com.flipfit.business;

import java.time.LocalDate;
import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;
import com.flipfit.dao.CustomerDAO;
import com.flipfit.dao.CustomerDAOImpl;
import com.flipfit.dao.GymCentreDAO;
import com.flipfit.dao.GymCentreDAOImpl;
import com.flipfit.dao.ScheduleDAO;
import com.flipfit.dao.ScheduleDAOImpl;
import com.flipfit.exception.InvalidDataException;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.validation.Validator;

/**
 * The Class GymCustomerServiceImpl.
 *
 * @author Rishit
 * @ClassName "GymCustomerServiceImpl"
 */
public class GymCustomerServiceImpl implements GymCustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private GymCentreDAO gymCentreDAO = new GymCentreDAOImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    @Override
    public List<GymCentre> getGymsByCity(String city) {
        return gymCentreDAO.getGymsByCity(city);
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
     * @throws InvalidDataException         if validation fails
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerCustomer(GymCustomer customer) {
        if (!Validator.isEmailValid(customer.getEmail())) {
            throw new InvalidDataException("Invalid Email format.");
        }
        if (!Validator.isPhoneValid(customer.getPhoneNumber())) {
            throw new InvalidDataException("Phone number must 10 digits.");
        }

        try {
            customerDAO.registerCustomer(customer);
            System.out.println("Customer registered successfully: " + customer.getUsername());
        } catch (Exception e) {
            throw new RegistrationNotDoneException("Registration failed for customer: " + customer.getUsername());
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

    @Override
    public List<com.flipfit.bean.Schedule> getSchedulesByGymAndDate(String gymId, LocalDate date) {
        return scheduleDAO.getSchedulesByDate(date);
    }
}