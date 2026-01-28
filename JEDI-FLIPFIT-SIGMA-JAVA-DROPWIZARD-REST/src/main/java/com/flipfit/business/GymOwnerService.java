package com.flipfit.business;

import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface GymOwnerService.
 *
 * @author Rishit
 * @ClassName "GymOwnerService"
 */
public interface GymOwnerService {

    // Method level Commenting

    /**
     * Registers centre.
     *
     * @param centre the centre
     */
    void registerCentre(GymCentre centre);

    // Method level Commenting

    /**
     * Adds slot.
     *
     * @param slot the slot
     */
    void addSlot(Slot slot);

    // Method level Commenting

    /**
     * Creates schedule.
     *
     * @param slotId the slot id
     * @param date   the date
     */
    void createSchedule(String slotId, java.time.LocalDate date);

    // Method level Commenting

    /**
     * Gets centres by owner id.
     *
     * @param ownerId the owner id
     * @return the centres by owner id
     */
    List<GymCentre> getCentresByOwnerId(String ownerId);

    // Method level Commenting

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     */
    void registerGymOwner(GymOwner owner);

    // Method level Commenting

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    // Method level Commenting

    /**
     * Gets gym owner by username.
     *
     * @param username the username
     * @return the gym owner by username
     */
    GymOwner getGymOwnerByUsername(String username);

    // Method level Commenting

    /**
     * Gets slots by centre id.
     *
     * @param centreId the centre id
     * @return the slots by centre id
     */
    List<Slot> getSlotsByCentreId(String centreId);
}