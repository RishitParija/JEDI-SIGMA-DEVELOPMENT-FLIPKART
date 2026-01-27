package com.flipfit.business;

import java.time.LocalDate;
import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class GymCustomerService.
 *
 * @author Shravya
 * @ClassName "GymCustomerService"
 */
public interface GymCustomerService {

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    List<GymCentre> getGymsByCity(String city);

    /**
     * Books slot.
     *
     * @param gymId  the gym ID
     * @param slotId the slot ID
     * @param date   the date
     * @return true, if successful
     */
    boolean bookSlot(String gymId, String slotId, LocalDate date);

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    void registerCustomer(GymCustomer customer);

    /**
     * Validates customer.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateCustomer(String username, String password);

    /**
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     */
    GymCustomer getCustomerByUsername(String username);

    /**
     * Update wallet.
     *
     * @param userId the user ID
     * @param amount the amount
     */
    void updateWallet(String userId, double amount);
}
