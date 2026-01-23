package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;

public interface GymOwnerService {
    void registerCentre(GymCentre centre);
    void addSlot(Slot slot);
}