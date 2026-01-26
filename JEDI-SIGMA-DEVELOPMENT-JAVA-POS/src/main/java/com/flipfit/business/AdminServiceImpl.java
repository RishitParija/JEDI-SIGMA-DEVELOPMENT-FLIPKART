package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;

public class AdminServiceImpl implements AdminService {

    public static java.util.List<com.flipfit.bean.GymAdmin> adminList = new java.util.ArrayList<>();

    // Static block to seed default admin
    static {
        com.flipfit.bean.GymAdmin defaultAdmin = new com.flipfit.bean.GymAdmin(
                "admin-001", "Rishit", "Rishit Parija", "rishit.parija@gmail.com", "Rishit123", "EMP001");
        adminList.add(defaultAdmin);
    }

    @Override
    public void approveGymOwner(String ownerId) {
        for (GymOwner owner : GymOwnerServiceImpl.gymOwnerList) {
            if (owner.getUserId().equals(ownerId)) { // Assuming userId is ownerId, or we might match by name for
                // But better to use IDs. FlipFitApp generates UUIDs.
                owner.setIsVerified(true);
                System.out.println("Gym Owner " + owner.getName() + " approved.");
                return;
            }
        }
        System.out.println("Gym Owner not found.");
    }

    @Override
    public void approveGymCentre(String centreId) {
        for (GymCentre centre : GymOwnerServiceImpl.gymCentreList) {
            if (centre.getCentreId().equals(centreId)) { // Centre needs ID.
                centre.setApproved(true);
                System.out.println("Gym Centre " + centre.getName() + " approved.");
                return;
            }
        }
        System.out.println("Gym Centre not found.");
    }

    @Override
    public void viewAllGyms() {
        System.out.println("--- All Gym Centres ---");
        for (GymCentre centre : GymOwnerServiceImpl.gymCentreList) {
            System.out.println("ID: " + centre.getCentreId() + ", Name: " + centre.getName() + ", City: "
                    + centre.getCity() + ", Approved: " + centre.isApproved());
        }
    }

    @Override
    public void viewPendingGymOwners() {
        System.out.println("--- Pending Gym Owners ---");
        for (GymOwner owner : GymOwnerServiceImpl.gymOwnerList) {
            if (!owner.getIsVerified()) {
                System.out.println(
                        "ID: " + owner.getUserId() + ", Name: " + owner.getName() + ", Email: " + owner.getEmail());
            }
        }
    }

    @Override
    public java.util.List<GymOwner> getPendingGymOwners() {
        java.util.List<GymOwner> pending = new java.util.ArrayList<>();
        for (GymOwner owner : GymOwnerServiceImpl.gymOwnerList) {
            if (!owner.getIsVerified()) {
                pending.add(owner);
            }
        }
        return pending;
    }

    @Override
    public void viewPendingGymCentres() {
        System.out.println("--- Pending Gym Centres ---");
        for (GymCentre centre : GymOwnerServiceImpl.gymCentreList) {
            if (!centre.isApproved()) {
                System.out.println(
                        "ID: " + centre.getCentreId() + ", Name: " + centre.getName() + ", City: " + centre.getCity());
            }
        }
    }

    @Override
    public java.util.List<GymCentre> getPendingGymCentres() {
        java.util.List<GymCentre> pending = new java.util.ArrayList<>();
        for (GymCentre centre : GymOwnerServiceImpl.gymCentreList) {
            if (!centre.isApproved()) {
                pending.add(centre);
            }
        }
        return pending;
    }

    @Override
    public void viewAllBookings() {
        System.out.println("--- All Bookings ---");
        com.flipfit.business.BookingService bs = new com.flipfit.business.BookingServiceImpl();
        for (com.flipfit.bean.Booking b : bs.getAllBookings()) {
            System.out.println("BookingID: " + b.getBookingId() + " User: " + b.getUserId() + " Gym: " + b.getGymId()
                    + " Date: " + b.getDate());
        }
    }

    public boolean validateLogin(String username, String password) {
        for (com.flipfit.bean.GymAdmin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPasswordHash().equals(password)) {
                return true;
            }
        }
        return false;
    }
}