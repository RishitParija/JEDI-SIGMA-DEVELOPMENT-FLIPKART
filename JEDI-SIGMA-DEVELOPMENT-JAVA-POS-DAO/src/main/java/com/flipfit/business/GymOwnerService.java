package com.flipfit.business;

import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;

/**
 * The Interface GymOwnerService.
 *
 * @author Rishit
 * @ClassName "GymOwnerService"
 */
public interface GymOwnerService {
    /**
     * Registers centre.
     *
     * @param centre the centre
     */
    void registerCentre(GymCentre centre);

    /**
     * Adds slot.
     *
     * @param slot the slot
     */
    void addSlot(Slot slot);

    /**
     * Creates schedule.
     *
     * @param slotId the slot ID
     * @param date   the date
     */
    void createSchedule(String slotId, java.time.LocalDate date);

    /**
     * Gets centres by owner id.
     *
     * @param ownerId the owner ID
     * @return the centres by owner id
     */
    List<GymCentre> getCentresByOwnerId(String ownerId);

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     */
    void registerGymOwner(GymOwner owner);

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    boolean validateLogin(String username, String password);

    /**
     * Gets gym owner by username.
     *
     * @param username the username
     * @return the gym owner by username
     */
    GymOwner getGymOwnerByUsername(String username);

    /**
     * Gets slots by centre id.
     *
     * @param centreId the centre ID
     * @return the slots by centre id
     */
    List<Slot> getSlotsByCentreId(String centreId);
}