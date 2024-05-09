import java.util.Scanner;

// Transaction class to represent each transaction
class Transaction {
    private String type;
    private double amount;

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Method to display transaction details
    public void display() {
        System.out.println("Type: " + type);
        System.out.println("Amount: $" + amount);
    }
}

// Account class to represent a user's account
class Account {
    private String userId;
    private String userPin;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;

    // Constructor
    public Account(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactions = new Transaction[100]; // Assuming a maximum of 100 transactions
        this.transactionCount = 0;
    }

    // Method to authenticate user
    public boolean authenticate(String userId, String userPin) {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Transaction("Deposit", amount);
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            transactions[transactionCount++] = new Transaction("Withdrawal", amount);
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            transactions[i].display();
        }
    }
}

// ATM class to handle ATM operations
public class ATM {
    private Account account;
    private Scanner scanner;

    // Constructor
    public ATM(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to start the ATM interface
    public void start() {
        System.out.println("Welcome to the ATM!");

        // Authenticate user
        System.out.println("Enter user ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter PIN:");
        String userPin = scanner.nextLine();

        if (account.authenticate(userId, userPin)) {
            System.out.println("Authentication successful!");

            // Display menu
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Quit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.displayTransactionHistory();
                        break;
                    case 2:
                        System.out.println("Enter withdrawal amount:");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter deposit amount:");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again later.");
        }
    }

    public static void main(String[] args) {
        // Create an account
        Account account = new Account("Sakthi", "Sakthi@123");

        // Create an ATM object and start the ATM interface
        ATM atm = new ATM(account);
        atm.start();
    }
}
