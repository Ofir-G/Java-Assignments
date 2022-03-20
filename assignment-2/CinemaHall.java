//Employee can't be a student/retiree/soldier and gets regular price

import java.util.Arrays;
import java.util.Objects;

public abstract class CinemaHall {
    protected int hallNumber;
    protected Movie showingMovie;
    protected int[][] seats;
    protected int price;

    public CinemaHall(int hallNumber, Movie showingMovie, int rows, int columns, int price) {
        this.hallNumber = hallNumber;
        this.showingMovie = showingMovie;
        seats = new int[rows][columns];
        this.price = price;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Movie getShowingMovie() {
        return showingMovie;
    }

    public void setShowingMovie(Movie showingMovie) {
        this.showingMovie = showingMovie;
    }

    public int[][] getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }

    public Ticket ticketSell(Customer customer) {
        int discoutPrice = customer.discount(price); //apply price discount
        int flag = 0;
        int chairNumber = 0;
        int rowNumber = 0;
        //checks empty seat from last and most right seat
        for (int i = seats.length - 1; (i >= 0 && flag == 0); i--) {
            for (int j = seats[0].length - 1; (j >= 0 && flag == 0); j--) {
                if (seats[i][j] == 0) {
                    rowNumber = i;
                    chairNumber = j;
                    flag = 1; //found empty seat
                    seats[i][j] = 1; //mark as taken
                }
            }
        }
        Ticket ticket = new Ticket(showingMovie.getName(), hallNumber, rowNumber, chairNumber, price); //generate new ticket
        return ticket;
    }

    public void updateMovie(Movie movie) {
        this.setShowingMovie(movie); //change movie

        //reset all seats
        for (int i = 0; (i < seats.length); i++) {
            for (int j = 0; (j < seats[0].length); j++) {
                seats[i][j] = 0;
            }
        }
    }

    //counts empty seats in hall
    public int emptySeats() {
        int counter = 0;
        for (int i = 0; i < seats.length; ++i) {
            for (int j = 0; j < seats[i].length; ++j) {
                if (seats[i][j] == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "CinemaHall{" +
                "hallNumber=" + hallNumber +
                ", showingMovie=" + showingMovie +
                ", seats=" + Arrays.toString(seats) +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof CinemaHall)) return false;
        CinemaHall that = (CinemaHall) o;
        return hallNumber == that.hallNumber && price == that.price && Objects.equals(showingMovie, that.showingMovie) && Arrays.equals(seats, that.seats);
    }

}
