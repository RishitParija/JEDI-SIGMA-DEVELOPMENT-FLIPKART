package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOImpl;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public void approveGymOwner(String ownerId) {
        adminDAO.approveGymOwner(ownerId);
        System.out.println("Gym Owner approval request processed for ID: " + ownerId);
    }

    @Override
    public void approveGymCentre(String centreId) {
        adminDAO.approveGymCentre(centreId);
        System.out.println("Gym Centre approval request processed for ID: " + centreId);
    }

    @Override
    public void viewAllGyms() {
        // This might need a GymCentreDAO, but for now, we can use
        // GymOwnerServiceImpl.gymCentreList if still needed
        // However, a better approach is to implement GymCentreDAO.
        System.out.println("--- All Gym Centres ---");
        // For now, let's assume we need to implement more DAOs to fully replace mock
        // data
    }

    @Override
    public void viewPendingGymOwners() {
        System.out.println("--- Pending Gym Owners ---");
        for (GymOwner owner : adminDAO.getPendingGymOwners()) {
            System.out.println(
                    "ID: " + owner.getUserId() + ", Name: " + owner.getName() + ", Email: " + owner.getEmail());
        }
    }

    @Override
    public List<GymOwner> getPendingGymOwners() {
        return adminDAO.getPendingGymOwners();
    }

    @Override
    public void viewPendingGymCentres() {
        System.out.println("--- Pending Gym Centres ---");
        for (GymCentre centre : adminDAO.getPendingGymCentres()) {
            System.out.println(
                    "ID: " + centre.getCentreId() + ", Name: " + centre.getName() + ", City: " + centre.getCity());
        }
    }

    @Override
    public List<GymCentre> getPendingGymCentres() {
        return adminDAO.getPendingGymCentres();
    }

    @Override
    public void viewAllBookings() {
        System.out.println("--- All Bookings ---");
        // Needs BookingDAO
    }

    public boolean validateLogin(String username, String password) {
        return adminDAO.validateLogin(username, password);
    }
}