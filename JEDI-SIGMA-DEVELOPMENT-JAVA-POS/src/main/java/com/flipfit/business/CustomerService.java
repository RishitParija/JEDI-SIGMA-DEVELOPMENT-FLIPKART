package com.flipfit.business;

import java.time.LocalDate;

public interface CustomerService {
    void viewGymsByCity(String city);
    boolean bookSlot(String gymId, String slotId, LocalDate date);
}
