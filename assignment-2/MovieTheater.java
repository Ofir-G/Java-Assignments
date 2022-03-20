//Employee can't be a student/retiree/soldier and gets regular price

import java.util.ArrayList;
import java.util.Objects;

public class MovieTheater {
    private String name;
    private ArrayList<Employee> employeeList;
    private ArrayList<Customer> customerList;
    private Movie movieList[];
    private CinemaHall hallList[];
    public static final int SMALL_POP_PRICE = 10;
    public static final int MEDIUM_POP_PRICE = 20;
    public static final int BIG_POP_PRICE = 30;

    //Constructor
    public MovieTheater(String name, int movieListSize, int hallListSize) {
        this.name = name;
        this.movieList = new Movie[movieListSize];
        this.hallList = new CinemaHall[hallListSize];

        //adding one of every kind in cycle
        for (int i = 0; i < hallListSize; i++) {
            if (i % 3 == 0) {
                hallList[i] = new H_Small(i + 1, null);
            }
            if (i % 3 == 1) {
                hallList[i] = new H_Big(i + 1, null);
            }
            if (i % 3 == 2) {
                hallList[i] = new H_VIP(i + 1, null);
            }
        }

        employeeList = new ArrayList<>();
        customerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public Movie[] getMovieList() {
        return movieList;
    }

    public CinemaHall[] getHallList() {
        return hallList;
    }

    public void addMovie(Movie movie) {
        int movieFlag = 0;
        int hallFlag = 0;
        int movieIndex = 0;
        int hallIndex = 0;
        int hallShow = 0;

        //checks if movie is in movie list
        for (int i = 0; i < movieList.length && movieFlag == 0; i++) {
            if (movieList[i] == null) {
                movieIndex = i;
                movieFlag = 1; //found flag
            }
        }

        //checks if movie is showing in at least one hall
        for (int i = 0; i < hallList.length && hallFlag == 0; i++) {
            if (hallList[i].getShowingMovie() == null) {
                hallIndex = i;
                hallFlag = 1; //found flag
            }
        }

        //if movie is in movie list and showing in hall
        if (hallFlag == 1 && movieFlag == 1) {
            movieList[movieIndex] = movie;
            if (movieList.length % hallList.length == 0) //if remainder is 0
            {
                hallShow = movieList.length / hallList.length;
            } else //if remainder is not 0, round up
            {
                hallShow = (movieList.length / hallList.length) + 1;
            }

            //update movies in all relevant halls
            for (int i = hallIndex; i < (hallShow + hallIndex) && i < hallList.length; i++) {
                hallList[i].updateMovie(movie);
            }
        } else //movie list or hall list is full
        {
            System.out.println("Either Movie List or Hall List is full.");
        }
    }

    public void updateMovie(String oldMovieName, Movie movie) {
        boolean foundFlag = false;

        //check if old movie name exists in movie list
        for (int i = 0; i < movieList.length && movieList[i] != null && !foundFlag; i++) {
            if (movieList[i].getName().equals(oldMovieName)) {
                movieList[i] = movie; //change old movie to new
                foundFlag = true; //found old movie
            }
        }
        if (foundFlag) //old movie was found in list
        {
            //change movie for relevant halls
            for (int i = 0; i < hallList.length && hallList[i].getShowingMovie() != null; i++) {
                if (hallList[i].showingMovie.getName().equals(oldMovieName)) {
                    hallList[i].setShowingMovie(movie);
                }
            }
        } else //movie was not found
        {
            System.out.println("No movie with the name: " + oldMovieName + " was found.");
        }
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int ID) {
        int flag = 0;
        for (Employee employee : employeeList) {
            // check if demands are met
            if (employee.getID() == ID) {
                employeeList.remove(employee);
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Employee ID: " + ID + " was removed.");
        } else {
            System.out.println("Employee ID: " + ID + " was not found.");
        }
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(int ID) {
        int flag = 0;
        for (Customer customer : customerList) {
            // check if demands are met
            if (customer.getID() == ID) {
                customerList.remove(customer);
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Customer ID: " + ID + " was removed.\"");
        } else {
            System.out.println("Customer ID: " + ID + " was not found.");
        }
    }

    public void ticketSell() {
        int randomEmployee = (int) (Math.random() * employeeList.size()); //random employee
        int randomCustomer = (int) (Math.random() * customerList.size()); //random customer
        Movie chosenMovie = customerList.get(randomCustomer).chooseMovie(movieList); //choose random movie
        Ticket ticket = employeeList.get(randomEmployee).sellTicket(customerList.get(randomCustomer), chosenMovie, hallList); //generate ticket
        System.out.println("Ticket sell....");
        System.out.println(employeeList.get(randomEmployee));
        System.out.println(customerList.get(randomCustomer));
        System.out.println(ticket);
        System.out.println();
    }

    public void popSell() {
        int randomEmployee = (int) (Math.random() * employeeList.size()); //random employee
        int randomCustomer = (int) (Math.random() * customerList.size()); //random customer
        int randomPopSize = customerList.get(randomCustomer).popcornSize(); //random popcorn size
        int popPrice = employeeList.get(randomEmployee).sellPop(randomPopSize, customerList.get(randomCustomer)); //popcorn price after discount
        System.out.println("Popcorn sell....");
        System.out.println(employeeList.get(randomEmployee));
        System.out.println(customerList.get(randomCustomer));
        if (randomPopSize == 1) {
            System.out.println("Popcorn size: small, " + "Price: " + popPrice);
        } else if (randomPopSize == 2) {
            System.out.println("Popcorn size: medium, " + "Price: " + popPrice);
        } else if (randomPopSize == 3) {
            System.out.println("Popcorn size: big, " + "Price: " + popPrice);
        }
        System.out.println();
    }

    //counts movies showing in halls
    private int moviesShowing() {
        int sum = 0;
        for (int i = 0; i < movieList.length; i++) {
            if (movieList[i] != null) {
                sum += 1;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "MovieTheater{" +
                "name='" + name + '\'' +
                ", Number of movies showing: " + moviesShowing() +
                ", Number of halls: " + hallList.length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTheater that = (MovieTheater) o;
        return Objects.equals(name, that.name);
    }


}
