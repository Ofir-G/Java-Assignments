//Employee can't be a student/retiree/soldier and gets regular price

public class H_Small extends CinemaHall {
    //rows & cols & price are const
    public H_Small(int hallNumber, Movie movie) {
        super(hallNumber, movie, 8, 10, 30);
    }
}
