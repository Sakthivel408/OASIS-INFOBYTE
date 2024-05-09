import java.util.Scanner;

// Class to represent a User
class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to authenticate user
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

// Class to represent the Online Examination System
class OnlineExamSystem {
    private User currentUser;
    private Scanner scanner;

    // Constructor
    public OnlineExamSystem(User user) {
        this.currentUser = user;
        this.scanner = new Scanner(System.in);
    }

    // Method to handle user login
    public void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Authenticate user
        if (currentUser == null || !currentUser.authenticate(username, password)) {
            System.out.println("Invalid username or password. Please try again.");
        } else {
            System.out.println("Login successful!");
        }
    }

    // Method to update user profile and password
    public void updateProfile() {
        System.out.println("Profile updated successfully!");
    }

    // Method to select answers for MCQs
    public void selectAnswers() {
        System.out.println("Answers selected successfully!");
    }

    // Method to start the online examination
    public void startExam() {
        System.out.println("Online examination started!");
    }

    // Method to submit answers automatically
    public void autoSubmit() {
        System.out.println("Answers submitted automatically!");
    }

    // Method to close session and logout
    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully!");
    }

    // Method to start the online examination system
    public void start() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Select Answers for MCQs");
            System.out.println("4. Start Exam");
            System.out.println("5. Auto Submit");
            System.out.println("6. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    selectAnswers();
                    break;
                case 4:
                    startExam();
                    break;
                case 5:
                    autoSubmit();
                    break;
                case 6:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a User object with the provided username and password
        User user = new User("Sakthi", "Sakthi@123");

        // Create an OnlineExamSystem object and start the online examination system
        OnlineExamSystem examSystem = new OnlineExamSystem(user);
        examSystem.start();
    }
}
