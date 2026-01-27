package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import com.flipfit.bean.Schedule;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;
import com.flipfit.exception.RegistrationNotDoneException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GymOwnerServiceImpl.
 *
 * @author Shravya
 * @ClassName "GymOwnerServiceImpl"
 */
public class GymOwnerServiceImpl implements GymOwnerService {

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();

    // Keeping these lists temporarily to avoid breaking other services not yet
    // migrated to MySQL
    public static List<GymCentre> gymCentreList = new ArrayList<>();
    public static List<Slot> slotList = new ArrayList<>();
    public static List<Schedule> scheduleList = new ArrayList<>();
    public static List<GymOwner> gymOwnerList = new ArrayList<>();

    /**
     * Registers centre.
     *
     * @param centre the centre
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerCentre(GymCentre centre) {
        try {
            gymCentreList.add(centre);
            System.out.println("Gym Centre Registered successfully: " + centre.getName());
        } catch (Exception e) {
            throw new RegistrationNotDoneException("Registration failed for centre: " + centre.getName());
        }
    }

    /**
     * Adds slot.
     *
     * @param slot the slot
     */
    @Override
    public void addSlot(Slot slot) {
        slotList.add(slot);
        System.out.println("Slot added.");
    }

    /**
     * Creates schedule.
     *
     * @param slotId the slot ID
     * @param date   the date
     */
    @Override
    public void createSchedule(String slotId, java.time.LocalDate date) {
        Schedule schedule = new Schedule(java.util.UUID.randomUUID().toString(), slotId, date, 2);
        scheduleList.add(schedule);
        System.out.println("Schedule created.");
    }

    /**
     * Gets centres by owner id.
     *
     * @param ownerId the owner ID
     * @return the centres by owner id
     */
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

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerGymOwner(GymOwner owner) {
        try {
            gymOwnerDAO.registerGymOwner(owner);
            gymOwnerList.add(owner); // Still adding to list for compatibility with broken pieces
            System.out.println("Gym Owner registered successfully for: " + owner.getName());
        } catch (Exception e) {
            throw new RegistrationNotDoneException("Registration failed for gym owner: " + owner.getName());
        }
    }

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    @Override
    public boolean validateLogin(String username, String password) {
        return gymOwnerDAO.validateLogin(username, password);
    }
}