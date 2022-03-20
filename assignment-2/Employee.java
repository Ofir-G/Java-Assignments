//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Employee extends Person implements iCustomer, iEmployee {
    private int[] workingHours = new int[30]; //every index represents day in a month
    private int salaryPerHour;

    public Employee(String name, int ID, String email, int phone, LocalDate birthDate, int salaryPerHour) {
        super(name, ID, email, phone, birthDate);
        this.salaryPerHour = salaryPerHour;
    }

    public int[] getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int day, int amount) {
        this.workingHours[day - 1] = amount;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int sellPop(int popSize, Customer customer) {
        if (popSize == 1) //small
        {
            return customer.discount(MovieTheater.SMALL_POP_PRICE);
        } else if (popSize == 2) //medium
        {
            return customer.discount(MovieTheater.MEDIUM_POP_PRICE);
        } else {
            //big
            return customer.discount(MovieTheater.BIG_POP_PRICE);
        }
    }

    @Override
    public Ticket sellTicket(Customer customer, Movie movie, CinemaHall[] cinemaHallList) {
        int maxCounter = cinemaHallList[0].emptySeats(); //variable for max empty seats
        int index = 0; //index of hall with max empty seats
        for (int i = 0; i < cinemaHallList.length && (cinemaHallList[i].getShowingMovie() != null); i++) {
            if (cinemaHallList[i].getShowingMovie().getName().equals(movie.getName())) //same movie name
            {
                if (cinemaHallList[i].emptySeats() > maxCounter) //current hall has more empty seats than max counter
                {
                    maxCounter = cinemaHallList[i].emptySeats(); //save to max
                    index = i; //save index
                }
            }
        }

        return cinemaHallList[index].ticketSell(customer); //return ticket from chosen hall
    }

    public int monthSalary() //calculates monthly salary
    {
        int salarySum = 0;
        for (int i = 0; i < this.workingHours.length; i++) {
            salarySum = salarySum + (workingHours[i] * salaryPerHour); //every day hours * salary per hour
        }
        return salarySum;
    }

    @Override
    public int popcornSize() {
        // small=1, medium=2, big=3
        Random random = new Random();
        int popSize = random.nextInt(4 - 1) + 1; //choose random

        return popSize;
    }

    @Override
    public int discount(int price) {
        return price;
    }

    @Override
    public Movie chooseMovie(Movie[] movieList) {
        //arraylist of allowed movies according to person's age
        ArrayList<Movie> customerMovies = new ArrayList();

        for (int i = 0; i < movieList.length && movieList[i] != null; i++) {
            if (this.getAge() > movieList[i].getMinAge()) {
                customerMovies.add(movieList[i]); //add movie to list
            }
        }

        Random random_method = new Random();
        int index = random_method.nextInt(customerMovies.size()); //choose random movie from allowed list

        return customerMovies.get(index); //return chosen movie
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phone=" + phone + ", age=" + getAge() +
                '}';
    }
}


