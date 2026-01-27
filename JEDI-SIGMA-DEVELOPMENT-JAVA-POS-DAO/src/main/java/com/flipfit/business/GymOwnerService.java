package com.flipfit.business;

import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;

public interface GymOwnerService {
    void registerCentre(GymCentre centre);

    void addSlot(Slot slot);

    void createSchedule(String slotId, java.time.LocalDate date);

    List<GymCentre> getCentresByOwnerId(String ownerId);

    void registerGymOwner(GymOwner owner);

    boolean validateLogin(String username, String password);
}