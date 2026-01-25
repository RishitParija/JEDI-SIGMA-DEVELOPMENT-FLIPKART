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
        // This should delegate to BookingService or handle here.
        // For now adhering to interface, but BookingService is likely better place.
        // However, the menu calls this. Let's redirect or implement roughly.
        // Actually, the requirements say "update slot count... remove his current
        // slot... waitlist feature".
        // This logic is complex and might belong in BookingService.
        // But the menu calls THIS method. So I will call BookingService from here.
        // BookingService logic is handled in the Menu directly now.
        // Missing userId here in params? The menu needs to be updated to pass userId or
        // manage session.
        // For now, I'll print. But I must update GymCustomerService.
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