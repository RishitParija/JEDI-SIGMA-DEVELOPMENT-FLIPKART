package com.flipfit.bean;

import java.time.LocalTime;

public class Slot {
    private String slotId;
    private String centreId;
    private LocalTime startTime;
    private LocalTime endTime;

    public Slot(String slotId, String centreId, LocalTime startTime, LocalTime endTime) {
        this.slotId = slotId;
        this.centreId = centreId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSlotId() { return slotId; }
    public LocalTime getStartTime() { return startTime; }
}
