package com.flipfit.business;

import java.time.LocalDate;
import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface GymCustomerService.
 *
 * @author Rishit
 * @ClassName "GymCustomerService"
 */
public interface GymCustomerService {

    // Method level Commenting

    /**
     * Gets gyms by city.
     *
     * @param city the city
     * @return the gyms by city
     */
    List<GymCentre> getGymsByCity(String city);

    // Method level Commenting

    /**
     * Books slot.
     *
     * @param gymId  the gym id
     * @param slotId the slot id
     * @param date   the date
     * @return true, if successful
     */
    boolean bookSlot(String gymId, String slotId, LocalDate date);

    // Method level Commenting

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    void registerCustomer(GymCustomer customer);

    // Method level Commenting

    /**
     * Validates customer.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateCustomer(String username, String password);

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
     * Update wallet.
     *
     * @param userId the user id
     * @param amount the amount
     */
    void updateWallet(String userId, double amount);

    // Method level Commenting

    /**
     * Gets schedules by gym and date.
     *
     * @param gymId the gym id
     * @param date  the date
     * @return the schedules by gym and date
     */
    List<com.flipfit.bean.Schedule> getSchedulesByGymAndDate(String gymId, LocalDate date);
}
