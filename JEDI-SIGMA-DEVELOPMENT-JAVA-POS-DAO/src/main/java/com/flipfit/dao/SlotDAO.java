package com.flipfit.dao;

import com.flipfit.bean.Slot;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface SlotDAO.
 *
 * @author Rishit
 * @ClassName "SlotDAO"
 */
public interface SlotDAO {

    // MEthod level Commenting

    /**
     * Adds the slot.
     *
     * @param slot the slot
     */
    void addSlot(Slot slot);

    // MEthod level Commenting

    /**
     * Gets slots by centre id.
     *
     * @param centreId the centre id
     * @return the slots by centre id
     */
    List<Slot> getSlotsByCentreId(String centreId);

    // MEthod level Commenting

    /**
     * Gets slot by id.
     *
     * @param slotId the slot id
     * @return the slot by id
     */
    Slot getSlotById(String slotId);
}
