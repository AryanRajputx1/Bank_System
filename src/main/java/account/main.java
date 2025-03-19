package account;
import java.util.*;

public class main {
    private static HashMap<Integer, String> userPasswords = new HashMap<>();
    private static HashMap<Integer, Double> userBalances = new HashMap<>();
    private static accountdetails accountDetails = new accountdetails();
    private static BankOperations bankOperations = new BankOperations(userBalances);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== BANK LOGIN SYSTEM ===");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                int ac = in.nextInt();
                in.nextLine();
                System.out.print("Enter Name: ");
                String name = in.nextLine();
                System.out.print("Set Password: ");
                String password = in.nextLine();

                if (userPasswords.containsKey(ac)) {
                    System.out.println("❌ Account already exists!");
                } else {
                    userPasswords.put(ac, password);
                    userBalances.put(ac, 0.0);
                    System.out.println("✅ Account registered successfully!");
                }

            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                int ac = in.nextInt();
                in.nextLine();
                System.out.print("Enter Password: ");
                String password = in.nextLine();

                if (userPasswords.containsKey(ac) && userPasswords.get(ac).equals(password)) {
                    System.out.println("✅ Login successful!");
                    System.out.print("Enter your name: ");
                    String name = in.nextLine();
                    accountDetails.accountinfo(name, ac);

                    bankOperations.showBankingOptions(ac, in);
                } else {
                    System.out.println("❌ Incorrect account number or password.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }
        in.close();
    }
}
