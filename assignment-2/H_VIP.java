//Employee can't be a student/retiree/soldier and gets regular price

public class H_VIP extends CinemaHall {
    //rows & cols & price are const
    public H_VIP(int hallNumber, Movie movie) {
        super(hallNumber, movie, 8, 12, 67);
    }
}
