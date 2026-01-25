package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;
import com.flipfit.bean.GymOwner;

public interface GymOwnerService {
    void registerCentre(GymCentre centre);

    void addSlot(Slot slot);

    void createSchedule(String slotId, java.time.LocalDate date);

    java.util.List<com.flipfit.bean.GymCentre> getCentresByOwnerId(String ownerId);

    void createGymOwner(GymOwner owner);
}