package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.Slot;
import com.flipfit.bean.Schedule;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;
import com.flipfit.dao.GymCentreDAO;
import com.flipfit.dao.GymCentreDAOImpl;
import com.flipfit.dao.SlotDAO;
import com.flipfit.dao.SlotDAOImpl;
import com.flipfit.dao.ScheduleDAO;
import com.flipfit.dao.ScheduleDAOImpl;
import com.flipfit.exception.InvalidDataException;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.validation.Validator;
import java.util.List;

/**
 * The Class GymOwnerServiceImpl.
 *
 * @author Rishit
 * @ClassName "GymOwnerServiceImpl"
 */
public class GymOwnerServiceImpl implements GymOwnerService {

    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAOImpl();
    private GymCentreDAO gymCentreDAO = new GymCentreDAOImpl();
    private SlotDAO slotDAO = new SlotDAOImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    /**
     * Registers centre.
     *
     * @param centre the centre
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerCentre(GymCentre centre) {
        try {
            gymCentreDAO.addGymCentre(centre);
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
        slotDAO.addSlot(slot);
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
        scheduleDAO.addSchedule(schedule);
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
        return gymCentreDAO.getGymsByOwnerId(ownerId);
    }

    /**
     * Registers gym owner.
     *
     * @param owner the gym owner
     * @throws InvalidDataException         if validation fails
     * @throws RegistrationNotDoneException if registration fails
     */
    @Override
    public void registerGymOwner(GymOwner owner) {
        if (!Validator.isEmailValid(owner.getEmail())) {
            throw new InvalidDataException("Invalid Email format.");
        }
        if (!Validator.isPanValid(owner.getPanCard())) {
            throw new InvalidDataException("Invalid PAN card format (e.g., ABCDE1234F).");
        }
        if (!Validator.isPhoneValid(owner.getPhoneNumber())) {
            throw new InvalidDataException("Phone number must be 10 digits.");
        }
        if (!Validator.isAadharValid(owner.getAadharCard())) {
            throw new InvalidDataException("Aadhar card must be 12 digits.");
        }

        try {
            gymOwnerDAO.registerGymOwner(owner);
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

    @Override
    public GymOwner getGymOwnerByUsername(String username) {
        return gymOwnerDAO.getGymOwnerByUsername(username);
    }

    @Override
    public List<Slot> getSlotsByCentreId(String centreId) {
        return slotDAO.getSlotsByCentreId(centreId);
    }
}