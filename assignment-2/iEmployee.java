//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

public interface iEmployee {

    public int sellPop(int popSize, Customer customer);

    public Ticket sellTicket(Customer customer, Movie movie, CinemaHall[] cinemaHallList);

    public int monthSalary();

}
