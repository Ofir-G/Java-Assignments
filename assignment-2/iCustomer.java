//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

public interface iCustomer {
    public Movie chooseMovie(Movie[] movieList);

    public int popcornSize();

    public int discount(int price);

}
