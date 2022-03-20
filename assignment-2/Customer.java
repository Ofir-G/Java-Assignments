//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Customer extends Person implements iCustomer {
    //Constructor
    public Customer(String name, int ID, String email, int phone, LocalDate birthDate) {
        super(name, ID, email, phone, birthDate);
    }

    public Movie chooseMovie(Movie[] movieList) {
        //arraylist of allowed movies according to person's age
        ArrayList<Movie> customerMovies = new ArrayList();

        for (int i = 0; i < movieList.length && movieList[i] != null; i++) {
            if (movieList[i].ageCheck(this)) {
                customerMovies.add(movieList[i]); //add movie to list
            }
        }

        Random random_method = new Random();
        int index = random_method.nextInt(customerMovies.size()); //choose random movie from allowed list

        return customerMovies.get(index); //return chosen movie
    }

    public int popcornSize() {
        // small=1, medium=2, big=3
        Random random = new Random();
        int popSize = random.nextInt(4 - 1) + 1; //random popcorn size

        return popSize;
    }

    public int discount(int price) {
        return price;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone=" + phone + ", age=" + getAge() +
                '}';
    }

}
