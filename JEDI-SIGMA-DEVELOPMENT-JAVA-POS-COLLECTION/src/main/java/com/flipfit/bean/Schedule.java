package com.flipfit.bean;

import java.time.LocalDate;

public class Schedule {
    private String scheduleId;
    private String slotId;
    private LocalDate date;
    private Integer availableSeats;
    private Boolean isCancelled;

    public Schedule(String scheduleId, String slotId, LocalDate date, Integer availableSeats) {
        this.scheduleId = scheduleId;
        this.slotId = slotId;
        this.date = date;
        this.availableSeats = availableSeats;
        this.isCancelled = false;
    }

    // Getters and Setters
    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public Boolean getIsCancelled() { return isCancelled; }
    public void setIsCancelled(Boolean isCancelled) { this.isCancelled = isCancelled; }
}
