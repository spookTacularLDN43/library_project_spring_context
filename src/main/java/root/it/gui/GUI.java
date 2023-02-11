package root.it.gui;

import root.it.database.LibraryRepository;

import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void showLoginMenu() {
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Enter your login:");
                String login = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                boolean authenticationResult = LibraryRepository.getInstance().authenticate(login, password);
                if (authenticationResult) {
                    System.out.println("Login successful");
                    System.out.println();
                    showMainMenu();
                } else {
                    System.out.println("Invalid credentials, try again.");
                    System.out.println();
                    showLoginMenu();
                }
                break;
            case "2":
                System.out.println("Enter login");
                String newLogin = scanner.nextLine();
                boolean availability = LibraryRepository.getInstance().checkLoginAvailability(newLogin);
                if (!availability) {
                    System.out.println("Login taken");
                } else {
                    System.out.println("Enter password");
                    String newPassword = scanner.nextLine();
                    LibraryRepository.getInstance().addNewUser(newLogin, newPassword);
                    System.out.println("Registration successful. You can log in.");
                    showLoginMenu();
                }
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Choose option 1, 2 or 3");
        }
    }

    private static void showMainMenu() {
        System.out.println("Menu glowne");
    }
}
