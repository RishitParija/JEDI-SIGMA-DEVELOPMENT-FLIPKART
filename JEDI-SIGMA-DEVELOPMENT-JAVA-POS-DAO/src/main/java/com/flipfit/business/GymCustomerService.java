package com.flipfit.business;

import java.time.LocalDate;
import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;

public interface GymCustomerService {
    List<GymCentre> getGymsByCity(String city);

    boolean bookSlot(String gymId, String slotId, LocalDate date);

    void registerCustomer(GymCustomer customer);

    boolean validateCustomer(String username, String password);

    GymCustomer getCustomerByUsername(String username);

    void updateWallet(String userId, double amount);
}
