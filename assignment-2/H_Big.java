//Employee can't be a student/retiree/soldier and gets regular price

public class H_Big extends CinemaHall {
    //rows & cols & price are const
    public H_Big(int hallNumber, Movie movie) {
        super(hallNumber, movie, 16, 20, 42);
    }

}
