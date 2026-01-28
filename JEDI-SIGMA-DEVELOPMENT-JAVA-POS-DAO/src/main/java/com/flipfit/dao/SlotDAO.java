package com.flipfit.dao;

import com.flipfit.bean.Slot;
import java.util.List;

/**
 * The Interface SlotDAO.
 *
 * @author Rishit
 * @ClassName "SlotDAO"
 */
public interface SlotDAO {
    /**
     * Adds the slot.
     *
     * @param slot the slot
     */
    void addSlot(Slot slot);

    /**
     * Gets slots by centre id.
     *
     * @param centreId the centre ID
     * @return the slots by centre id
     */
    List<Slot> getSlotsByCentreId(String centreId);

    /**
     * Gets slot by id.
     *
     * @param slotId the slot ID
     * @return the slot by id
     */
    Slot getSlotById(String slotId);
}
