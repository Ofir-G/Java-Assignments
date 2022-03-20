//Employee can't be a student/retiree/soldier and gets regular price

import java.util.Objects;

public class Ticket {
    private String movieName;
    private int hallNumber;
    private int rowNumber;
    private int chairNumber;
    private int price;

    public Ticket(String name, int hallNumber, int rowNumber, int chairNumber, int price) {
        this.movieName = name;
        this.hallNumber = hallNumber;
        this.rowNumber = rowNumber;
        this.chairNumber = chairNumber;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                ", hallNumber=" + hallNumber +
                ", rowNumber=" + rowNumber +
                ", chairNumber=" + chairNumber +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return hallNumber == ticket.hallNumber && rowNumber == ticket.rowNumber && chairNumber == ticket.chairNumber && price == ticket.price && Objects.equals(movieName, ticket.movieName);
    }

}
