package com.flipfit.constants;

public class SQLConstants {
    // Admin DAO Queries
    public static final String ADMIN_LOGIN_QUERY = "SELECT * FROM User u JOIN GymAdmin a ON u.userId = a.userId WHERE u.username = ? AND u.hashedPassword = ?";
    public static final String APPROVE_GYM_OWNER_QUERY = "UPDATE GymOwner SET isVerified = TRUE WHERE userId = ?";
    public static final String APPROVE_GYM_CENTRE_QUERY = "UPDATE GymCentre SET isApproved = TRUE WHERE centreId = ?";
    public static final String GET_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE o.isVerified = FALSE";
    public static final String GET_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM GymCentre WHERE isApproved = FALSE";

    // Customer DAO Queries
    public static final String REGISTER_USER_QUERY = "INSERT INTO User (userId, username, name, email, hashedPassword, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String REGISTER_CUSTOMER_QUERY = "INSERT INTO GymCustomer (userId, walletBalance) VALUES (?, ?)";
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ? AND u.hashedPassword = ?";
    public static final String GET_CUSTOMER_BY_USERNAME_QUERY = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ?";
    public static final String UPDATE_WALLET_BALANCE_QUERY = "UPDATE GymCustomer SET walletBalance = walletBalance + ? WHERE userId = ?";

    // Gym Owner DAO Queries
    public static final String REGISTER_GYM_OWNER_QUERY = "INSERT INTO GymOwner (userId, panCard, isVerified, aadharCard) VALUES (?, ?, ?, ?)";
    public static final String GYM_OWNER_LOGIN_QUERY = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE u.username = ? AND u.hashedPassword = ?";
    public static final String GET_GYM_OWNER_BY_USERNAME_QUERY = "SELECT * FROM User u JOIN GymOwner o ON u.userId = o.userId WHERE u.username = ?";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO GymCentre (centreId, ownerId, name, city, isApproved) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_GYMS_BY_OWNER_QUERY = "SELECT * FROM GymCentre WHERE ownerId = ?";

    // Slot DAO Queries
    public static final String ADD_SLOT_QUERY = "INSERT INTO Slot (slotId, centreId, startTime, endTime) VALUES (?, ?, ?, ?)";
    public static final String GET_SLOTS_BY_CENTRE_QUERY = "SELECT * FROM Slot WHERE centreId = ?";
    public static final String GET_SLOT_BY_ID_QUERY = "SELECT * FROM Slot WHERE slotId = ?";

    // Schedule DAO Queries
    public static final String ADD_SCHEDULE_QUERY = "INSERT INTO Schedule (scheduleId, slotId, date, availableSeats) VALUES (?, ?, ?, ?)";
    public static final String GET_SCHEDULE_BY_ID_QUERY = "SELECT * FROM Schedule WHERE scheduleId = ?";
    public static final String GET_SCHEDULES_BY_DATE_QUERY = "SELECT * FROM Schedule WHERE date = ?";
    public static final String UPDATE_SCHEDULE_SEATS_QUERY = "UPDATE Schedule SET availableSeats = ? WHERE scheduleId = ?";

    // Booking DAO Queries
    public static final String ADD_BOOKING_QUERY = "INSERT INTO Booking (bookingId, userId, scheduleId, gymId, date, status) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_BOOKINGS_BY_USER_QUERY = "SELECT * FROM Booking WHERE userId = ?";
    public static final String GET_BOOKING_BY_ID_QUERY = "SELECT * FROM Booking WHERE bookingId = ?";
    public static final String CANCEL_BOOKING_QUERY = "UPDATE Booking SET status = 'CANCELLED' WHERE bookingId = ?";

    // Notification DAO Queries
    public static final String ADD_NOTIFICATION_QUERY = "INSERT INTO Notification (notificationId, userId, message, type, status) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_NOTIFICATIONS_QUERY = "SELECT message FROM Notification WHERE userId = ?";

    // Payment DAO Queries
    public static final String ADD_PAYMENT_QUERY = "INSERT INTO Payment (paymentId, bookingId, amount, status) VALUES (?, ?, ?, ?)";

    // Gym Centre Queries (General)
    public static final String GET_GYMS_BY_CITY_QUERY = "SELECT * FROM GymCentre WHERE city = ? AND isApproved = TRUE";
    public static final String GET_ALL_GYM_CENTRES_QUERY = "SELECT * FROM GymCentre";
    public static final String GET_ALL_BOOKINGS_QUERY = "SELECT * FROM Booking";

    // Waitlist DAO Queries
    public static final String ADD_WAITLIST_QUERY = "INSERT INTO Waitlist (waitlistId, userId, scheduleId) VALUES (?, ?, ?)";
    public static final String GET_WAITLIST_BY_SCHEDULE_QUERY = "SELECT * FROM Waitlist WHERE scheduleId = ? ORDER BY requestDate ASC";
    public static final String DELETE_WAITLIST_QUERY = "DELETE FROM Waitlist WHERE waitlistId = ?";
}
