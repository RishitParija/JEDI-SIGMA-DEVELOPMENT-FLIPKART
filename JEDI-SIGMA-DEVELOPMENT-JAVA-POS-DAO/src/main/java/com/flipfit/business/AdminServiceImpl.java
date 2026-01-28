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
import java.util.stream.Collectors;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
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

    // MEthod level Commenting

    @Override
    public void approveGymOwner(String ownerId) {
        try {
            adminDAO.approveGymOwner(ownerId);
            System.out.println("Gym Owner approval request processed for ID: " + ownerId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym owner ID: " + ownerId);
        }
    }

    // MEthod level Commenting

    @Override
    public void approveGymCentre(String centreId) {
        try {
            adminDAO.approveGymCentre(centreId);
            System.out.println("Gym Centre approval request processed for ID: " + centreId);
        } catch (Exception e) {
            throw new InvalidApprovalException("Approval failed for gym centre ID: " + centreId);
        }
    }

    // MEthod level Commenting

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
        System.out.println();
    }

    // MEthod level Commenting

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
        System.out.println();
    }

    // MEthod level Commenting

    @Override
    public List<GymOwner> getPendingGymOwners() {
        return adminDAO.getPendingGymOwners();
    }

    // MEthod level Commenting

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
        System.out.println();
    }

    // MEthod level Commenting

    @Override
    public List<GymCentre> getPendingGymCentres() {
        return adminDAO.getPendingGymCentres();
    }

    // MEthod level Commenting

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
        System.out.println();
    }

    // MEthod level Commenting

    public boolean validateLogin(String username, String password) {
        return adminDAO.validateLogin(username, password);
    }

    // MEthod level Commenting

    @Override
    public void viewGymOwnersByStatus(boolean verified) {
        System.out.println("--- " + (verified ? "Verified" : "Unverified") + " Gym Owners ---");
        List<GymOwner> allOwners = adminDAO.getAllGymOwners();
        List<GymOwner> filtered = allOwners.stream()
                .filter(owner -> owner.getIsVerified() == verified)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No owners found.");
        } else {
            filtered.forEach(o -> System.out
                    .println("ID: " + o.getUserId() + ", Name: " + o.getName() + ", Email: " + o.getEmail()));
        }
        System.out.println();
    }

    // MEthod level Commenting

    @Override
    public void viewGymCentresByStatus(boolean approved) {
        System.out.println("--- " + (approved ? "Approved" : "Pending") + " Gym Centres ---");
        List<GymCentre> allCentres = adminDAO.getAllGymCentres();
        List<GymCentre> filtered = allCentres.stream()
                .filter(c -> c.isApproved() == approved)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No centres found.");
        } else {
            filtered.forEach(c -> System.out
                    .println("ID: " + c.getCentreId() + ", Name: " + c.getName() + ", City: " + c.getCity()));
        }
    }
}