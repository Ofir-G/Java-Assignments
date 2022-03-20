//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MovieTheater nicolesMovieTheater = new MovieTheater("Nicoles", 17, 10); //create movie theater

        //create movies
        M_Comedy movie1 = new M_Comedy("Java's Homework", 340);
        M_Horror movie2 = new M_Horror("Effi's Tirgul", 500);
        M_Thriller movie3 = new M_Thriller("The amazing Tom", 750);

        //add movies to movie theater
        nicolesMovieTheater.addMovie(movie1);
        nicolesMovieTheater.addMovie(movie2);
        nicolesMovieTheater.addMovie(movie3);

        //create customers
        C_Soldier customer1 = new C_Soldier("Maayan", 123, "Maayan@go.com", 852, LocalDate.of(1994, 5, 10), LocalDate.of(2022, 5, 10));
        C_Retiree customer2 = new C_Retiree("Ofir", 234, "ofir@ma.com", 963, LocalDate.of(1920, 10, 15));
        C_Student customer3 = new C_Student("Ron", 456, "ron@yas.com", 741, LocalDate.of(1980, 2, 27), LocalDate.of(2022, 10, 30), "MTA");

        //add customers to movie theater
        nicolesMovieTheater.addCustomer(customer1);
        nicolesMovieTheater.addCustomer(customer2);
        nicolesMovieTheater.addCustomer(customer3);

        //create employees
        Employee employee1 = new Employee("David", 546123, "David.com", 23146, LocalDate.of(1985, 2, 4), 31);
        Employee employee2 = new Employee("Omer", 2354645, "Omer.com", 54623198, LocalDate.of(1993, 2, 8), 50);

        //add employees to movie theater
        nicolesMovieTheater.addEmployee(employee1);
        nicolesMovieTheater.addEmployee(employee2);

        //print movie theater details
        System.out.println(nicolesMovieTheater);

        //sell tickets
        nicolesMovieTheater.ticketSell();
        nicolesMovieTheater.ticketSell();
        nicolesMovieTheater.ticketSell();

        //sell popcorn
        nicolesMovieTheater.popSell();
        nicolesMovieTheater.popSell();
        nicolesMovieTheater.popSell();

        //create new movie
        M_Comedy movie4 = new M_Comedy("100 in java exam", 8544);

        //update new movie
        nicolesMovieTheater.updateMovie("Effi's Tirgul", movie4);
    }
}
