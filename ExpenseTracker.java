import java.util.ArrayList;
import java.util.Scanner;

// Expense class to hold expense details
class Expense {
    String category;
    double amount;
    String date;
    String description;

    public Expense(String category, double amount, String date, String description) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + category + " - $" + amount + " | " + description;
    }
}

// Main application
public class ExpenseTracker {
    static ArrayList<Expense> expenseList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    public static void addExpense() {
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();

        Expense expense = new Expense(category, amount, date, description);
        expenseList.add(expense);
        System.out.println("Expense added successfully.");
    }

    public static void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses to show.");
            return;
        }

        System.out.println("\n--- Expense List ---");
        for (Expense e : expenseList) {
            System.out.println(e);
        }
    }
}
