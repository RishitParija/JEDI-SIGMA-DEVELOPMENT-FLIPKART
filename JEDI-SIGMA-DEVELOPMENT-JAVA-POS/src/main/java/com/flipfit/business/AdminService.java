package com.flipfit.business;

public interface AdminService {
    void approveGymOwner(String ownerId);
    void approveGymCentre(String centreId);
    void viewAllGyms();
}
