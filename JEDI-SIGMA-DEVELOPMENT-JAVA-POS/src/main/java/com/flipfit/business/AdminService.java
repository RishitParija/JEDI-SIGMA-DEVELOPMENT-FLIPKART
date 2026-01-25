package com.flipfit.business;

public interface AdminService {
    void approveGymOwner(String ownerId);

    void approveGymCentre(String centreId);

    void viewAllGyms();

    void viewPendingGymOwners();

    java.util.List<com.flipfit.bean.GymOwner> getPendingGymOwners();

    void viewPendingGymCentres();

    java.util.List<com.flipfit.bean.GymCentre> getPendingGymCentres();

    void viewAllBookings();
}
