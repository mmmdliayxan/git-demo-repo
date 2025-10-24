package model;

import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private ReservationSeatNumber seatNumber;
    private LocalDateTime dateTime;
    private Movie movie;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReservationSeatNumber(ReservationSeatNumber seatNumber){
        this.seatNumber = seatNumber;

    }

    public ReservationSeatNumber getSeatNumber() {
        return seatNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setSeatNumber(ReservationSeatNumber seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
