-- Create Database
CREATE DATABASE IF NOT EXISTS FlipFit;
USE FlipFit;

-- Base User Table
CREATE TABLE User (
    userId VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    hashedPassword VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255)
);

-- Specialized User Tables (Joined Table Inheritance)
CREATE TABLE GymCustomer (
    userId VARCHAR(255) PRIMARY KEY,
    walletBalance DOUBLE DEFAULT 0.0,
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

CREATE TABLE GymOwner (
    userId VARCHAR(255) PRIMARY KEY,
    panCard VARCHAR(255) NOT NULL,
    isVerified BOOLEAN DEFAULT FALSE,
    aadharCard VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

CREATE TABLE GymAdmin (
    userId VARCHAR(255) PRIMARY KEY,
    employeeId VARCHAR(255) NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

-- Gym Centre Table
CREATE TABLE GymCentre (
    centreId VARCHAR(255) PRIMARY KEY,
    ownerId VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    isApproved BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (ownerId) REFERENCES GymOwner(userId) ON DELETE CASCADE
);

-- Slot Table
CREATE TABLE Slot (
    slotId VARCHAR(255) PRIMARY KEY,
    centreId VARCHAR(255) NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    FOREIGN KEY (centreId) REFERENCES GymCentre(centreId) ON DELETE CASCADE
);

-- Schedule Table
CREATE TABLE Schedule (
    scheduleId VARCHAR(255) PRIMARY KEY,
    slotId VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    availableSeats INT NOT NULL,
    isCancelled BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (slotId) REFERENCES Slot(slotId) ON DELETE CASCADE
);

-- Booking Table
CREATE TABLE Booking (
    bookingId VARCHAR(255) PRIMARY KEY,
    userId VARCHAR(255) NOT NULL,
    scheduleId VARCHAR(255) NOT NULL,
    gymId VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(50) NOT NULL, -- e.g., "CONFIRMED", "CANCELLED", "PENDING"
    FOREIGN KEY (userId) REFERENCES GymCustomer(userId) ON DELETE CASCADE,
    FOREIGN KEY (scheduleId) REFERENCES Schedule(scheduleId) ON DELETE CASCADE,
    FOREIGN KEY (gymId) REFERENCES GymCentre(centreId) ON DELETE CASCADE
);

-- Payment Table
CREATE TABLE Payment (
    paymentId VARCHAR(255) PRIMARY KEY,
    bookingId VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL, -- "SUCCESS", "FAILED", "REFUNDED"
    FOREIGN KEY (bookingId) REFERENCES Booking(bookingId) ON DELETE CASCADE
);

-- Notification Table
CREATE TABLE Notification (
    notificationId VARCHAR(255) PRIMARY KEY,
    userId VARCHAR(255), -- Optional: can be NULL if broadcast
    message TEXT NOT NULL,
    sentAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(50),
    status VARCHAR(50),
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

-- Waitlist Table
CREATE TABLE Waitlist (
    waitlistId VARCHAR(255) PRIMARY KEY,
    userId VARCHAR(255) NOT NULL,
    scheduleId VARCHAR(255) NOT NULL,
    requestDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES GymCustomer(userId) ON DELETE CASCADE,
    FOREIGN KEY (scheduleId) REFERENCES Schedule(scheduleId) ON DELETE CASCADE
);

-- Default Admin Seeding
INSERT INTO User (userId, username, name, email, hashedPassword, phoneNumber) 
VALUES ('admin101', 'Rishit', 'Rishit', 'rishit@flipfit.com', 'Rishit123', '9999999999');

INSERT INTO GymAdmin (userId, employeeId) 
VALUES ('admin101', 'EMP101');
