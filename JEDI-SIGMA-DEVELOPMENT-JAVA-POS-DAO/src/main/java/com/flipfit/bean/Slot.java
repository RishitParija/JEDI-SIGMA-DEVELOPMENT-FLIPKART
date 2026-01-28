package com.flipfit.bean;

import java.time.LocalTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Slot.
 *
 * @author Rishit
 * @ClassName "Slot"
 */
public class Slot {
    private String slotId;
    private String centreId;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * Instantiates a new slot.
     *
     * @param slotId    the slot ID
     * @param centreId  the centre ID
     * @param startTime the start time
     * @param endTime   the end time
     */
    public Slot(String slotId, String centreId, LocalTime startTime, LocalTime endTime) {
        this.slotId = slotId;
        this.centreId = centreId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the slot id.
     *
     * @return the slot id
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Gets the centre id.
     *
     * @return the centre id
     */
    public String getCentreId() {
        return centreId;
    } // Needed for linkage

    /**
     * Gets the start time.
     *
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time.
     *
     * @return the end time
     */
    public LocalTime getEndTime() {
        return endTime;
    }
}
