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

    public double getAmount() {

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
}

@Getter
@Setter
class Member extends User {
    private Date dateOfMembership;
    private int totalBooksCheckedOut;

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

    private void incrementTotalBooksCheckedOut() {
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
                    lendingRecord.setItemId(bookItem.getId());
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

    private void checkForFine(String bookItemId) {
        // Search for any fines associated with the specified book item and member
        // For simplicity, let's assume we have a list of fines associated with members
        List<Fine> fines = getFinesForMember(bookItemId);

        // Check if any fines exist
        if (fines != null && !fines.isEmpty()) {
            // If fines are found, calculate the total fine amount
            double totalFineAmount = calculateTotalFineAmount(fines);

            // Collect the fine
            Fine.collectFine(getId(), totalFineAmount);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        if (bookItem != null && bookItem.getStatus() == BookStatus.LOANED) {
            // Update book status to AVAILABLE
            bookItem.setStatus(BookStatus.AVAILABLE);
            totalBooksCheckedOut--;

            // Check for fines if the book is returned after the due date
            if (bookItem.getDueDate().before(new Date())) {
                double fineAmount = calculateFineAmount(bookItem);
                Fine.collectFine(getId(), fineAmount);
            }

            Library.getInstance().removeLending(null);
        }
    }

    public boolean renewBookItem(BookItem bookItem) {

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

    public static BookReservation fetchReservationDetails(String bookItemId);
}

@Getter
@Setter
class BookLending {
    private String itemId;
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String memberId;
    private BookReservation bookReservation;
    private User user;

    public static boolean lendBook(String bookItemId, String memberId);

    public static BookLending fetchLendingDetails(String bookItemId);

    public static Date calculateDueDate(Date currentDate) {
        // Calculate due date (e.g., 14 days from current date)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 14); // Assuming 14 days borrowing period
        return calendar.getTime();
    }
}

class Fine {
    private Date creationDate;
    private String bookItemId;
    private String memberId;

    public static void collectFine(String memberId, long days);
}

// User is an abstract class
abstract class Book {
    private String isbn;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private BookFormat bookFormat;
    private List<Author> authors;
}

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
abstract class Notification {
    private String notificationId;
    private Date creationDate;
    private String content;
    private BookLending bookLending;
    private BookReservation bookReservation;

    public abstract boolean sendNotification();
}

class PostalNotification extends Notification {
    private Address address;

    public boolean sendNotification() {
        // definition
    }
}

class EmailNotification extends Notification {
    private String email;

    public boolean sendNotification() {
        // definition
    }
}

interface Search {
    // Interface method (does not have a body)
    public List<Book> searchByTitle(String title);

    public List<Book> searchByAuthor(String author);

    public List<Book> searchBySubject(String subject);

    public List<Book> searchByPublicationDate(Date publishDate);
}

class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
        // definition
    }

    public List<Book> searchByAuthor(String query) {
        // definition
    }

    public List<Book> searchBySubject(String query) {
        // definition
    }

    public List<Book> searchByPublicationDate(String query) {
        // definition
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

    // Private constructor to prevent external instantiation
    private Library() {
        racks = new ArrayList<>();
        reservations = new ArrayList<>();
        lendings = new ArrayList<>();
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
}

public class LibrarySystem {

}
