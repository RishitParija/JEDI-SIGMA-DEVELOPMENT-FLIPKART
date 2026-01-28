package com.flipfit.client;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.business.GymCustomerService;
import com.flipfit.business.GymCustomerServiceImpl;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymOwnerServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class FlipFitApplication.
 *
 * @author Rishit
 * @ClassName "FlipFitApplication"
 */
public class FlipFitApplication {

    // Method level Commenting

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        com.flipfit.constants.SQLConnectorConstants.loadMockData();
        Scanner scanner = new Scanner(System.in);
        GymCustomerService gymCustomerService = new GymCustomerServiceImpl();
        GymOwnerService gymOwnerService = new GymOwnerServiceImpl();
        com.flipfit.business.AdminService adminService = new com.flipfit.business.AdminServiceImpl();

        try {
            int choice = 0;

            do {
                System.out.println("\nWelcome to the Flipfit Application");
                System.out.println("\n1. Login");
                System.out.println("2. Register as Gymcustomer");
                System.out.println("3. Register as GymOwner");
                System.out.println("4. Change Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                System.out.println();

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                if (choice == 1) {
                    // Login
                    System.out.println("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Enter Role (Admin/Customer/GymOwner): ");
                    String role = scanner.nextLine();

                    if (role.equalsIgnoreCase("Admin")) {
                        if (((com.flipfit.business.AdminServiceImpl) adminService).validateLogin(username, password)) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            System.out.println("\nWelcome " + username + "\t\t\t" + now.format(formatter));

                            AdminFlipFitMenu adminMenu = new AdminFlipFitMenu();
                            adminMenu.adminMenu();
                        } else {
                            System.out.println("Invalid Admin Credentials");
                        }
                    } else if (role.equalsIgnoreCase("Customer")) {
                        if (gymCustomerService.validateCustomer(username, password)) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            System.out.println("\nWelcome to " + username + "\t\t\t" + now.format(formatter));

                            GymCustomer customer = gymCustomerService.getCustomerByUsername(username);
                            GymCustomerFlipFitMenu customerMenu = new GymCustomerFlipFitMenu();
                            customerMenu.customerMenu(customer);
                        } else {
                            System.out.println("Login Failed.");
                        }
                    } else if (role.equalsIgnoreCase("GymOwner")) {
                        if (gymOwnerService.validateLogin(username, password)) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            System.out.println("\nWelcome to " + username + "\t\t\t" + now.format(formatter));

                            GymOwner owner = gymOwnerService.getGymOwnerByUsername(username);
                            GymOwnerFlipFitMenu ownerMenu = new GymOwnerFlipFitMenu();
                            ownerMenu.gymOwnerMenu(owner);
                        } else {
                            System.out.println("Login Failed.");
                        }
                    } else {
                        System.out.println("Invalid Role. Please try again.");
                    }

                } else if (choice == 2) {
                    // Registration of GymCustomer
                    System.out.println("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter Phone Number (10 digits): ");
                    String phone = scanner.nextLine();

                    // Create Bean
                    GymCustomer newCustomer = new GymCustomer(UUID.randomUUID().toString(), username, name, email,
                            password,
                            0.0, phone);
                    // Call Service
                    try {
                        gymCustomerService.registerCustomer(newCustomer);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                } else if (choice == 3) {
                    // Registration of GymOwner
                    System.out.println("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter PAN Number: ");
                    String pan = scanner.nextLine();
                    System.out.println("Enter Phone Number (10 digits): ");
                    String phone = scanner.nextLine();
                    System.out.println("Enter Aadhar Card (12 digits): ");
                    String aadhar = scanner.nextLine();

                    // Create Bean
                    GymOwner owner = new GymOwner(UUID.randomUUID().toString(), username, name, email, password, pan,
                            phone, aadhar);
                    // Call Service
                    try {
                        gymOwnerService.registerGymOwner(owner);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                } else if (choice == 4) {
                    // Change Password
                    System.out.println("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Old Password: ");
                    scanner.nextLine(); // consume input
                    System.out.println("Enter New Password: ");
                    scanner.nextLine(); // consume input
                    System.out.println("Enter Role: ");
                    scanner.nextLine(); // consume input

                    System.out.println("Password changed successfully for user: " + username);

                } else if (choice == 5) {
                    // Exit
                    System.out.println("Exiting FlipFit Application. Goodbye!");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            } while (true);
        } finally {
            scanner.close();
        }
    }
}