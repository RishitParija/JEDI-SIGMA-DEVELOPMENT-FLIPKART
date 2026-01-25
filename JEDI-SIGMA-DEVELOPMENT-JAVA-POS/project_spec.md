# Project Specification: FlipFit POS System

## 1. Overview
FlipFit POS (JEDI-SIGMA-DEVELOPMENT-JAVA-POS) is a Java-based Gym Management System designed to facilitate the booking of gym slots by customers and the management of gym centres by owners. The system follows a modular architecture separating data, logic, and client interaction.

## 2. Architecture
The project follows a standard **Layered Architecture**:
-   **Client Layer** (`com.flipfit.client`): Handles user interaction (Console-based UI).
-   **Business Layer** (`com.flipfit.business`): Contains core application logic and orchestrates data flow.
-   **Data Access Layer (DAO)** (`com.flipfit.dao`): Interfaces with the data source (Database/Collections).
-   **Bean Layer** (`com.flipfit.bean`): Represents the domain entities (POJOs).
-   **Exception Layer** (`com.flipfit.exception`): Custom error handling.

## 3. Class Structure & Relationships
Based on the class diagram, the core entities are:

### 3.1 Actors
All actors inherit from the abstract **User** class (containing `userId`, `name`, `email`, `passwordHash`, `role`).
-   **GymAdmin**:
    -   Approves `GymOwner` registrations.
    -   Configures system settings.
    -   Views activity logs.
-   **GymOwner**:
    -   Registers and manages `GymCentre`.
    -   Adds `Slot`s availability.
    -   Views bookings for their centres.
-   **GymCustomer**:
    -   Views available centres and slots.
    -   Makes `Booking`s.
    -   Manages profile and wallet.

### 3.2 Core Entities
-   **GymCentre**:
    -   Owned by `GymOwner`.
    -   Contains multiple `Slot`s.
    -   Attributes: `centreId`, `location`, `city`, `approvalStatus`.
-   **Slot**:
    -   Represents a time interval for a gym session.
    -   Template for expanding into `Schedule`.
-   **Schedule**:
    -   A specific date instance of a `Slot`.
    -   Tracks `availableSeats`.
-   **Booking**:
    -   Made by `GymCustomer` for a `Schedule`.
    -   Linked to `Payment`.
    -   Status: Confirmed, Cancelled, Waitlisted.
-   **Payment**:
    -   Handles transaction details for a booking.
-   **Waitlist**:
    -   Queue system for fully booked schedules.
-   **Notification**:
    -   Alerts sent to users (triggers on booking updates, etc.).

## 4. Project Folder Structure
The codebase is organized under `src/main/java/com/flipfit/`:

| Package | Description |
| :--- | :--- |
| `com.flipfit.bean` | Domain models (e.g., `GymCentre`, `User`, `Booking`). |
| `com.flipfit.business` | Services implementing business rules (e.g., `GymAdminService`, `BookingService`). |
| `com.flipfit.client` | Entry points and UI menus for different roles. |
| `com.flipfit.dao` | Persistence layer interfaces and implementations. |
| `com.flipfit.exception` | Custom exceptions (e.g., `InvalidSlotException`). |
| `com.flipfit.constants` | System-wide constants (e.g., SQL queries, roles). |
| `com.flipfit.helper` | Utility classes. |
| `com.flipfit.validation` | Input validation logic. |

## 5. Technology Stack
-   **Language**: Java
-   **Build Tool**: Maven
-   **Persistence**: JDBC (Inferred from DAO presence) or InMemory (if prototype).
