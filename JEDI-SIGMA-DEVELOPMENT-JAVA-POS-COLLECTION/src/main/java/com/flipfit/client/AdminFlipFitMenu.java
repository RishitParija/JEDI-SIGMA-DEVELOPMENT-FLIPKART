package com.flipfit.client;

import java.util.Scanner;
import java.util.List;
import com.flipfit.business.AdminService;
import com.flipfit.business.AdminServiceImpl;

public class AdminFlipFitMenu {

    AdminService service = new AdminServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        int choice;

        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View all Gyms");
            System.out.println("2. View Pending Gym Owners");
            System.out.println("3. View Pending Gym Centres");
            System.out.println("4. View All Bookings");
            System.out.println("5. Approve Gym Owner");
            System.out.println("6. Approve Gym Center");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                service.viewAllGyms();
            } else if (choice == 2) {
                service.viewPendingGymOwners();
            } else if (choice == 3) {
                service.viewPendingGymCentres();
            } else if (choice == 4) {
                service.viewAllBookings();
            } else if (choice == 5) {
                // Approve Gym Owner
                List<com.flipfit.bean.GymOwner> pendingOwners = service.getPendingGymOwners();
                if (pendingOwners.isEmpty()) {
                    System.out.println("No pending gym owners found.");
                } else {
                    System.out.println("--- Pending Gym Owners ---");
                    for (int i = 0; i < pendingOwners.size(); i++) {
                        System.out.println((i + 1) + ". " + pendingOwners.get(i).getName() + " ("
                                + pendingOwners.get(i).getEmail() + ")");
                    }
                    System.out.println("Enter number to approve (or 0 to cancel):");
                    int approveChoice = -1;
                    if (scanner.hasNextInt()) {
                        approveChoice = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.next();
                    }

                    if (approveChoice > 0 && approveChoice <= pendingOwners.size()) {
                        service.approveGymOwner(pendingOwners.get(approveChoice - 1).getUserId());
                    } else if (approveChoice != 0) {
                        System.out.println("Invalid selection.");
                    }
                }

            } else if (choice == 6) {
                // Approve Gym Centre
                List<com.flipfit.bean.GymCentre> pendingCentres = service.getPendingGymCentres();
                if (pendingCentres.isEmpty()) {
                    System.out.println("No pending gym centres found.");
                } else {
                    System.out.println("--- Pending Gym Centres ---");
                    for (int i = 0; i < pendingCentres.size(); i++) {
                        System.out.println((i + 1) + ". " + pendingCentres.get(i).getName() + " ("
                                + pendingCentres.get(i).getCity() + ")");
                    }
                    System.out.println("Enter number to approve (or 0 to cancel):");
                    int approveChoice = -1;
                    if (scanner.hasNextInt()) {
                        approveChoice = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.next();
                    }

                    if (approveChoice > 0 && approveChoice <= pendingCentres.size()) {
                        service.approveGymCentre(pendingCentres.get(approveChoice - 1).getCentreId());
                    } else if (approveChoice != 0) {
                        System.out.println("Invalid selection.");
                    }
                }
            } else if (choice == 7) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }
}