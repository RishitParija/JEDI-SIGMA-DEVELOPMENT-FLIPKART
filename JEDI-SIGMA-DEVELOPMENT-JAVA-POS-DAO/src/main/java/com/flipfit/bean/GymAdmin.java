package com.flipfit.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class GymAdmin.
 *
 * @author Rishit
 * @ClassName "GymAdmin"
 */
public class GymAdmin extends User {
    private String employeeId;

    /**
     * Instantiates a new gym admin.
     *
     * @param userId       the user ID
     * @param username     the username
     * @param name         the name
     * @param email        the email
     * @param passwordHash the password hash
     * @param employeeId   the employee ID
     */
    public GymAdmin(String userId, String username, String name, String email, String passwordHash, String employeeId) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.employeeId = employeeId;
    }

    /**
     * Gets the employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee id.
     *
     * @param employeeId the new employee id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
