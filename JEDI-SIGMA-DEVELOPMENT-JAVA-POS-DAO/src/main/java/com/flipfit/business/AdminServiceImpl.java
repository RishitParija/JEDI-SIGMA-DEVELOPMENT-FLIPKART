package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOImpl;
import com.flipfit.exception.InvalidApprovalException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminServiceImpl.
 *
 * @author Rishit
 * @ClassName "AdminServiceImpl"
 */
public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl();

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner ID
     * @throws InvalidApprovalException if approval fails
     */
    @Override
    public void approveGymOwner(String ownerId) {
        try {
            adminDAO.approveGymOwner(ownerId);
            System.out.println("Gym Owner approval request processed for ID: " + ownerId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym owner ID: " + ownerId);
        }
    }

    /**
     * Approves gym centre.
     *
     * @param centreId the centre ID
     * @throws InvalidApprovalException if approval fails
     */
    @Override
    public void approveGymCentre(String centreId) {
        try {
            adminDAO.approveGymCentre(centreId);
            System.out.println("Gym Centre approval request processed for ID: " + centreId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym centre ID: " + centreId);
        }
    }

    /**
     * View all gyms.
     */
    @Override
    public void viewAllGyms() {
        // This might need a GymCentreDAO, but for now, we can use
        // GymOwnerServiceImpl.gymCentreList if still needed
        // However, a better approach is to implement GymCentreDAO.
        System.out.println("--- All Gym Centres ---");
        // For now, let's assume we need to implement more DAOs to fully replace mock
        // data
    }

    /**
     * View pending gym owners.
     */
    @Override
    public void viewPendingGymOwners() {
        System.out.println("--- Pending Gym Owners ---");
        for (GymOwner owner : adminDAO.getPendingGymOwners()) {
            System.out.println(
                    "ID: " + owner.getUserId() + ", Name: " + owner.getName() + ", Email: " + owner.getEmail());
        }
    }

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    @Override
    public List<GymOwner> getPendingGymOwners() {
        return adminDAO.getPendingGymOwners();
    }

    /**
     * View pending gym centres.
     */
    @Override
    public void viewPendingGymCentres() {
        System.out.println("--- Pending Gym Centres ---");
        for (GymCentre centre : adminDAO.getPendingGymCentres()) {
            System.out.println(
                    "ID: " + centre.getCentreId() + ", Name: " + centre.getName() + ", City: " + centre.getCity());
        }
    }

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    @Override
    public List<GymCentre> getPendingGymCentres() {
        return adminDAO.getPendingGymCentres();
    }

    /**
     * View all bookings.
     */
    @Override
    public void viewAllBookings() {
        System.out.println("--- All Bookings ---");
        // Needs BookingDAO
    }

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    public boolean validateLogin(String username, String password) {
        return adminDAO.validateLogin(username, password);
    }
}