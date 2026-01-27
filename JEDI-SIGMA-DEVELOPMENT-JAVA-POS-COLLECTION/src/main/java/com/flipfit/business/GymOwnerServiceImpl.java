package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;
import com.flipfit.bean.GymOwner;
import java.util.ArrayList;
import java.util.List;

public class GymOwnerServiceImpl implements GymOwnerService {
    public static List<GymOwner> gymOwnerList = new ArrayList<>();
    public static List<GymCentre> gymCentreList = new ArrayList<>();
    public static List<Slot> slotList = new ArrayList<>();

    @Override
    public void registerCentre(GymCentre centre) {
        gymCentreList.add(centre);
        System.out.println("Gym Centre Registered successfully: " + centre.getName());
    }

    public static List<com.flipfit.bean.Schedule> scheduleList = new ArrayList<>();

    @Override
    public void addSlot(Slot slot) {
        slotList.add(slot);
        System.out.println("Slot added: " + slot.getStartTime() + " - " + slot.getStartTime().plusHours(1));
    }

    @Override
    public void createSchedule(String slotId, java.time.LocalDate date) {
        // Find slot to verify?
        // Create Schedule
        com.flipfit.bean.Schedule schedule = new com.flipfit.bean.Schedule(java.util.UUID.randomUUID().toString(),
                slotId, date, 2); // Default 2 seats
        scheduleList.add(schedule);
        System.out.println("Schedule created for Slot " + slotId + " on " + date);
    }

    @Override
    public void createGymOwner(com.flipfit.bean.GymOwner owner) {
        gymOwnerList.add(owner);
        System.out.println("Creating Gym Owner: " + owner.getName());
    }

    public boolean validateLogin(String username, String password) {
        for (GymOwner owner : gymOwnerList) {
            if (owner.getUsername().equals(username) && owner.getPasswordHash().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<GymCentre> getCentresByOwnerId(String ownerId) {
        List<GymCentre> result = new ArrayList<>();
        for (GymCentre centre : gymCentreList) {
            if (centre.getOwnerId().equals(ownerId)) {
                result.add(centre);
            }
        }
        return result;
    }
}