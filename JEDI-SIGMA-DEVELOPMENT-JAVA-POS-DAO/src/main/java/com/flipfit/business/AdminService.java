package com.flipfit.business;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminService.
 *
 * @author Rishit
 * @ClassName "AdminService"
 */
public interface AdminService {

    // MEthod level Commenting

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner id
     */
    void approveGymOwner(String ownerId);

    // MEthod level Commenting

    /**
     * Approves gym centre.
     *
     * @param centreId the centre id
     */
    void approveGymCentre(String centreId);

    // MEthod level Commenting

    /**
     * View all gyms.
     */
    void viewAllGyms();

    // MEthod level Commenting

    /**
     * View pending gym owners.
     */
    void viewPendingGymOwners();

    // MEthod level Commenting

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    java.util.List<com.flipfit.bean.GymOwner> getPendingGymOwners();

    // MEthod level Commenting

    /**
     * View pending gym centres.
     */
    void viewPendingGymCentres();

    // MEthod level Commenting

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    java.util.List<com.flipfit.bean.GymCentre> getPendingGymCentres();

    // MEthod level Commenting

    /**
     * View all bookings.
     */
    void viewAllBookings();

    // MEthod level Commenting

    /**
     * View gym owners by status using lambda.
     * 
     * @param verified the verified status
     */
    void viewGymOwnersByStatus(boolean verified);

    // MEthod level Commenting

    /**
     * View gym centres by status using lambda.
     * 
     * @param approved the approved status
     */
    void viewGymCentresByStatus(boolean approved);
}
