package com.flipfit.constants;

public class SQLConstants {
    // Admin DAO Queries
    public static final String ADMIN_LOGIN_QUERY = "SELECT * FROM User u JOIN GymAdmin a ON u.userId = a.userId WHERE u.username = ? AND u.hashedPassword = ?";
    public static final String APPROVE_GYM_OWNER_QUERY = "UPDATE GymOwner SET isVerified = TRUE WHERE userId = ?";
    public static final String APPROVE_GYM_CENTRE_QUERY = "UPDATE GymCentre SET isApproved = TRUE WHERE centreId = ?";
    public static final String GET_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE o.isVerified = FALSE";
    public static final String GET_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM GymCentre WHERE isApproved = FALSE";

    // Customer DAO Queries
    public static final String REGISTER_USER_QUERY = "INSERT INTO User (userId, username, name, email, hashedPassword) VALUES (?, ?, ?, ?, ?)";
    public static final String REGISTER_CUSTOMER_QUERY = "INSERT INTO GymCustomer (userId, walletBalance) VALUES (?, ?)";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ? AND u.hashedPassword = ?";
    public static final String GET_CUSTOMER_BY_USERNAME_QUERY = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ?";
    public static final String UPDATE_WALLET_BALANCE_QUERY = "UPDATE GymCustomer SET walletBalance = walletBalance + ? WHERE userId = ?";

    // Gym Owner DAO Queries
    public static final String REGISTER_GYM_OWNER_QUERY = "INSERT INTO GymOwner (userId, panCard, isVerified) VALUES (?, ?, ?)";
    public static final String GYM_OWNER_LOGIN_QUERY = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE u.username = ? AND u.hashedPassword = ?";
}
