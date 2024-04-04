package com.example.LibrarySystem.LibrarySystem1;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

// Book class representing a book
@Getter
@Setter
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

// Member class representing a library member
@Getter
@Setter
class Member {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void removeBook(int bookId) {
        books.remove(bookId);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void removeMember(int memberId) {
        members.remove(memberId);
    }

    public boolean lendBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member != null && book != null && book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailable(false);
            return true;
        }

        return false;
    }

    public boolean returnBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member != null && book != null && !book.isAvailable() && member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.setAvailable(true);
            return true;
        }

        return false;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Create library
        Library library = new Library();

        // Add books
        Book book1 = new Book(1, "Book1", "Author1");
        Book book2 = new Book(2, "Book2", "Author2");
        library.addBook(book1);
        library.addBook(book2);

        // Add members
        Member member1 = new Member(101, "Member1");
        Member member2 = new Member(102, "Member2");
        library.addMember(member1);
        library.addMember(member2);

        // Lend books
        library.lendBook(101, 1);
        library.lendBook(102, 2);

        // Return books
        library.returnBook(101, 1);
        library.returnBook(102, 2);
    }
}
