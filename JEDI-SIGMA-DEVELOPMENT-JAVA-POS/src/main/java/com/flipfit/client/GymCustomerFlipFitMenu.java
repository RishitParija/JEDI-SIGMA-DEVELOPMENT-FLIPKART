package com.flipfit.client;

import java.util.Scanner;
import java.util.List;
import com.flipfit.business.GymCustomerService;
import com.flipfit.business.GymCustomerServiceImpl;
import com.flipfit.business.BookingService;
import com.flipfit.business.BookingServiceImpl;
import com.flipfit.bean.GymCustomer;

public class GymCustomerFlipFitMenu {

    GymCustomerService service = new GymCustomerServiceImpl();
    BookingService bookingService = new BookingServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void customerMenu(GymCustomer customer) {
        int choice;

        do {
            System.out.println("\n--- Customer Menu (" + customer.getName() + ") ---");
            System.out.println("1. View Gyms by City");
            System.out.println("2. Book Slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");
            System.out.println("5. Exit (Back to Main Menu)");
            System.out.print("Enter your choice: ");

            // Check if input is int
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                // View Gyms logic with optional booking
                System.out.println("Enter City Name:");
                String city = scanner.nextLine();

                List<com.flipfit.bean.GymCentre> gyms = service.getGymsByCity(city);
                if (gyms.isEmpty()) {
                    System.out.println("No gyms found in " + city);
                } else {
                    System.out.println("--- Gyms in " + city + " ---");
                    for (int i = 0; i < gyms.size(); i++) {
                        System.out.println(
                                (i + 1) + ". " + gyms.get(i).getName() + " (ID: " + gyms.get(i).getCentreId() + ")");
                    }

                    System.out.println("Do you want to book a slot at any of these gyms? (y/n):");
                    String resp = scanner.next();
                    if (resp.equalsIgnoreCase("y")) {
                        System.out.println("Enter Gym Number to Select:");
                        if (scanner.hasNextInt()) {
                            int gymIdx = scanner.nextInt();
                            scanner.nextLine(); // consume
                            if (gymIdx > 0 && gymIdx <= gyms.size()) {
                                String selectedGymId = gyms.get(gymIdx - 1).getCentreId();
                                bookSlotFlow(customer, selectedGymId, scanner); // Helper method to avoid duplication
                            } else {
                                System.out.println("Invalid choice.");
                            }
                        } else {
                            scanner.next();
                            System.out.println("Invalid input.");
                        }
                    }
                }

            } else if (choice == 2) {
                // Direct Booking Flow
                System.out.println("Enter City Name:");
                String city = scanner.nextLine();
                List<com.flipfit.bean.GymCentre> gyms = service.getGymsByCity(city);

                if (gyms.isEmpty()) {
                    System.out.println("No gyms found.");
                    continue;
                }

                System.out.println("Select a Gym:");
                for (int i = 0; i < gyms.size(); i++) {
                    System.out.println((i + 1) + ". " + gyms.get(i).getName());
                }

                int gymIdx = -1;
                if (scanner.hasNextInt()) {
                    gymIdx = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.next();
                }

                if (gymIdx < 1 || gymIdx > gyms.size()) {
                    System.out.println("Invalid selection.");
                    continue;
                }

                String gymId = gyms.get(gymIdx - 1).getCentreId();
                bookSlotFlow(customer, gymId, scanner);

            } else if (choice == 3) {
                // Cancel Booking
                System.out.println("--- Cancel Booking ---");
                List<com.flipfit.bean.Booking> myBookings = bookingService.getBookingsByUserId(customer.getUserId());
                if (myBookings.isEmpty()) {
                    System.out.println("No active bookings to cancel.");
                } else {
                    for (int i = 0; i < myBookings.size(); i++) {
                        System.out.println((i + 1) + ". Booking ID: " + myBookings.get(i).getBookingId() + " ("
                                + myBookings.get(i).getDate() + ") - " + myBookings.get(i).getStatus());
                    }
                    System.out.println("Enter booking number to cancel (or 0 to exit):");
                    int cancelChoice = -1;
                    if (scanner.hasNextInt()) {
                        cancelChoice = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.next();
                    }

                    if (cancelChoice > 0 && cancelChoice <= myBookings.size()) {
                        String bookingId = myBookings.get(cancelChoice - 1).getBookingId();
                        boolean result = bookingService.cancelBooking(bookingId);
                        if (result)
                            System.out.println("Booking cancelled successfully.");
                        else
                            System.out.println("Cancellation failed or already cancelled.");
                    } else if (cancelChoice != 0) {
                        System.out.println("Invalid choice.");
                    }
                }

            } else if (choice == 4) {
                // View My Bookings
                System.out.println("--- My Bookings ---");
                for (com.flipfit.bean.Booking b : bookingService.getBookingsByUserId(customer.getUserId())) {
                    System.out.println(
                            "Booking ID: " + b.getBookingId() + " Date: " + b.getDate() + " Status: " + b.getStatus());
                }

            } else if (choice == 5) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }

    private void bookSlotFlow(GymCustomer customer, String gymId, Scanner scanner) {
        // 3. Ask Date (Robust)
        java.time.LocalDate date = null;
        while (date == null) {
            System.out.println("Enter Date (YYYY-MM-DD):");
            if (scanner.hasNext()) { // Verify input exists
                String dateStr = scanner.next();
                try {
                    date = java.time.LocalDate.parse(dateStr);
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                }
            }
        }

        // 4. Show Available Slots
        List<com.flipfit.bean.Schedule> allSchedules = new java.util.ArrayList<>();
        System.out.println("--- Slots for " + date + " ---");

        for (com.flipfit.bean.Schedule schedule : com.flipfit.business.GymOwnerServiceImpl.scheduleList) {
            if (schedule.getDate().equals(date)) {
                // Find matching slot/gym
                for (com.flipfit.bean.Slot slot : com.flipfit.business.GymOwnerServiceImpl.slotList) {
                    if (slot.getSlotId().equals(schedule.getSlotId()) && slot.getCentreId().equals(gymId)) {
                        allSchedules.add(schedule);
                        String status = (schedule.getAvailableSeats() > 0)
                                ? "Available (" + schedule.getAvailableSeats() + ")"
                                : "FULL - Waitlist Available";
                        System.out
                                .println(allSchedules.size() + ". Time: " + slot.getStartTime() + " [" + status + "]");
                    }
                }
            }
        }

        if (allSchedules.isEmpty()) {
            System.out.println("No slots found for this date.");
        } else {
            // 5. Select Slot/Schedule
            System.out.println("Select a Slot Number to Book:");
            int slotChoice = -1;
            if (scanner.hasNextInt()) {
                slotChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.next();
            }

            if (slotChoice > 0 && slotChoice <= allSchedules.size()) {
                com.flipfit.bean.Schedule selectedSchedule = allSchedules.get(slotChoice - 1);

                if (selectedSchedule.getAvailableSeats() > 0) {
                    bookingService.addBooking(customer.getUserId(), selectedSchedule.getScheduleId());
                } else {
                    System.out.println("Slot is FULL. Do you want to join the Waitlist? (y/n)");
                    String wlResp = scanner.next();
                    if (wlResp.equalsIgnoreCase("y")) {
                        com.flipfit.business.WaitlistService wlService = new com.flipfit.business.WaitlistServiceImpl();
                        wlService.addToWaitlist(customer.getUserId(), selectedSchedule.getScheduleId());
                    }
                }
            } else {
                System.out.println("Invalid slot selection.");
            }
        }
    }

    public void registerCustomer() {
        // This can remain or be moved. FlipFitApp calls this separately.
        // FlipFitApp impl of Register calls service directly. So this might be unused
        // or duplicate.
        // Leaving it empty or removing if unused in FlipFitApp's current state.
        // FlipFitApp does: `customerMenu.registerCustomer();` in one branch.
        // Wait, FlipFitApp implements registration ITSELF in the `main` method in my
        // previous edit.
        // So `registerCustomer` here is likely redundant or I should restore it if I
        // want it here.
        // Inspect FlipFitApp: It has registration logic inside `choice == 2`.
        // So I can remove this method or leave it empty.
    }
}