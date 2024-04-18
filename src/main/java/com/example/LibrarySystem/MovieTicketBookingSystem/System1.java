package com.example.LibrarySystem.MovieTicketBookingSystem;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum PaymentStatus {
    PENDING,
    CONFIRMED,
    DECLINED,
    REFUNDED
}

enum BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    DENIED,
    REFUNDED
}

enum SeatStatus {
    AVAILABLE,
    BOOKED,
    RESERVED
}

interface Search {
    public List<Movie> searchMovieTitle(String title);

    public List<Movie> searchMovieLanguage(String language);

    public List<Movie> searchMovieGenre(String genre);

    public List<Movie> searchMovieReleaseDate(Date date);
}

@Getter
@Setter
abstract class Person {
    private String name;
    private String address;
    private String phone;
    private String email;
}

@Getter
@Setter
class Customer extends Person {
    private List<Booking> bookings;

    public Customer(String name, String address, String phone, String email) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setEmail(email);
        this.bookings = new ArrayList<>();
    }

    public boolean createBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
            return true;
        }
        return false;
    }

    public boolean updateBooking(Booking booking) {
        int index = bookings.indexOf(booking);
        if (index != -1) {
            bookings.set(index, booking);
            return true;
        }
        return false;
    }

    public boolean deleteBooking(Booking booking) {
        if (bookings.contains(booking)) {
            bookings.remove(booking);
            return true;
        }
        return false;
    }
}

class Admin extends Person {
    public boolean addShowTime(ShowTime showTime, Hall hall) {
        if (hall != null) {
            hall.addShowTime(showTime);
            return true;
        }
        return false;
    }

    // Method to update a show time in a specific hall
    public boolean updateShowTime(ShowTime newShowTime, ShowTime oldShowTime, Hall hall) {
        if (hall != null) {
            List<ShowTime> shows = hall.getShows();
            int index = shows.indexOf(oldShowTime);
            if (index != -1) {
                shows.set(index, newShowTime);
                return true;
            }
        }
        return false;
    }

    // Method to delete a show time from a specific hall
    public boolean deleteShowTime(ShowTime showTime, Hall hall) {
        if (hall != null) {
            hall.removeShowTime(showTime);
            return true;
        }
        return false;
    }

    // Method to add a movie to the system
    public boolean addMovie(Movie movie, Catalog catalog) {
        if (catalog != null && movie != null) {
            catalog.addMovie(movie);
            return true;
        }
        return false;
    }

    // Method to delete a movie from the system
    public boolean deleteMovie(Movie movie, Catalog catalog) {
        if (catalog != null && movie != null) {
            // Implement logic to remove the movie from all halls and cinemas before
            // deleting
            // For simplicity, let's assume we don't have this requirement for now
            catalog.deleteMovie(movie);
        }
        return false;
    }
}

class TicketAgent extends Person {
    // booking here refers to an instance of the Booking class
    public boolean createBooking(Booking booking);
}

@Getter
@Setter
abstract class Seat {
    private String seatNo;
    private SeatStatus status;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.status = SeatStatus.AVAILABLE; // By default, a seat is available
    }

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    public abstract void setSeat(SeatStatus seatStatus);

    public abstract void setRate(double rate);

    public abstract double getRate();
}

@Getter
@Setter
class Platinum extends Seat {
    private double rate;

    public Platinum(String seatNo, double rate) {
        super(seatNo);
        this.rate = rate;
    }

    public void setSeat(SeatStatus seatStatus) {
        this.setSeat(seatStatus);
    }

    public void setRate(double rate) {
        this.setRate(rate);
    }
}

@Getter
@Setter
class Gold extends Seat {
    private double rate;

    public Gold(String seatNo, double rate) {
        super(seatNo);
        this.rate = rate;
    }

    public void setSeat(SeatStatus seatStatus) {
        this.setSeat(seatStatus);
    }

    public void setRate(double rate) {
        this.setRate(rate);
    }
}

@Getter
@Setter
class Silver extends Seat {
    private double rate;

    public Silver(String seatNo, double rate) {
        super(seatNo);
        this.rate = rate;
    }

    public void setSeat(SeatStatus seatStatus) {
        this.setSeat(seatStatus);
    }

    public void setRate(double rate) {
        this.setRate(rate);
    }
}

@Getter
@Setter
class Movie {
    private String title;
    private String genre;
    private Date releaseDate;
    private String language;
    private int duration;
    private List<ShowTime> shows;

    public Movie(String title, String genre, Date releaseDate, String language, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.language = language;
        this.duration = duration;
        this.shows = new ArrayList<>();
    }

    public void addShowTime(ShowTime showTime) {
        shows.add(showTime);
    }

    public void removeShowTime(ShowTime showTime) {
        shows.remove(showTime);
    }

}

@Getter
@Setter
class ShowTime {
    private int showId;
    private Date startTime;
    private Date date;
    private int duration;
    private List<Seat> seats;

    public ShowTime(int showId, Date startTime, Date date, int duration) {
        this.showId = showId;
        this.startTime = startTime;
        this.date = date;
        this.duration = duration;
        this.seats = new ArrayList<>();
    }

    public void showAvailableSeats() {
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                System.out.println("Seat " + seat.getSeatNo() + " is available.");
            }
        }
    }

}

@Getter
@Setter
class MovieTicket {
    private int ticketId;
    private Seat seat;
    private Movie movie;
    private ShowTime show;

    public MovieTicket(int ticketId, Seat seat, Movie movie, ShowTime show) {
        this.ticketId = ticketId;
        this.seat = seat;
        this.movie = movie;
        this.show = show;
    }
}

@Getter
@Setter
class City {
    private String name;
    private String state;
    private int zipCode;
    private List<Cinema> cinemas;

    public City(String name, String state, int zipCode) {
        this.name = name;
        this.state = state;
        this.zipCode = zipCode;
        this.cinemas = new ArrayList<>();
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void removeCinema(Cinema cinema) {
        cinemas.remove(cinema);
    }

}

@Getter
@Setter
class Cinema {
    private int cinemaId;
    private List<Hall> halls;
    private City city;

    public Cinema(int cinemaId, City city) {
        this.cinemaId = cinemaId;
        this.city = city;
        this.halls = new ArrayList<>();
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public void removeHall(Hall hall) {
        halls.remove(hall);
    }
}

@Getter
@Setter
class Hall {
    private int hallId;
    private List<ShowTime> shows;

    public Hall(int hallId) {
        this.hallId = hallId;
        this.shows = new ArrayList<>();
    }

    public List<ShowTime> findCurrentShows() {
        List<ShowTime> currentShows = new ArrayList<>();
        Date currentTime = new Date();
        for (ShowTime show : shows) {
            if (show.getStartTime().after(currentTime)) {
                currentShows.add(show);
            }
        }
        return currentShows;
    }

    public void addShowTime(ShowTime showTime) {
        this.shows.add(showTime);
    }

    public void removeShowTime(ShowTime showTime) {
        this.shows.remove(showTime);
    }
}

@Getter
@Setter
abstract class Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus status;

    public Payment(double amount, Date timestamp, PaymentStatus status) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    public abstract boolean makePayment();
}

class Cash extends Payment {
    public Cash(double amount, Date timestamp, PaymentStatus status) {
        super(amount, timestamp, status);
    }

    // Implementing the makePayment method for cash payment
    @Override
    public boolean makePayment() {
        // Implementation for cash payment
        return true; // Assuming payment is always successful
    }
}

@Getter
@Setter
class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public CreditCard(double amount, Date timestamp, PaymentStatus status,
            String nameOnCard, String cardNumber, String billingAddress, int code) {
        super(amount, timestamp, status);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.billingAddress = billingAddress;
        this.code = code;
    }

    @Override
    public boolean makePayment() {
        // Implementation for credit card payment
        return true; // Assuming payment is always successful
    }
}

abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public Notification(int notificationId, Date createdOn, String content) {
        this.notificationId = notificationId;
        this.createdOn = createdOn;
        this.content = content;
    }

    public abstract void sendNotification(Person person);
}

class EmailNotification extends Notification {
    public EmailNotification(int notificationId, Date createdOn, String content) {
        super(notificationId, createdOn, content);
    }

    // Implementing the sendNotification method for email notification
    @Override
    public void sendNotification(Person person) {
        // Implementation for sending email notification
        // Example:
        System.out.println("Email notification sent to: " + person.getEmail() + "\nContent: " + getContent());
    }
}

class PhoneNotification extends Notification {
    public PhoneNotification(int notificationId, Date createdOn, String content) {
        super(notificationId, createdOn, content);
    }

    // Implementing the sendNotification method for phone notification
    @Override
    public void sendNotification(Person person) {
        // Implementation for sending phone notification
        // Example:
        System.out.println("Phone notification sent to: " + person.getPhone() + "\nContent: " + getContent());
    }
}

@Getter
@Setter
class Booking {
    private int bookingId;
    private int amount;
    private int totalSeats;
    private Date createdOn;
    private BookingStatus status;
    private Payment payment;
    private List<MovieTicket> tickets;
    private List<Seat> seats;

    public Booking(int bookingId, int amount, int totalSeats, Date createdOn, BookingStatus status) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.totalSeats = totalSeats;
        this.createdOn = createdOn;
        this.status = status;
        this.status = BookingStatus.PENDING;
        this.tickets = new ArrayList<>();
        this.seats = new ArrayList<>();
    }

    public void addTicket(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(MovieTicket ticket) {
        tickets.remove(ticket);
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Seat seat : seats) {
            totalCost += seat.getRate();
        }
        return totalCost;
    }

    public boolean makePayment(Payment payment) {
        // Make payment using the provided payment method
        boolean paymentStatus = payment.makePayment();

        if (paymentStatus) {
            // If payment is successful, update payment status and booking status
            this.payment.setStatus(PaymentStatus.CONFIRMED);
            this.status = BookingStatus.CONFIRMED;
            return true;
        } else {
            // If payment fails, update payment status to declined
            this.payment.setStatus(PaymentStatus.DECLINED);
            return false;
        }
    }

    public void generateBookingNotification(Notification notification) {
        // Send notification to relevant persons
        notification.sendNotification(customer);
        notification.sendNotification(ticketAgent);
        // Additional logic if needed
    }

    // Method to generate a notification when a booking is canceled
    public void generateCancellationNotification(Notification notification) {
        // Send cancellation notification to relevant persons
        notification.sendNotification(customer);
        notification.sendNotification(ticketAgent);
        // Additional logic if needed
    }
}

class SystemManager {
    // Method to generate a notification when a new movie is released
    public void generateNewMovieNotification(Notification notification) {
        // Send notification to relevant persons
        notification.sendNotification(admin);
        // Additional logic if needed
    }
}

class Catalog implements Search {
    HashMap<String, List<Movie>> movieTitles;
    HashMap<String, List<Movie>> movieLanguages;
    HashMap<String, List<Movie>> movieGenres;
    HashMap<Date, List<Movie>> movieReleaseDates;

    public Catalog() {
        this.movieTitles = new HashMap<>();
        this.movieLanguages = new HashMap<>();
        this.movieGenres = new HashMap<>();
        this.movieReleaseDates = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        // Add to title index
        String titleKey = movie.getTitle().toLowerCase();
        if (!movieTitles.containsKey(titleKey)) {
            movieTitles.put(titleKey, new ArrayList<>());
        }
        movieTitles.get(titleKey).add(movie);

        // Add to language index
        String languageKey = movie.getLanguage().toLowerCase();
        if (!movieLanguages.containsKey(languageKey)) {
            movieLanguages.put(languageKey, new ArrayList<>());
        }
        movieLanguages.get(languageKey).add(movie);

        // Add to genre index
        String genreKey = movie.getGenre().toLowerCase();
        if (!movieGenres.containsKey(genreKey)) {
            movieGenres.put(genreKey, new ArrayList<>());
        }
        movieGenres.get(genreKey).add(movie);

        // Add to release date index
        Date releaseDate = movie.getReleaseDate();
        if (!movieReleaseDates.containsKey(releaseDate)) {
            movieReleaseDates.put(releaseDate, new ArrayList<>());
        }
        movieReleaseDates.get(releaseDate).add(movie);
    }

    public boolean deleteMovie(Movie movie) {
        // Remove the movie from all indexes in the catalog
        String titleKey = movie.getTitle().toLowerCase();
        if (movieTitles.containsKey(titleKey)) {
            movieTitles.remove(titleKey);
        }
        String languageKey = movie.getLanguage().toLowerCase();
        if (movieLanguages.containsKey(languageKey)) {
            movieLanguages.remove(languageKey);
        }
        String genreKey = movie.getGenre().toLowerCase();
        if (movieGenres.containsKey(genreKey)) {
            movieGenres.remove(genreKey);
        }
        Date releaseDate = movie.getReleaseDate();
        if (movieReleaseDates.containsKey(releaseDate)) {
            movieReleaseDates.remove(releaseDate);
        }
        // Return true if the movie was successfully deleted
        return true;
    }

    // Method to search movies by title
    @Override
    public List<Movie> searchMovieTitle(String title) {
        String key = title.toLowerCase();
        return movieTitles.getOrDefault(key, new ArrayList<>());
    }

    // Method to search movies by language
    @Override
    public List<Movie> searchMovieLanguage(String language) {
        String key = language.toLowerCase();
        return movieLanguages.getOrDefault(key, new ArrayList<>());
    }

    // Method to search movies by genre
    @Override
    public List<Movie> searchMovieGenre(String genre) {
        String key = genre.toLowerCase();
        return movieGenres.getOrDefault(key, new ArrayList<>());
    }

    // Method to search movies by release date
    @Override
    public List<Movie> searchMovieReleaseDate(Date date) {
        return movieReleaseDates.getOrDefault(date, new ArrayList<>());
    }
}

public class System1 {

    public static void main() {

        City city1 = new City("City 1", "State 1", 12345);
        Cinema cinema1 = new Cinema(1, city1);
        Hall hall1 = new Hall(1);
        cinema1.addHall(hall1);

        // Create instances of movies, show times, etc.
        Movie movie1 = new Movie("Movie 1", "Action", new Date(), "English", 120);
        ShowTime showTime1 = new ShowTime(1, new Date(), new Date(), 120);
        hall1.addShowTime(showTime1);

        // Create instances of customers, admins, ticket agents, etc.
        Customer customer1 = new Customer("Customer 1", "Address 1", "1234567890", "customer1@example.com");
        Admin admin1 = new Admin("Admin 1", "Address 2", "0987654321", "admin1@example.com");
        TicketAgent ticketAgent1 = new TicketAgent("Ticket Agent 1", "Address 3", "9876543210", "agent1@example.com");

        // Create instances of payments
        Payment cashPayment = new Cash(100.0, new Date(), PaymentStatus.PENDING);
        Payment creditCardPayment = new CreditCard(50.0, new Date(), PaymentStatus.PENDING,
                "John Doe", "1234 5678 9012 3456", "Billing Address", 123);

        // Create instances of notifications
        Notification emailNotification = new EmailNotification(1, new Date(), "Notification content");
        Notification phoneNotification = new PhoneNotification(2, new Date(), "Notification content");

        // Simulate booking process
        Booking booking1 = new Booking(1, 50, new Date(), BookingStatus.PENDING, creditCardPayment);
        if (booking1.makePayment(creditCardPayment)) {
            booking1.generateBookingNotification(emailNotification);
        }

        // Simulate cancellation process
        Booking booking2 = new Booking(2, 50, new Date(), BookingStatus.PENDING, cashPayment);
        if (booking2.makePayment(cashPayment)) {
            booking2.generateCancellationNotification(phoneNotification);
        }

        // Simulate notification for new movie release
        Movie movie2 = new Movie("Movie 2", "Comedy", new Date(), "English", 90);
        Notification movieReleaseNotification = new EmailNotification(3, new Date(), "New movie released: Movie 2");
        SystemManager systemManager = new SystemManager();
        systemManager.generateNewMovieNotification(movieReleaseNotification);
    }
}
