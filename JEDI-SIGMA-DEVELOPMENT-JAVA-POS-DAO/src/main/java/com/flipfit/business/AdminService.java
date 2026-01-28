package com.flipfit.business;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminService.
 *
 * @author Rishit
 * @ClassName "AdminService"
 */
public interface AdminService {

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner ID
     */
    void approveGymOwner(String ownerId);

    /**
     * Approves gym centre.
     *
     * @param centreId the centre ID
     */
    void approveGymCentre(String centreId);

    /**
     * View all gyms.
     */
    void viewAllGyms();

    /**
     * View pending gym owners.
     */
    void viewPendingGymOwners();

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    java.util.List<com.flipfit.bean.GymOwner> getPendingGymOwners();

    /**
     * View pending gym centres.
     */
    void viewPendingGymCentres();

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    java.util.List<com.flipfit.bean.GymCentre> getPendingGymCentres();

    /**
     * View all bookings.
     */
    void viewAllBookings();
}
