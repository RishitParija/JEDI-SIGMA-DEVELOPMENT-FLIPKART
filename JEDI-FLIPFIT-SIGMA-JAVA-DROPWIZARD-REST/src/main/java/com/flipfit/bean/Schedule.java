package com.flipfit.bean;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Schedule.
 *
 * @author Rishit
 * @ClassName "Schedule"
 */
public class Schedule {
    private String scheduleId;
    private String slotId;
    private LocalDate date;
    private Integer availableSeats;
    private Boolean isCancelled;

    /**
     * Instantiates a new schedule.
     */
    public Schedule() {
    }

    /**
     * Instantiates a new schedule.
     *
     * @param scheduleId     the schedule id
     * @param slotId         the slot id
     * @param date           the date
     * @param availableSeats the available seats
     */
    public Schedule(String scheduleId, String slotId, LocalDate date, Integer availableSeats) {
        this.scheduleId = scheduleId;
        this.slotId = slotId;
        this.date = date;
        this.availableSeats = availableSeats;
        this.isCancelled = false;
    }

    // Getters and Setters
    /**
     * Gets the schedule id.
     *
     * @return the schedule id
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * Sets the schedule id.
     *
     * @param scheduleId the new schedule id
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
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
     * Sets the slot id.
     *
     * @param slotId the new slot id
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the available seats.
     *
     * @return the available seats
     */
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the available seats.
     *
     * @param availableSeats the new available seats
     */
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Gets the checks if is cancelled.
     *
     * @return the checks if is cancelled
     */
    public Boolean getIsCancelled() {
        return isCancelled;
    }

    /**
     * Sets the checks if is cancelled.
     *
     * @param isCancelled the new checks if is cancelled
     */
    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
