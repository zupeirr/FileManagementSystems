package ui;
import model.User;
import service.FileService;
import java.util.Scanner;

public class ClientPage {
    public static void showClientPage(User user) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== CLIENT PAGE ====");
            System.out.println("Welcome, " + user.getUsername());
            System.out.println("1. View Files");
            System.out.println("2. About Us");
            System.out.println("3. Logout");
            System.out.println("4. Read File");
            System.out.println("5. Update File");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> FileService.viewFiles();
                case 2 -> AboutPage.show();
                case 3 -> System.out.println("Logging out...");
                case 4 -> FileService.readFile();
                case 5 -> FileService.updateFile();
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }
}
