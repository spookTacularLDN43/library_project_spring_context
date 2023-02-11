package root.it.gui;

import root.it.database.LibraryRepository;

import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    private static void showLoginMenu() {
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
                if(authenticationResult){
                    System.out.println("Login successful");
                    System.out.println();
                    showMainMenu();
                }else {
                    System.out.println("Invalid credentials, try again.");
                    System.out.println();
                    showLoginMenu();
                }
                break;
            case "2":
                System.out.println("Enter login");
                String newLogin = scanner.nextLine();
                System.out.println("Enter password");
                String newPassword = scanner.nextLine();

        }
    }
}
