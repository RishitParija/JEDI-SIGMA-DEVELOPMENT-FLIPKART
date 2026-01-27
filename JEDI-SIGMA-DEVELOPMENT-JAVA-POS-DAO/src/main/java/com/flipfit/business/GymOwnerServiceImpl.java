package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import com.flipfit.bean.Schedule;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class GymOwnerServiceImpl implements GymOwnerService {

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();

    // Keeping these lists temporarily to avoid breaking other services not yet
    // migrated to MySQL
    public static List<GymCentre> gymCentreList = new ArrayList<>();
    public static List<Slot> slotList = new ArrayList<>();
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<GymOwner> gymOwnerList = new ArrayList<>();

    @Override
    public void registerCentre(GymCentre centre) {
        gymCentreList.add(centre);
        System.out.println("Gym Centre Registered successfully: " + centre.getName());
    }

    @Override
    public void addSlot(Slot slot) {
        slotList.add(slot);
        System.out.println("Slot added.");
    }

    @Override
    public void createSchedule(String slotId, java.time.LocalDate date) {
        Schedule schedule = new Schedule(java.util.UUID.randomUUID().toString(), slotId, date, 2);
        scheduleList.add(schedule);
        System.out.println("Schedule created.");
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

    @Override
    public void registerGymOwner(GymOwner owner) {
        gymOwnerDAO.registerGymOwner(owner);
        gymOwnerList.add(owner); // Still adding to list for compatibility with broken pieces
        System.out.println("Gym Owner registered successfully for: " + owner.getName());
    }

    @Override
    public boolean validateLogin(String username, String password) {
        return gymOwnerDAO.validateLogin(username, password);
    }
}