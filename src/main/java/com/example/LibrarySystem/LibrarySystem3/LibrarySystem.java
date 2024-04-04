package com.example.LibrarySystem.LibrarySystem3;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

// // Interface for the users of the library
// interface LibraryUser {
//     int getLibraryCardNumber();
// }

// // Interface for the books in the library
// interface BookItem {
//     int getBookId();
//     Book getBook();
// }

// Book class representing a book
@Getter
@Setter
class Book {
    private int bookId;
    private String ISBN;
    private String title;
    private String author;
    private String subject;
    private Date publicationDate;

    public Book(int bookId, String ISBN, String title, String author, String subject, Date publicationDate) {
        this.bookId = bookId;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publicationDate = publicationDate;
    }
}

// BookCopy class representing a copy of a book

@Getter
@Setter
class BookCopy {
    private int bookCopyId;
    private Book book;
    private int rackNumber;

    public BookCopy(int bookCopyId, Book book, int rackNumber) {
        this.bookCopyId = bookCopyId;
        this.book = book;
        this.rackNumber = rackNumber;
    }

    public int getBookId() {
        return book.getBookId();
    }
}

// LibraryCard class representing a library card for a member
@Getter
@Setter
class LibraryCard {
    private int cardNumber;
    private Member member;

    public LibraryCard(int cardNumber, Member member) {
        this.cardNumber = cardNumber;
        this.member = member;
    }
}

// Member class representing a library member
@Getter
@Setter
class Member {
    private int memberId;
    private String name;
    private LibraryCard libraryCard;
    private List<BookCopy> borrowedBooks;
    private List<Reservation> reservations;

    public Member(int memberId, String name, LibraryCard libraryCard) {
        this.memberId = memberId;
        this.name = name;
        this.libraryCard = libraryCard;
        this.borrowedBooks = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public int getLibraryCardNumber() {
        return libraryCard.getCardNumber();
    }

    public void borrowBook(BookCopy bookCopy) {
        borrowedBooks.add(bookCopy);
    }

    public void returnBook(BookCopy bookCopy) {
        borrowedBooks.remove(bookCopy);
    }

    public boolean canBorrowBook() {
        return borrowedBooks.size() < 10;
    }
}

// Librarian class representing a librarian user
@Getter
@Setter
class Librarian {
    private int staffId;
    private String name;
    private LibraryCard libraryCard;

    public Librarian(int staffId, String name, LibraryCard libraryCard) {
        this.staffId = staffId;
        this.name = name;
        this.libraryCard = libraryCard;
    }

    public int getLibraryCardNumber() {
        return libraryCard.getCardNumber();
    }

    public void addBookCopy(BookCopy bookCopy, LibraryBranch branch) {
        branch.addBookCopy(bookCopy);
    }

    public void removeBookCopy(BookCopy bookCopy, LibraryBranch branch) {
        branch.removeBookCopy(bookCopy);
    }
}

// Reservation class representing a book reservation made by a member
@Getter
@Setter
class Reservation {
    private Member member;
    private BookCopy bookCopy;
    private Date reservationDate;

    public Reservation(Member member, BookCopy bookCopy) {
        this.member = member;
        this.bookCopy = bookCopy;
        this.reservationDate = new Date();
    }
}

// LibraryBranch class representing a branch of the library
@Getter
@Setter
class LibraryBranch {
    private int branchId;
    private String branchName;
    private Map<Integer, BookCopy> bookCopies;
    private Map<Integer, Reservation> reservations;

    public LibraryBranch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.bookCopies = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.put(bookCopy.getBookCopyId(), bookCopy);
    }

    public void removeBookCopy(BookCopy bookCopy) {
        bookCopies.remove(bookCopy.getBookCopyId());
    }

    public void addReservation(Reservation reservation) {
        reservations.put(reservation.getBookCopy().getBookCopyId(), reservation);
    }

    public void removeReservation(BookCopy bookCopy) {
        reservations.remove(bookCopy.getBookCopyId());
    }
}

// NotificationService class to handle notifications
class NotificationService {
    public void sendNotification(Member member, String message) {
        // Implement notification sending mechanism
        System.out.println("Notification sent to member " + member.getName() + ": " + message);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {
        // Create library branches
        LibraryBranch mainBranch = new LibraryBranch(1, "Main Branch");
        LibraryBranch branch2 = new LibraryBranch(2, "Branch 2");

        // Create books
        Book book1 = new Book(1, "ISBN001", "Book1", "Author1", "Fiction", new Date());
        Book book2 = new Book(2, "ISBN002", "Book2", "Author2", "Mystery", new Date());

        // Create book copies
        BookCopy bookCopy1 = new BookCopy(101, book1, 101);
        BookCopy bookCopy2 = new BookCopy(102, book1, 102);
        BookCopy bookCopy3 = new BookCopy(201, book2, 201);
        BookCopy bookCopy4 = new BookCopy(202, book2, 202);

        // Add book copies to branches
        mainBranch.addBookCopy(bookCopy1);
        mainBranch.addBookCopy(bookCopy2);
        branch2.addBookCopy(bookCopy3);
        branch2.addBookCopy(bookCopy4);

        // Create library cards for members
        LibraryCard memberCard1 = new LibraryCard(1001, new Member(1001, "John Doe", memberCard1));
        LibraryCard memberCard2 = new LibraryCard(1002, new Member(1002, "Jane Smith", memberCard2));

        // Create librarian
        // LibraryCard librarianCard = new LibraryCard(2001, new Librarian(2001,
        // "Librarian Name", librarianCard));

        LibraryCard librarianCard = new LibraryCard(2001, new Librarian(2001, "Librarian Name", null));

        // Issue books
        LibraryUser user1 = memberCard1.getMember();
        if (user1 instanceof Member) {
            Member member = (Member) user1;
            if (member.canBorrowBook()) {
                member.borrowBook(bookCopy1);
                System.out.println("Book issued to member: " + member.getName());
            } else {
                System.out.println("Maximum limit reached for member: " + member.getName());
            }
        }

        // Reserve a book
        Member member = memberCard2.getMember();
        Reservation reservation = new Reservation(member, bookCopy3);
        branch2.addReservation(reservation);
        System.out.println("Book reserved by member: " + member.getName());

        // Send notification if book not returned within due date
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(member, "Please return the book within due date.");

        // Remove book copy
        Librarian librarian = (Librarian) librarianCard.getMember();
        librarian.removeBookCopy(bookCopy4, branch2);
        System.out.println("Book copy removed by librarian.");
    }
}
