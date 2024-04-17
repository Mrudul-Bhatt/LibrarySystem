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
    // show here refers to an instance of the ShowTime class
    public boolean addShow(Movie show);

    public boolean updateShow(Movie show);

    public boolean deleteShow(Movie show);

    public boolean addMovie(Movie movie);

    public boolean deleteMovie(Movie movie);
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
}

@Getter
@Setter
class Cinema {
    private int cinemaId;
    private List<Hall> halls;
    private City city;
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
}

abstract class Payment {
    private double amount;

    private Date timestamp;
    private PaymentStatus status;

    public abstract boolean makePayment();
}

class Cash extends Payment {
    public boolean makePayment() {
    }
}

class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public boolean makePayment() {
    }
}

abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public abstract void sendNotification(Person person);
}

class EmailNotification extends Notification {
    public void sendNotification(Person person) {
    }
}

class PhoneNotification extends Notification {
    public void sendNotification(Person person) {
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
}
