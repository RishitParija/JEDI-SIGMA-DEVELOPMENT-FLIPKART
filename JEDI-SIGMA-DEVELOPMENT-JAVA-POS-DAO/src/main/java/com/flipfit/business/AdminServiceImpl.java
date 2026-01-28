package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Booking;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOImpl;
import com.flipfit.dao.BookingDAO;
import com.flipfit.dao.BookingDAOImpl;
import com.flipfit.dao.GymCentreDAO;
import com.flipfit.dao.GymCentreDAOImpl;
import com.flipfit.exception.InvalidApprovalException;
import java.util.List;

/**
 * The Class AdminServiceImpl.
 *
 * @author Rishit
 * @ClassName "AdminServiceImpl"
 */
public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl();
    private BookingDAO bookingDAO = new BookingDAOImpl();
    private GymCentreDAO gymCentreDAO = new GymCentreDAOImpl();

    @Override
    public void approveGymOwner(String ownerId) {
        try {
            adminDAO.approveGymOwner(ownerId);
            System.out.println("Gym Owner approval request processed for ID: " + ownerId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym owner ID: " + ownerId);
        }
    }

    @Override
    public void approveGymCentre(String centreId) {
        try {
            adminDAO.approveGymCentre(centreId);
            System.out.println("Gym Centre approval request processed for ID: " + centreId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym centre ID: " + centreId);
        }
    }

    @Override
    public void viewAllGyms() {
        System.out.println("--- All Gym Centres ---");
        List<GymCentre> gyms = gymCentreDAO.getAllGymCentres();
        if (gyms.isEmpty()) {
            System.out.println("No gym centres found.");
        } else {
            for (GymCentre gym : gyms) {
                System.out.println("ID: " + gym.getCentreId() + ", Name: " + gym.getName() + ", City: " + gym.getCity()
                        + ", Approved: " + gym.isApproved());
            }
        }
    }

    @Override
    public void viewPendingGymOwners() {
        System.out.println("--- Pending Gym Owners ---");
        List<GymOwner> owners = adminDAO.getPendingGymOwners();
        if (owners.isEmpty()) {
            System.out.println("No pending gym owners.");
        } else {
            for (GymOwner owner : owners) {
                System.out.println(
                        "ID: " + owner.getUserId() + ", Name: " + owner.getName() + ", Email: " + owner.getEmail());
            }
        }
    }

    @Override
    public List<GymOwner> getPendingGymOwners() {
        return adminDAO.getPendingGymOwners();
    }

    @Override
    public void viewPendingGymCentres() {
        System.out.println("--- Pending Gym Centres ---");
        List<GymCentre> centres = adminDAO.getPendingGymCentres();
        if (centres.isEmpty()) {
            System.out.println("No pending gym centres.");
        } else {
            for (GymCentre centre : centres) {
                System.out.println(
                        "ID: " + centre.getCentreId() + ", Name: " + centre.getName() + ", City: " + centre.getCity());
            }
        }
    }

    @Override
    public List<GymCentre> getPendingGymCentres() {
        return adminDAO.getPendingGymCentres();
    }

    @Override
    public void viewAllBookings() {
        System.out.println("--- All Bookings ---");
        List<Booking> bookings = bookingDAO.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println("ID: " + booking.getBookingId() + ", User: " + booking.getUserId() + ", Schedule: "
                        + booking.getScheduleId() + ", Status: " + booking.getStatus());
            }
        }
    }

    public boolean validateLogin(String username, String password) {
        return adminDAO.validateLogin(username, password);
    }
}