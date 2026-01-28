package com.flipfit.client;

import java.util.Scanner;
import java.util.List;
import com.flipfit.business.GymCustomerService;
import com.flipfit.business.GymCustomerServiceImpl;
import com.flipfit.business.BookingService;
import com.flipfit.business.BookingServiceImpl;
import com.flipfit.bean.GymCustomer;
import com.flipfit.business.NotificationService;
import com.flipfit.business.NotificationServiceImpl;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymOwnerServiceImpl;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class GymCustomerFlipFitMenu.
 *
 * @author Rishit
 * @ClassName "GymCustomerFlipFitMenu"
 */
public class GymCustomerFlipFitMenu {

    GymCustomerService service = new GymCustomerServiceImpl();
    BookingService bookingService = new BookingServiceImpl();
    NotificationService notificationService = new NotificationServiceImpl();
    GymOwnerService gymOwnerService = new GymOwnerServiceImpl();
    Scanner scanner = new Scanner(System.in);

    // Method level Commenting

    /**
     * Customer menu logic.
     *
     * @param customer the customer
     */
    public void customerMenu(GymCustomer customer) {
        int choice;

        do {
            System.out.println("\n--- Customer Menu (" + customer.getName() + ") ---");
            System.out.println("1. View Gyms by City");
            System.out.println("2. Book Slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");
            System.out.println("5. View Notifications");
            System.out.println("6. Exit (Back to Main Menu)");
            System.out.print("Enter your choice: ");
            System.out.println();

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter City Name:");
                String city = scanner.nextLine();

                List<com.flipfit.bean.GymCentre> gyms = service.getGymsByCity(city);
                if (gyms.isEmpty()) {
                    System.out.println("No gyms found in " + city);
                } else {
                    System.out.println("--- Gyms in " + city + " ---");
                    int i = 1;
                    for (com.flipfit.bean.GymCentre gym : gyms) {
                        System.out.println(
                                i + ". " + gym.getName() + " (ID: " + gym.getCentreId() + ")");
                        i++;
                    }

                    System.out.println("Do you want to book a slot at any of these gyms? (y/n):");
                    String resp = scanner.next();
                    if (resp.equalsIgnoreCase("y")) {
                        System.out.println("Enter Gym Number to Select:");
                        if (scanner.hasNextInt()) {
                            int gymIdx = scanner.nextInt();
                            scanner.nextLine();
                            if (gymIdx > 0 && gymIdx <= gyms.size()) {
                                String selectedGymId = gyms.get(gymIdx - 1).getCentreId();
                                bookSlotFlow(customer, selectedGymId, scanner);
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
                System.out.println("Enter City Name:");
                String city = scanner.nextLine();
                List<com.flipfit.bean.GymCentre> gyms = service.getGymsByCity(city);

                if (gyms.isEmpty()) {
                    System.out.println("No gyms found.");
                    continue;
                }

                System.out.println("Select a Gym:");
                int i = 1;
                for (com.flipfit.bean.GymCentre gym : gyms) {
                    System.out.println(i + ". " + gym.getName());
                    i++;
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
                System.out.println("--- Cancel Booking ---");
                List<com.flipfit.bean.Booking> allMyBookings = bookingService.getBookingsByUserId(customer.getUserId());
                List<com.flipfit.bean.Booking> confirmedBookings = new java.util.ArrayList<>();

                for (com.flipfit.bean.Booking b : allMyBookings) {
                    if (b.getStatus().equalsIgnoreCase("CONFIRMED")) {
                        confirmedBookings.add(b);
                    }
                }

                if (confirmedBookings.isEmpty()) {
                    System.out.println("No active confirmed bookings to cancel.");
                } else {
                    int i = 1;
                    for (com.flipfit.bean.Booking b : confirmedBookings) {
                        com.flipfit.bean.Schedule sche = bookingService.getScheduleById(b.getScheduleId());
                        String timeStr = "Unknown Time";
                        if (sche != null) {
                            com.flipfit.bean.Slot slot = bookingService.getSlotById(sche.getSlotId());
                            if (slot != null) {
                                timeStr = slot.getStartTime().toString();
                            }
                        }
                        System.out.println(i + ". Booking ID: " + b.getBookingId() + " [" + timeStr + "] ("
                                + b.getDate() + ") - " + b.getStatus());
                        i++;
                    }
                    System.out.println("Enter booking number to cancel (or 0 to exit):");
                    int cancelChoice = -1;
                    if (scanner.hasNextInt()) {
                        cancelChoice = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.next();
                    }

                    if (cancelChoice > 0 && cancelChoice <= confirmedBookings.size()) {
                        String bookingId = confirmedBookings.get(cancelChoice - 1).getBookingId();
                        boolean result = bookingService.cancelBooking(bookingId);
                        if (result)
                            System.out.println("Booking cancelled successfully.");
                        else
                            System.out.println("Cancellation failed or already cancelled.");
                        System.out.println();
                    } else if (cancelChoice != 0) {
                        System.out.println("Invalid choice.");
                    }
                }

            } else if (choice == 4) {
                System.out.println("--- My Bookings ---");
                for (com.flipfit.bean.Booking b : bookingService.getBookingsByUserId(customer.getUserId())) {
                    System.out.println(
                            "Booking ID: " + b.getBookingId() + " Date: " + b.getDate() + " Status: " + b.getStatus());
                }
                System.out.println();

            } else if (choice == 5) {
                System.out.println("--- Notifications ---");
                List<String> notifs = notificationService.getNotifications(customer.getUserId());
                if (notifs.isEmpty()) {
                    System.out.println("No notifications.");
                } else {
                    for (String msg : notifs) {
                        System.out.println("- " + msg);
                    }
                }
                System.out.println();

            } else if (choice == 6) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }

    // Method level Commenting

    /**
     * Book slot flow.
     *
     * @param customer the customer
     * @param gymId    the gym id
     * @param scanner  the scanner
     */
    private void bookSlotFlow(GymCustomer customer, String gymId, Scanner scanner) {
        java.time.LocalDate date = null;
        while (date == null) {
            System.out.println("Enter Date (YYYY-MM-DD):");
            if (scanner.hasNext()) {
                String dateStr = scanner.next();
                try {
                    date = java.time.LocalDate.parse(dateStr);
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                }
            }
        }

        List<com.flipfit.bean.Schedule> allSchedules = service.getSchedulesByGymAndDate(gymId, date);
        System.out.println("--- Slots for " + date + " ---");

        if (allSchedules.isEmpty()) {
            System.out.println("No slots found for this date.");
        } else {
            List<com.flipfit.bean.Slot> slots = gymOwnerService.getSlotsByCentreId(gymId);
            List<com.flipfit.bean.Schedule> displaySchedules = new java.util.ArrayList<>();

            int i = 1;
            for (com.flipfit.bean.Schedule schedule : allSchedules) {
                for (com.flipfit.bean.Slot slot : slots) {
                    if (slot.getSlotId().equals(schedule.getSlotId())) {
                        displaySchedules.add(schedule);
                        String status = (schedule.getAvailableSeats() > 0)
                                ? "Available (" + schedule.getAvailableSeats() + ")"
                                : "FULL - Waitlist Available";
                        System.out.println(
                                i + ". Time: " + slot.getStartTime() + " [" + status + "]");
                        i++;
                    }
                }
            }

            if (displaySchedules.isEmpty()) {
                System.out.println("No slots found for this gym on this date.");
                return;
            }

            System.out.println("Select a Slot Number to Book:");
            int slotChoice = -1;
            if (scanner.hasNextInt()) {
                slotChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.next();
            }

            if (slotChoice > 0 && slotChoice <= displaySchedules.size()) {
                com.flipfit.bean.Schedule selectedSchedule = displaySchedules.get(slotChoice - 1);

                if (selectedSchedule.getAvailableSeats() > 0) {
                    System.out.println("Proceed to Pay Rs. 500? (y/n)");
                    String payResp = scanner.next();
                    if (payResp.equalsIgnoreCase("y")) {
                        System.out.println("Processing Payment...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        System.out.println("Payment of RS. 500 successful");
                        notificationService.sendNotification(customer.getUserId(), "Payment of RS. 500 successful");

                        com.flipfit.bean.Booking booking = bookingService.addBooking(customer.getUserId(),
                                selectedSchedule.getScheduleId());
                        if (booking != null) {
                            notificationService.sendNotification(customer.getUserId(),
                                    "Booking Confirmed for Slot " + selectedSchedule.getScheduleId());
                        } else {
                            System.out.println("Booking Failed. Refund initiated.");
                            notificationService.sendNotification(customer.getUserId(),
                                    "Booking Failed. Refund initiated.");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Payment Cancelled.");
                        System.out.println();
                    }
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
}