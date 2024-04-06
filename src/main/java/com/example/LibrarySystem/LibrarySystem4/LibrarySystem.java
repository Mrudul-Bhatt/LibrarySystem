package com.example.LibrarySystem.LibrarySystem4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

// definition of enumerations used in library management system
enum BookFormat {
    HARDCOVER,
    PAPERBACK,
    AUDIOBOOK,
    EBOOK,
    NEWSPAPER,
    MAGAZINE,
    JOURNAL
}

enum BookStatus {
    AVAILABLE,
    RESERVED,
    LOANED,
    LOST
}

enum ReservationStatus {
    WAITING,
    PENDING,
    CANCELED,
    NONE
}

enum AccountStatus {
    ACTIVE,
    CLOSED,
    CANCELED,
    BLACKLISTED,
    NONE
}

@Getter
@Setter
class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String country;
}

@Getter
@Setter
class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

// User is an abstract class
@Getter
@Setter
abstract class User {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;
    private LibraryCard card;

    public abstract boolean resetPassword(String password);

    public abstract void addNotification(Notification notification);
}

@Getter
@Setter
class LibraryCard {
    private String cardNumber;
    private Date issued;
    private boolean active;
    private String memberId;
    private double amount;

    public void collectFine(String memberId, long days) {

    }
}

class Librarian extends User {
    public boolean blockMember(Member member) {
        if (member != null && member.getStatus() == AccountStatus.ACTIVE) {
            member.setStatus(AccountStatus.BLACKLISTED);
            return true;
        }
        return false;

    }

    public boolean unBlockMember(Member member) {
        if (member != null && member.getStatus() == AccountStatus.BLACKLISTED) {
            member.setStatus(AccountStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public boolean addBookItem(BookItem bookItem) {
        if (bookItem != null) {
            // Add book item to the rack or inventory
            Rack rack = Library.getInstance().getRackForBookItem(bookItem);
            if (rack != null) {
                rack.addBookItem(bookItem);
                Catalog.addBook(bookItem.getBook());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean resetPassword(String password) {
        if (password != null && password.length() >= 6) {
            setPassword(password);
            return true;
        }
        return false;
    }

    @Override
    public void addNotification(Notification notification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNotification'");
    }
}

@Getter
@Setter
class Member extends User {
    private Date dateOfMembership;
    private int totalBooksCheckedOut;
    private List<Notification> notifications;

    public Member() {
        notifications = new ArrayList<>();
    }

    // Method to add a notification to the member's list of notifications
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public boolean reserveBookItem(BookItem bookItem) {
        if (bookItem != null && bookItem.getStatus() == BookStatus.AVAILABLE) {
            // Check if the member is allowed to reserve more books
            if (totalBooksCheckedOut < getMaxAllowedBooks()) {
                BookReservation reservation = new BookReservation();
                reservation.setMemberId(getId());
                reservation.setItemId(bookItem.getId());
                reservation.setStatus(ReservationStatus.WAITING);
                reservation.setCreationDate(new Date());
                // Save reservation to database or list of reservations
                // Also update bookItem status to RESERVED
                bookItem.setStatus(BookStatus.RESERVED);
                Library.getInstance().addReservation(reservation);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        if (bookItem != null && bookItem.getStatus() == BookStatus.AVAILABLE) {
            // Check if the member is allowed to borrow more books
            if (totalBooksCheckedOut < getMaxAllowedBooks()) {
                // Fetch the member's reservations from the library
                List<BookReservation> memberReservations = Library.getInstance().getReservationsForMember(getId());

                // Find the reservation for the specific book item
                BookReservation bookReservation = findReservationForMember(memberReservations, bookItem.getId());

                // Proceed with checkout if there's a reservation
                if (bookReservation != null) {
                    // Create due date using BookLending class
                    Date dueDate = BookLending.calculateDueDate(new Date());

                    // Create a book lending record
                    BookLending lendingRecord = new BookLending();
                    lendingRecord.setBookItemId(bookItem.getId());
                    lendingRecord.setMemberId(getId());
                    lendingRecord.setCreationDate(new Date());
                    lendingRecord.setDueDate(dueDate);
                    lendingRecord.setBookReservation(bookReservation);
                    lendingRecord.setUser(this);

                    // Update book item status to LOANED
                    bookItem.setStatus(BookStatus.LOANED);
                    bookItem.setDueDate(dueDate);
                    Library.getInstance().addLending(lendingRecord);
                    // Remove the reservation from the library
                    Library.getInstance().removeReservation(bookReservation);

                    totalBooksCheckedOut++;
                    return true;
                }
            }
        }
        return false;
    }

    public void returnBookItem(BookItem bookItem) {
        if (bookItem != null && bookItem.getStatus() == BookStatus.LOANED) {
            // Update book status to AVAILABLE
            bookItem.setStatus(BookStatus.AVAILABLE);
            totalBooksCheckedOut--;

            // Check for fines if the book is returned after the due date
            // BookLending bookLending =
            // Library.getInstance().getLendingRecord(bookItem.getId(), getId());
            BookLending.returnBook(bookItem.getId(), getId());
            // Library.getInstance().removeLending(null);
        }
    }

    public boolean renewBookItem(BookItem bookItem) {

        // Find the corresponding BookLending record for the book item and member
        BookLending lendingRecord = Library.getInstance().getLendingRecord(bookItem.getId(), getId());

        // Check if the lending record exists and if renewal is allowed
        if (lendingRecord != null && isRenewalAllowed(bookItem)) {
            // Calculate the new due date for renewal
            Date newDueDate = BookLending.calculateDueDate(bookItem.getDueDate());
            bookItem.setDueDate(newDueDate);
            // Update the due date of the existing lending record
            lendingRecord.setDueDate(newDueDate);
            return true; // Renewal successful
        }
        return false; // Renewal not allowed or lending record not found
    }

    // Method to check if the book item is eligible for renewal
    private boolean isRenewalAllowed(BookItem bookItem) {
        // Add your conditions for determining renewal eligibility here
        // For example, you can check if the book item is not marked as reference only
        // and if it has not reached the maximum number of renewals allowed.
        return !bookItem.isReferenceOnly();
    }

    @Override
    public boolean resetPassword(String password) {
        if (password != null && password.length() >= 6) {
            setPassword(password);
            return true;
        }
        return false;
    }

    // Getter for max allowed books (this can be a configurable value)
    private int getMaxAllowedBooks() {
        return 5; // Example: maximum of 5 books allowed for checkout
    }

    private BookReservation findReservationForMember(List<BookReservation> reservations, String bookItemId) {
        for (BookReservation reservation : reservations) {
            if (reservation.getItemId().equals(bookItemId)) {
                return reservation;
            }
        }
        return null;
    }
}

@Getter
@Setter
class BookReservation {
    private String itemId;
    private Date creationDate;
    private ReservationStatus status;
    private String memberId;

    public static boolean reserveBook(String bookItemId, String memberId, BookItem bookItem) {
        // Check if the book item is available for reservation
        if (bookItem != null && bookItem.getStatus() == BookStatus.AVAILABLE) {
            // Create a new reservation record
            BookReservation reservation = new BookReservation();
            reservation.setItemId(bookItemId);
            reservation.setCreationDate(new Date());
            reservation.setStatus(ReservationStatus.WAITING);
            reservation.setMemberId(memberId);

            // Add the reservation record to the library
            Library.getInstance().addReservation(reservation);

            // Update the book item status to RESERVED
            bookItem.setStatus(BookStatus.RESERVED);

            return true; // Reservation successful
        }
        return false; // Reservation unsuccessful
    }

    public static BookReservation fetchReservationDetails(String bookItemId) {
        // Get all reservations from the library
        List<BookReservation> allReservations = Library.getInstance().getReservations();

        // Search for the reservation corresponding to the given book item ID
        for (BookReservation reservation : allReservations) {
            if (reservation.getItemId().equals(bookItemId)) {
                return reservation; // Found the reservation
            }
        }

        return null; // Reservation not found for the given book item ID
    }
}

@Getter
@Setter
class BookLending {
    private String bookItemId;
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String memberId;
    private BookReservation bookReservation;
    private User user;

    public static boolean lendBook(String bookItemId, String memberId, BookItem bookItem) {
        // Check if the book item is available for lending
        // BookItem bookItem = Library.getInstance().getBookItemById(bookItemId);
        if (bookItem != null && bookItem.getStatus() == BookStatus.AVAILABLE) {
            // Create a new lending record
            BookLending lendingRecord = new BookLending();
            lendingRecord.setBookItemId(bookItemId);
            lendingRecord.setMemberId(memberId);
            lendingRecord.setCreationDate(new Date());

            // Set the due date using BookLending class (e.g., 14 days from now)
            Date dueDate = BookLending.calculateDueDate(new Date());
            lendingRecord.setDueDate(dueDate);

            // Update book item status to LOANED
            bookItem.setStatus(BookStatus.LOANED);
            bookItem.setDueDate(dueDate);

            // Add the lending record to the library
            Library.getInstance().addLending(lendingRecord);

            return true; // Lending successful
        }
        return false; // Lending unsuccessful
    }

    public static BookLending fetchLendingDetails(String bookItemId) {
        // Get all lending from the library
        List<BookLending> allLendings = Library.getInstance().getLendings();

        // Search for the lending corresponding to the given book item ID
        for (BookLending lending : allLendings) {
            if (lending.getBookItemId().equals(bookItemId)) {
                return lending; // Found the lending
            }
        }

        return null; // Lending not found for the given book item ID
    }

    public static Date calculateDueDate(Date currentDate) {
        // Calculate due date (e.g., 14 days from current date)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 14); // Assuming 14 days borrowing period
        return calendar.getTime();
    }

    public static boolean returnBook(String bookItemId, String memberId) {
        // Retrieve the lending record from the library
        BookLending lendingRecord = Library.getInstance().getLendingRecord(bookItemId, memberId);

        if (lendingRecord != null) {
            lendingRecord.setReturnDate(new Date());

            // Check for fines if the book is returned after the due date
            if (lendingRecord.getDueDate().before(lendingRecord.getReturnDate())) {
                double fineAmount = calculateFineAmount(lendingRecord.getDueDate(), lendingRecord.getReturnDate());
                Library.getInstance().addFine(memberId, bookItemId, fineAmount);
            }

            Library.getInstance().removeLending(lendingRecord);
            return true;
        }
        return false;
    }

    private static double calculateFineAmount(Date dueDate, Date returnDate) {
        long daysOverdue = calculateDaysOverdue(dueDate, returnDate);

        // Calculate fine amount based on library's policy (e.g., $1 per day overdue)
        double finePerDay = 1.0; // Example: $1 per day fine
        return finePerDay * daysOverdue;
    }

    private static long calculateDaysOverdue(Date dueDate, Date returnDate) {
        long diffInMillies = Math.abs(returnDate.getTime() - dueDate.getTime());
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
        return diffInDays;
    }
}

@Getter
@Setter
class Fine {
    private Date creationDate;
    private String bookItemId;
    private String memberId;
    private double fineAmount;

    public static void collectFine(String bookItemId, String memberId, int amount) {
        System.out.println("Member " + memberId + "has to give fine " + amount + "for lending book item " + bookItemId);
    }
}

// User is an abstract class
@Getter
@Setter
class Book {
    private String isbn;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private BookFormat bookFormat;
    private List<Author> authors;
}

@Getter
@Setter
class Author extends Person {
    private String name;
    private String description;
}

@Getter
@Setter
class BookItem {
    private String id;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
    private Book book; // Agggregation: BookItem has a reference to a Book

    // Constructors, getters, and other existing methods...

    public boolean checkout(String memberId) {
        // Implementation for checkout logic
        // Update the status, set due date, etc.
        // Return true if checkout is successful, false otherwise
        return true; // Placeholder, replace with actual logic
    }

    public void setPlacedAt(Rack rack) {
        this.placedAt = rack;
        // Additional logic if needed
    }

    public void setAddedBy(Librarian librarian) {
        // Implementation for setting the librarian who added the book item
        // This might involve updating logs or other data related to the librarian
        // No return value as it's a setter method
    }

    // Other methods...

    public Book getBook() {
        return book;
    }
}

@Getter
@Setter
class Rack {
    private int number;
    private String locationIdentifier;
    private List<BookItem> bookItems;

    public Rack(int number, String locationIdentifier) {
        this.number = number;
        this.locationIdentifier = locationIdentifier;
        this.bookItems = new ArrayList<>();
    }

    public void addBookItem(BookItem bookItem) {
        if (bookItem != null) {
            bookItems.add(bookItem);
        }
    }

    public boolean containsBookItem(BookItem bookItem) {
        return bookItems.contains(bookItem);
    }
}

// User is an abstract class
@Getter
@Setter
abstract class Notification {
    private String notificationId;
    private Date creationDate;
    private String content;
    private BookLending bookLending;

    public abstract boolean sendNotification();
}

class PostalNotification extends Notification {
    private Address address;

    public boolean sendNotification() {
        // Implement sending postal notification to the member's address
        // Example: Send postal notification to this.address
        System.out.println("Postal notification sent to: " + address.getStreetAddress() + ", " + address.getCity()
                + ", " + address.getState() + ", " + address.getZipCode() + ", " + address.getCountry());

        // Add the notification to the member's list of notifications
        getBookLending().getUser().addNotification(this);
        return true; // Notification sent successfully
    }
}

class EmailNotification extends Notification {
    private String email;

    public boolean sendNotification() {
        // Implement sending email notification to the member's email address
        // Example: Send email notification to this.email
        System.out.println("Email notification sent to: " + email);

        // Add the notification to the member's list of notifications
        getBookLending().getUser().addNotification(this);
        return true; // Notification sent successfully
    }
}

interface Search {
    // Interface method (does not have a body)
    public List<Book> searchByTitle(String title);

    public List<Book> searchByAuthor(String author);

    public List<Book> searchBySubject(String subject);
}

class Catalog {
    private static HashMap<String, List<Book>> bookTitles;
    private static HashMap<String, List<Book>> bookAuthors;
    private static HashMap<String, List<Book>> bookSubjects;

    public Catalog() {
        bookTitles = new HashMap<>();
        bookAuthors = new HashMap<>();
        bookSubjects = new HashMap<>();
    }

    public static List<Book> searchByTitle(String query) {
        return bookTitles.getOrDefault(query, new ArrayList<>());
    }

    public static List<Book> searchByAuthor(String query) {
        return bookAuthors.getOrDefault(query, new ArrayList<>());
    }

    public static List<Book> searchBySubject(String query) {
        return bookSubjects.getOrDefault(query, new ArrayList<>());
    }

    // Method to add a book to the catalog
    public static void addBook(Book book) {
        // Add book to bookTitles map
        String title = book.getTitle();
        if (!bookTitles.containsKey(title)) {
            bookTitles.put(title, new ArrayList<>());
        }
        bookTitles.get(title).add(book);

        // Add book to bookAuthors map
        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            String authorName = author.getName();
            if (!bookAuthors.containsKey(authorName)) {
                bookAuthors.put(authorName, new ArrayList<>());
            }
            bookAuthors.get(authorName).add(book);
        }

        // Add book to bookSubjects map
        String subject = book.getSubject();
        if (!bookSubjects.containsKey(subject)) {
            bookSubjects.put(subject, new ArrayList<>());
        }
        bookSubjects.get(subject).add(book);
    }
}

@Getter
@Setter
class Library {
    private String name;
    private Address address;
    private List<Rack> racks;
    private List<BookReservation> reservations;
    private List<BookLending> lendings;
    private List<Fine> fines;

    // Private constructor to prevent external instantiation
    private Library() {
        racks = new ArrayList<>();
        reservations = new ArrayList<>();
        lendings = new ArrayList<>();
    }

    // The Library is a singleton class that ensures it will have only one active
    // instance at a time
    private static Library library = null;

    // Created a static method to access the singleton instance of Library class
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }

    public List<BookReservation> getReservationsForMember(String memberId) {
        List<BookReservation> memberReservations = new ArrayList<>();
        for (BookReservation reservation : reservations) {
            if (reservation.getMemberId().equals(memberId)) {
                memberReservations.add(reservation);
            }
        }
        return memberReservations;
    }

    public Rack getRackForBookItem(BookItem bookItem) {
        if (racks != null && bookItem != null) {
            for (Rack rack : racks) {
                // Logic to check if this type of book item is present in this rack
                if (rack.containsBookItem(bookItem)) {
                    return rack;
                }
            }
        }
        return null;
    }

    public void addReservation(BookReservation reservation) {
        reservations.add(reservation);
    }

    public void addLending(BookLending lending) {
        lendings.add(lending);
    }

    public void removeReservation(BookReservation reservation) {
        reservations.remove(reservation);
    }

    public void removeLending(BookLending lending) {
        lendings.remove(lending);
    }

    public BookLending getLendingRecord(String bookItemId, String memberId) {
        for (BookLending lendingRecord : lendings) {
            if (lendingRecord.getBookItemId().equals(bookItemId) && lendingRecord.getMemberId().equals(memberId)) {
                return lendingRecord;
            }
        }
        return null; // Lending record not found
    }

    public void addFine(String memberId, String bookItemId, double fineAmount) {
        Fine fine = new Fine();
        fine.setMemberId(memberId);
        fine.setBookItemId(bookItemId);
        fine.setFineAmount(fineAmount);
        fine.setCreationDate(new Date());
        fines.add(fine);
    }
}

public class LibrarySystem {

}
