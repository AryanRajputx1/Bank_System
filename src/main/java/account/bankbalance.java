package account;
import java.util.HashMap;
import java.util.Scanner;

 class BankOperations {
    private HashMap<Integer, Double> userBalances;

    public BankOperations(HashMap<Integer, Double> userBalances) {
        this.userBalances = userBalances;
    }

    public void showBankingOptions(int ac, Scanner in) {
        while (true) {
            System.out.println("\n--- Banking Options ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int bankChoice = in.nextInt();

            switch (bankChoice) {
                case 1:
                    checkBalance(ac);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = in.nextDouble();
                    depositMoney(ac, deposit);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = in.nextDouble();
                    withdrawMoney(ac, withdraw);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }

    public void checkBalance(int ac) {
        System.out.println("💰 Your balance: $" + userBalances.get(ac));
    }

    public void depositMoney(int ac, double amount) {
        userBalances.put(ac, userBalances.get(ac) + amount);
        System.out.println("✅ Deposited $" + amount + ". New balance: $" + userBalances.get(ac));
    }

    public void withdrawMoney(int ac, double amount) {
        if (amount > userBalances.get(ac)) {
            System.out.println("❌ Insufficient balance!");
        } else {
            userBalances.put(ac, userBalances.get(ac) - amount);
            System.out.println("✅ Withdrawn $" + amount + ". New balance: $" + userBalances.get(ac));
        }
    }
}
