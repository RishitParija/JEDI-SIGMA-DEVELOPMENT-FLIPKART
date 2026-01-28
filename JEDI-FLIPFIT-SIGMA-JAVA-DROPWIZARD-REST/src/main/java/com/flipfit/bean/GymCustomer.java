package com.flipfit.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class GymCustomer.
 *
 * @author Rishit
 * @ClassName "GymCustomer"
 */
public class GymCustomer extends User {
    private Double walletBalance;

    /**
     * Instantiates a new gym customer.
     *
     * @param userId        the user id
     * @param username      the username
     * @param name          the name
     * @param email         the email
     * @param passwordHash  the password hash
     * @param walletBalance the wallet balance
     * @param phoneNumber   the phone number
     */
    public GymCustomer() {
    }

    public GymCustomer(String userId, String username, String name, String email, String passwordHash,
            Double walletBalance, String phoneNumber) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.walletBalance = walletBalance;
        this.setPhoneNumber(phoneNumber);
    }

    /**
     * Gets the wallet balance.
     *
     * @return the wallet balance
     */
    public Double getWalletBalance() {
        return walletBalance;
    }

    /**
     * Sets the wallet balance.
     *
     * @param walletBalance the new wallet balance
     */
    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
