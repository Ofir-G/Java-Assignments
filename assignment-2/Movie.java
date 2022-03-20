//Employee can't be a student/retiree/soldier and gets regular price

public abstract class Movie {
    protected String name;
    protected int movieLength;
    protected int minAge;

    public Movie(String name, int movieLength, int minAge) {
        this.name = name;
        this.movieLength = movieLength;
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public int getMinAge() {
        return minAge;
    }

    //checks customer is older than min age
    public boolean ageCheck(Customer customer) {
        return customer.getAge() > minAge;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Movie) {
            Movie movie = (Movie) other;
            return movie.name.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", movieLength=" + movieLength +
                ", minAge=" + minAge +
                '}';
    }
}
