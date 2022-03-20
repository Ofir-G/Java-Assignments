//Employee can't be a student/retiree/soldier and gets regular price

public class M_Comedy extends Movie {
    //min age is const
    public M_Comedy(String name, int movieLength) {
        super(name, movieLength, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "Type: Comedy";
    }

}