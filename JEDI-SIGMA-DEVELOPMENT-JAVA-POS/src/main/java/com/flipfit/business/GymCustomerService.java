package com.flipfit.business;

import java.time.LocalDate;

public interface GymCustomerService {
    void viewGymsByCity(String city);
    boolean bookSlot(String gymId, String slotId, LocalDate date);
}
