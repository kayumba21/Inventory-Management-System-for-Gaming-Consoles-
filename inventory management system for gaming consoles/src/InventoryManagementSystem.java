import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        ArrayList<GamingConsole> consoles = new ArrayList<>();
        consoles.add(new GamingConsole("Xbox Series X", 499.99, 100, true));
        consoles.add(new GamingConsole("PlayStation 5", 499.99, 500, false));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Stock");
            System.out.println("2. View Console Details");
            System.out.println("3. Calculate Discount");
            System.out.println("4. Search Console by Name");
            System.out.println("5. Apply Bulk Discount");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStock(scanner, consoles);
                    break;
                case 2:
                    viewConsoleDetails(consoles);
                    break;
                case 3:
                    calculateDiscount(consoles);
                    break;
                case 4:
                    searchConsoleByName(scanner, consoles);
                    break;
                case 5:
                    applyBulkDiscount(scanner, consoles);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addStock(Scanner scanner, ArrayList<GamingConsole> consoles) {
        System.out.print("Enter the model name: ");
        String modelName = scanner.nextLine();
        System.out.print("Enter the quantity to add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (GamingConsole console : consoles) {
            if (console.getModelName().equalsIgnoreCase(modelName)) {
                console.addStock(quantity);
                System.out.println("Stock added successfully.");
                return;
            }
        }
        System.out.println("Console not found.");
    }

    private static void viewConsoleDetails(ArrayList<GamingConsole> consoles) {
        for (GamingConsole console : consoles) {
            console.displayDetails();
        }
    }

    private static void calculateDiscount(ArrayList<GamingConsole> consoles) {
        for (GamingConsole console : consoles) {
            System.out.println("Discount for " + console.getModelName() + ": $" + console.calculateDiscount());
        }
    }

    private static void searchConsoleByName(Scanner scanner, ArrayList<GamingConsole> consoles) {
        System.out.print("Enter the model name: ");
        String modelName = scanner.nextLine();

        for (GamingConsole console : consoles) {
            if (console.getModelName().equalsIgnoreCase(modelName)) {
                console.displayDetails();
                return;
            }
        }
        System.out.println("Console not found.");
    }

    private static void applyBulkDiscount(Scanner scanner, ArrayList<GamingConsole> consoles) {
        System.out.print("Enter the model name: ");
        String modelName = scanner.nextLine();
        System.out.print("Enter the discount percentage: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        for (GamingConsole console : consoles) {
            if (console.getModelName().equalsIgnoreCase(modelName)) {
                try {
                    console.applyBulkDiscount(percentage);
                    System.out.println("Bulk discount applied successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Console not found.");
    }
}
