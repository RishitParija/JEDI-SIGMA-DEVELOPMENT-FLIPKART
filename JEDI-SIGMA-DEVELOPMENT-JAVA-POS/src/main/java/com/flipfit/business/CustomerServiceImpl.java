package com.flipfit.business;

import java.time.LocalDate;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void viewGymsByCity(String city) {
        System.out.println("Fetching gyms in " + city);
    }
    @Override
    public boolean bookSlot(String gymId, String slotId, LocalDate date) {
        System.out.println("Booking slot " + slotId + " for date " + date);
        return true;
    }
}