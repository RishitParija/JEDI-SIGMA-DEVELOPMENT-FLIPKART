package com.flipfit.client;

import java.util.Scanner;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymOwnerServiceImpl;
import java.util.List;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;

public class GymOwnerFlipFitMenu {

    GymOwnerService service = new GymOwnerServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void gymOwnerMenu(GymOwner owner) {
        int choice;

        do {
            System.out.println("\n--- Gym Owner Menu (" + owner.getName() + ") ---");
            System.out.println("1. Add Gym Centre");
            System.out.println("2. Add Slot & Schedule");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit (Back to Main Menu)");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            if (choice == 1) {

                System.out.println("Enter Gym Name:");
                String gymName = scanner.next();

                System.out.println("Enter City:");
                String city = scanner.next();

                GymCentre centre = new GymCentre();
                centre.setCentreId(java.util.UUID.randomUUID().toString()); // Generate ID
                centre.setOwnerId(owner.getUserId()); // Set Owner ID
                centre.setName(gymName);
                centre.setCity(city);
                centre.setApproved(false); // Default false

                service.registerCentre(centre);

            } else if (choice == 2) {
                // Add Slot & Schedule Logic with Gym Selection and Loop

                // 1. Get Gyms for this owner
                List<GymCentre> gyms = service.getCentresByOwnerId(owner.getUserId());
                if (gyms.isEmpty()) {
                    System.out.println("You have no registered gyms. Please add a gym first.");
                    continue; // Back to menu
                }

                String centerId = null;
                if (gyms.size() == 1) {
                    centerId = gyms.get(0).getCentreId();
                    System.out.println("Auto-selected gym: " + gyms.get(0).getName());
                } else {
                    System.out.println("Select a Gym:");
                    for (int i = 0; i < gyms.size(); i++) {
                        System.out.println((i + 1) + ". " + gyms.get(i).getName() + " (" + gyms.get(i).getCity() + ")");
                    }
                    int gymChoice = scanner.nextInt();
                    if (gymChoice < 1 || gymChoice > gyms.size()) {
                        System.out.println("Invalid gym choice.");
                        continue;
                    }
                    centerId = gyms.get(gymChoice - 1).getCentreId();
                }

                boolean addMore = true;
                while (addMore) {
                    System.out.println("\n--- Add Slot for Gym " + centerId + " ---");

                    java.time.LocalDate date = null;
                    while (date == null) {
                        System.out.println("Enter Date (YYYY-MM-DD): ");
                        String dateStr = scanner.next();
                        try {
                            date = java.time.LocalDate.parse(dateStr);
                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                        }
                    }

                    java.time.LocalTime startTime = null;
                    while (startTime == null) {
                        System.out.println("Enter Slot Start Time (HH:MM): ");
                        String timeStr = scanner.next();
                        try {
                            startTime = java.time.LocalTime.parse(timeStr);
                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println("Invalid time format. Please enter time in HH:MM format (24 hour).");
                        }
                    }

                    com.flipfit.bean.Slot slot = new com.flipfit.bean.Slot(java.util.UUID.randomUUID().toString(),
                            centerId,
                            startTime, startTime.plusHours(1));
                    service.addSlot(slot);
                    service.createSchedule(slot.getSlotId(), date);

                    System.out.println("Slot added successfully. Add another slot? (y/n):");
                    String resp = scanner.next();
                    if (!resp.equalsIgnoreCase("y")) {
                        addMore = false;
                    }
                }

            } else if (choice == 3) {
                // View Bookings
                // Refactor to use selection logic too for better UX
                List<GymCentre> gyms = service.getCentresByOwnerId(owner.getUserId());
                if (gyms.isEmpty()) {
                    System.out.println("No gyms found.");
                    continue;
                }

                String centerId = null;
                if (gyms.size() == 1) {
                    centerId = gyms.get(0).getCentreId();
                } else {
                    System.out.println("Select a Gym to view bookings:");
                    for (int i = 0; i < gyms.size(); i++) {
                        System.out.println((i + 1) + ". " + gyms.get(i).getName());
                    }
                    int gymChoice = scanner.nextInt();
                    centerId = gyms.get(gymChoice - 1).getCentreId();
                }

                com.flipfit.business.BookingService bs = new com.flipfit.business.BookingServiceImpl();
                List<com.flipfit.bean.Booking> bookings = bs.getBookingsByGym(centerId);
                System.out.println("--- Bookings for Gym " + centerId + " ---");
                for (com.flipfit.bean.Booking b : bookings) {
                    System.out.println(
                            "BookingID: " + b.getBookingId() + " User: " + b.getUserId() + " Date: " + b.getDate());
                }

            } else if (choice == 4) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }
}