import java.util.Scanner;

// Class to represent a Book
class Book {
    private int bookId;
    private String title;
    private String author;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Class to represent the Library
class Library {
    private Book[] books;
    private Scanner scanner;

    // Constructor
    public Library() {
        this.books = new Book[100]; // Assuming a maximum of 100 books
        this.scanner = new Scanner(System.in);
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        // Logic to add a book to the library
        System.out.println("Book added successfully!");
    }

    // Method to search for a book by title
    public void searchBook(String title) {
        // Logic to search for a book by title
        System.out.println("Search results for '" + title + "':");
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to issue a book
    public void issueBook(int bookId) {
        // Logic to issue a book
        System.out.println("Book issued successfully!");
    }

    // Method to return a book
    public void returnBook(int bookId) {
        // Logic to return a book
        System.out.println("Book returned successfully!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Library object
        Library library = new Library();

        // Menu for users
        System.out.println("Welcome to the Digital Library Management System!");
        System.out.println("1. Search for a book");
        System.out.println("2. Issue a book");
        System.out.println("3. Return a book");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scanner.nextLine(); // Consume newline character
                System.out.println("Enter the title of the book:");
                String title = scanner.nextLine();
                library.searchBook(title);
                break;
            case 2:
                System.out.println("Enter the book ID:");
                int bookId = scanner.nextInt();
                library.issueBook(bookId);
                break;
            case 3:
                System.out.println("Enter the book ID:");
                int returnBookId = scanner.nextInt();
                library.returnBook(returnBookId);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

