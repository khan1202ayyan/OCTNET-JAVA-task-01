import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ATM_SIMULATION_OCTNET {
    private String accountNumber;
    private int pin;
    private double balance;
    private List<String> transactionHistory;

    public ATM(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();
        if (enteredPin == pin) {
            System.out.println("Login successful!");
            while (true) {
                System.out.println("1. Account Balance Inquiry");
                System.out.println("2. Cash Withdrawal");
                System.out.println("3. Cash Deposit");
                System.out.println("4. PIN Change");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        accountBalanceInquiry();
                        break;
                    case 2:
                        cashWithdrawal(scanner);
                        break;
                    case 3:
                        cashDeposit(scanner);
                        break;
                    case 4:
                        pinChange(scanner);
                        break;
                    case 5:
                        transactionHistory();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Please try again.");
        }
    }

    private void accountBalanceInquiry() {
        System.out.println("Your account balance is: $" + balance);
    }

    private void cashWithdrawal(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawal: -$" + amount);
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    private void cashDeposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory.add("Deposit: +$" + amount);
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    private void pinChange(Scanner scanner) {
        System.out.print("Enter your current PIN: ");
        int currentPin = scanner.nextInt();
        if (currentPin == pin) {
            System.out.print("Enter your new PIN: ");
            int newPin = scanner.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid current PIN. Please try again.");
        }
    }

    private void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM("1234567890", 1234, 1000.0);
        atm.start();
    }
}