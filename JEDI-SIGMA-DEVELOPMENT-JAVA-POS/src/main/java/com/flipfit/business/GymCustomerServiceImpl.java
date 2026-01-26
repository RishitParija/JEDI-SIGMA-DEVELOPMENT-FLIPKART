package com.flipfit.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymCustomer;

public class GymCustomerServiceImpl implements GymCustomerService {
    public static List<GymCustomer> customerList = new ArrayList<>();

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
    public void createCustomer(com.flipfit.bean.GymCustomer customer) {
        customerList.add(customer);
        System.out.println("Creating Customer: " + customer.getName());
    }

    public boolean validateLogin(String username, String password) {
        for (GymCustomer customer : customerList) {
            if (customer.getUsername().equals(username) && customer.getPasswordHash().equals(password)) {
                return true;
            }
        }
        return false;
    }
}