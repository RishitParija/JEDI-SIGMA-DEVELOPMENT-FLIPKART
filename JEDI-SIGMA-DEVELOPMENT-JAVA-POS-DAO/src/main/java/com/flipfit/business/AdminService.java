package com.flipfit.business;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminService.
 *
 * @author Rishit
 * @ClassName "AdminService"
 */
public interface AdminService {

    // Method level Commenting

    /**
     * Approves gym owner.
     *
     * @param ownerId the owner id
     */
    void approveGymOwner(String ownerId);

    // Method level Commenting

    /**
     * Approves gym centre.
     *
     * @param centreId the centre id
     */
    void approveGymCentre(String centreId);

    // Method level Commenting

    /**
     * View all gyms.
     */
    void viewAllGyms();

    // Method level Commenting

    /**
     * View pending gym owners.
     */
    void viewPendingGymOwners();

    // Method level Commenting

    /**
     * Gets pending gym owners.
     *
     * @return the pending gym owners
     */
    java.util.List<com.flipfit.bean.GymOwner> getPendingGymOwners();

    // Method level Commenting

    /**
     * View pending gym centres.
     */
    void viewPendingGymCentres();

    // Method level Commenting

    /**
     * Gets pending gym centres.
     *
     * @return the pending gym centres
     */
    java.util.List<com.flipfit.bean.GymCentre> getPendingGymCentres();

    // Method level Commenting

    /**
     * View all bookings.
     */
    void viewAllBookings();

    // Method level Commenting

    /**
     * View gym owners by status using lambda.
     * 
     * @param verified the verified status
     */
    void viewGymOwnersByStatus(boolean verified);

    // Method level Commenting

    /**
     * View gym centres by status using lambda.
     * 
     * @param approved the approved status
     */
    void viewGymCentresByStatus(boolean approved);
}
