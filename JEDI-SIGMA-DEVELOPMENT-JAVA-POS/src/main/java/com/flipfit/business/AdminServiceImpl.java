package com.flipfit.business;

public class AdminServiceImpl implements AdminService {
    @Override
    public void approveGymOwner(String ownerId) {
        System.out.println("Approving Gym Owner: " + ownerId);
    }
    @Override
    public void approveGymCentre(String centreId) {
        System.out.println("Approving Gym Centre: " + centreId);
    }
    @Override
    public void viewAllGyms() {
        System.out.println("Displaying all gyms...");
    }
}