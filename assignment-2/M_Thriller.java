//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

public class M_Thriller extends Movie {
    //min age is const
    public M_Thriller(String name, int movieLength) {
        super(name, movieLength, 16);
    }

    @Override
    public String toString() {
        return super.toString() + "Typer: Thriller";
    }
}