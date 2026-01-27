package com.flipfit.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class GymOwner.
 *
 * @author Shravya
 * @ClassName "GymOwner"
 */
public class GymOwner extends User {
    private String panCard;
    private Boolean isVerified;

    /**
     * Instantiates a new gym owner.
     *
     * @param userId       the user ID
     * @param username     the username
     * @param name         the name
     * @param email        the email
     * @param passwordHash the password hash
     * @param panCard      the pan card
     */
    public GymOwner(String userId, String username, String name, String email, String passwordHash, String panCard) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.panCard = panCard;
        this.isVerified = false;
    }

    /**
     * Gets the pan card.
     *
     * @return the pan card
     */
    public String getPanCard() {
        return panCard;
    }

    /**
     * Gets the checks if is verified.
     *
     * @return the checks if is verified
     */
    public Boolean getIsVerified() {
        return isVerified;
    }

    /**
     * Sets the checks if is verified.
     *
     * @param isVerified the new checks if is verified
     */
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
