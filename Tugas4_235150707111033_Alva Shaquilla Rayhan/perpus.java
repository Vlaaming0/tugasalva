import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BookActions {
    void borrowBook();
    void returnBook();
}

class Book {
    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public void printInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Borrowed: " + isBorrowed);
        System.out.println();
    }
}

class HistoryEntry {
    private String action;
    private String bookType;
    private String bookTitle;

    public HistoryEntry(String action, String bookType, String bookTitle) {
        this.action = action;
        this.bookType = bookType;
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return bookType + " : " + bookTitle + " " + action;
    }
}

class TextBook extends Book implements BookActions {
    private String subject;
    private perpus Perpus;

    public TextBook(String title, String author, int year, String subject, perpus Perpus) {
        super(title, author, year);
        this.subject = subject;
        this.Perpus = Perpus;
    }

    public void borrowBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (!isBorrowed()) {
            setBorrowed(true);
            Perpus.addHistory("borrowed successfully", "Textbook", getTitle());
            System.out.println("Textbook: " + getTitle() + " borrowed successfully.");
        } else {
            System.out.println("Textbook: " + getTitle() + " is already borrowed.");
        }
    }

    public void returnBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (isBorrowed()) {
            setBorrowed(false);
            Perpus.addHistory("returned successfully", "Textbook", getTitle());
            System.out.println("Textbook: " + getTitle() + " returned successfully.");
        } else {
            Perpus.addHistory("is not borrowed", "Textbook", getTitle());
            System.out.println("Textbook: " + getTitle() + " is not borrowed.");
        }
    }
}

class Novel extends Book implements BookActions {
    private String genre;
    private perpus Perpus;

    public Novel(String title, String author, int year, String genre, perpus Perpus) {
        super(title, author, year);
        this.genre = genre;
        this.Perpus = Perpus;
    }

    public void borrowBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (!isBorrowed()) {
            setBorrowed(true);
            Perpus.addHistory("borrowed successfully", "Novel", getTitle());
            System.out.println("Novel: " + getTitle() + " borrowed successfully.");
        } else {
            System.out.println("Novel: " + getTitle() + " is already borrowed.");
        }
    }

    public void returnBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (isBorrowed()) {
            setBorrowed(false);
            Perpus.addHistory("returned successfully", "Novel", getTitle());
            System.out.println("Novel: " + getTitle() + " returned successfully.");
        } else {
            Perpus.addHistory("is not borrowed", "Textbook", getTitle());
            System.out.println("Novel: " + getTitle() + " is not borrowed.");
        }
    }
}

class Magazine extends Book implements BookActions {
    private String category;
    private perpus Perpus;

    public Magazine(String title, String author, int year, String category, perpus Perpus) {
        super(title, author, year);
        this.category = category;
        this.Perpus = Perpus;
    }

    public void borrowBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (!isBorrowed()) {
            setBorrowed(true);
            Perpus.addHistory("borrowed successfully", "Magazine", getTitle());
            System.out.println("Magazine: " + getTitle() + " borrowed successfully.");
        } else {
            System.out.println("Magazine: " + getTitle() + " is already borrowed.");
        }
    }

    public void returnBook() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        if (isBorrowed()) {
            setBorrowed(false);
            Perpus.addHistory("returned successfully", "Magazine", getTitle());
            System.out.println("Magazine: " + getTitle() + " returned successfully.");
        } else {
            Perpus.addHistory("is not borrowed", "Textbook", getTitle());
            System.out.println("Magazine: " + getTitle() + " is not borrowed.");
        }
    }
}

public class perpus {
    private List<HistoryEntry> history;

    public perpus() {
        history = new ArrayList<>();
    }

    public void addHistory(String action, String bookType, String bookTitle) {
        history.add(new HistoryEntry(action, bookType, bookTitle));
    }

    public void printHistory() {
        System.out.println("\n---- Borrowing and Returning Books ----");
        history.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        perpus Perpus = new perpus();
        int userChoice;

        TextBook textbook = new TextBook("Java Programming", "John Smith", 2022, "Mathematics", Perpus);
        Novel novel = new Novel("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction", Perpus);
        Magazine magazine = new Magazine("National Geographic", "Various", 2021, "Science", Perpus);

        List<Book> books = new ArrayList<>();
        books.add(textbook);
        books.add(novel);
        books.add(magazine);

        do {
            System.out.println("\n----Library Information System----");
            System.out.println("1. Book Information");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("\n---- Book Information ----");
                    for (Book book : books) {
                        book.printInfo();
                    } Perpus.printHistory();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    scanner.nextLine(); // Consume newline
                    String borrowTitle = scanner.nextLine();
                    boolean bookFoundToBorrow = false;
                    for (Book book : books) {
                        if (borrowTitle.equalsIgnoreCase(book.getTitle())) {
                            ((BookActions) book).borrowBook();
                            bookFoundToBorrow = true;
                            break;
                        }
                    }
                    if (!bookFoundToBorrow) {
                        System.out.println("\nBook not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine(); // Consume newline
                    String returnTitle = scanner.nextLine();
                    boolean bookFoundToReturn = false;
                    for (Book book : books) {
                        if (returnTitle.equalsIgnoreCase(book.getTitle())) {
                            ((BookActions) book).returnBook();
                            bookFoundToReturn = true;
                            break;
                        }
                    }
                    if (!bookFoundToReturn) {
                        System.out.println("\nBook not found!");
                    }
                    break;
                case 4:
                    System.out.println("\nThank you for visiting our library!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a valid option.");
            }
        } while (userChoice != 5);

        scanner.close();
    }
}
