package ui;

import model.User;
import utils.AuthService;
import utils.UserNotFoundException;
import utils.IncorrectPasswordException;

import java.util.Scanner;

public class LoginPage {
    public static void showLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== LOGIN PAGE ====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            User user = AuthService.login(username, password);
            System.out.println("Login successful! Welcome, " + user.getUsername() + ".");

            if (user.getRole().equals("admin")) {
                AdminPage.showAdminPage(user);
            } else {
                ClientPage.showClientPage(user);
            }

        } catch (UserNotFoundException | IncorrectPasswordException e) {
            System.out.println("⚠️  Login failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️  Unexpected error occurred: " + e.getMessage());
        }
    }
}
