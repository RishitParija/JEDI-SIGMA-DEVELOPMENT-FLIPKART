package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;

public class GymOwnerServiceImpl implements GymOwnerService {
    @Override
    public void registerCentre(GymCentre centre) {
        System.out.println("Registering Gym Centre: " + centre.getName());
    }
    @Override
    public void addSlot(Slot slot) {
        System.out.println("Adding slot starting at " + slot.getStartTime());
    }
}