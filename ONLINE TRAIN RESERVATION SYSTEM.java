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

    // Method to check if the entered username and password are valid
    public boolean isValid(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

// Class to represent the Reservation System
class ReservationSystem {
    // Method to handle the reservation process
    public void makeReservation(User user) {
        // Logic to handle the reservation process
        System.out.println("Reservation process handled.");
    }

    // Method to handle the cancellation process
    public void cancelReservation(User user) {
        // Logic to handle the cancellation process
        System.out.println("Cancellation process handled.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a user object with valid login credentials
        User user = new User("Sakthivel", "Sakthi@123");

        // Create a ReservationSystem object
        ReservationSystem reservationSystem = new ReservationSystem();

        // Login form
        System.out.println("Enter username:");
        String usernameInput = scanner.nextLine();
        System.out.println("Enter password:");
        String passwordInput = scanner.nextLine();

        // Check if the entered credentials are valid
        if (user.isValid(usernameInput, passwordInput)) {
            System.out.println("Login successful!");

            // Reservation form
            System.out.println("Do you want to make a reservation? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                reservationSystem.makeReservation(user);
            } else {
                // Cancellation form
                System.out.println("Do you want to cancel a reservation? (yes/no)");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    reservationSystem.cancelReservation(user);
                } else {
                    System.out.println("Thank you for using our system.");
                }
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

