package com.flipfit.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class GymCentre.
 *
 * @author Shravya
 * @ClassName "GymCentre"
 */
public class GymCentre {
    private String centreId;
    private String ownerId;
    private String name;
    private String city;
    private boolean isApproved;

    /**
     * Instantiates a new gym centre.
     */
    public GymCentre() {
    }

    // Getters and Setters
    /**
     * Gets the centre id.
     *
     * @return the centre id
     */
    public String getCentreId() {
        return centreId;
    }

    /**
     * Sets the centre id.
     *
     * @param centreId the new centre id
     */
    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    /**
     * Gets the owner id.
     *
     * @return the owner id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the owner id.
     *
     * @param ownerId the new owner id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Checks if is approved.
     *
     * @return true, if is approved
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Sets the approved.
     *
     * @param approved the new approved
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}