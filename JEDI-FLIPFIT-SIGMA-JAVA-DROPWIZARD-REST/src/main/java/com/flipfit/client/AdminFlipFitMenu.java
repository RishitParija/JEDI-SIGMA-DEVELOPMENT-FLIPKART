package com.flipfit.client;

import java.util.Scanner;
import java.util.List;
import com.flipfit.business.AdminService;
import com.flipfit.business.AdminServiceImpl;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFlipFitMenu.
 *
 * @author Rishit
 * @ClassName "AdminFlipFitMenu"
 */
public class AdminFlipFitMenu {

    AdminService service = new AdminServiceImpl();
    Scanner scanner = new Scanner(System.in);

    // Method level Commenting

    /**
     * Admin menu logic.
     */
    public void adminMenu() {
        int choice;

        do {
            System.out.println("1. View all Gyms");
            System.out.println("2. View Verified Gym Owners");
            System.out.println("3. View Unverified Gym Owners");
            System.out.println("4. View Approved Gym Centres");
            System.out.println("5. View Pending Gym Centres");
            System.out.println("6. View All Bookings");
            System.out.println("7. Approve Gym Owner");
            System.out.println("8. Approve Gym Center");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            System.out.println();

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                service.viewAllGyms();
                System.out.println();
            } else if (choice == 2) {
                service.viewGymOwnersByStatus(true);
                System.out.println();
            } else if (choice == 3) {
                service.viewGymOwnersByStatus(false);
                System.out.println();
            } else if (choice == 4) {
                service.viewGymCentresByStatus(true);
                System.out.println();
            } else if (choice == 5) {
                service.viewGymCentresByStatus(false);
                System.out.println();
            } else if (choice == 6) {
                service.viewAllBookings();
                System.out.println();
            } else if (choice == 7) {
                // Approve Gym Owner
                List<com.flipfit.bean.GymOwner> pendingOwners = service.getPendingGymOwners();
                if (pendingOwners.isEmpty()) {
                    System.out.println("No pending gym owners found.");
                } else {
                    System.out.println("--- Pending Gym Owners ---");
                    int i = 1;
                    for (com.flipfit.bean.GymOwner owner : pendingOwners) {
                        System.out.println(i + ". " + owner.getName() + " ("
                                + owner.getEmail() + ")");
                        i++;
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
                        System.out.println();
                    } else if (approveChoice != 0) {
                        System.out.println("Invalid selection.");
                    }
                }

            } else if (choice == 8) {
                // Approve Gym Centre
                List<com.flipfit.bean.GymCentre> pendingCentres = service.getPendingGymCentres();
                if (pendingCentres.isEmpty()) {
                    System.out.println("No pending gym centres found.");
                } else {
                    System.out.println("--- Pending Gym Centres ---");
                    int i = 1;
                    for (com.flipfit.bean.GymCentre centre : pendingCentres) {
                        System.out.println(i + ". " + centre.getName() + " ("
                                + centre.getCity() + ")");
                        i++;
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
                        System.out.println();
                    } else if (approveChoice != 0) {
                        System.out.println("Invalid selection.");
                    }
                }
            } else if (choice == 9) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }
}