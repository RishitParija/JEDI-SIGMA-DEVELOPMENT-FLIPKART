package com.flipfit.business;

import java.time.LocalDate;
import com.flipfit.bean.GymCustomer;

public interface GymCustomerService {
    java.util.List<com.flipfit.bean.GymCentre> getGymsByCity(String city);

    boolean bookSlot(String gymId, String slotId, LocalDate date);

    void createCustomer(GymCustomer customer);
}
