//Employee can't be a student/retiree/soldier and gets regular price

public class M_Horror extends Movie {
    //min age is const
    public M_Horror(String name, int movieLength) {
        super(name, movieLength, 18);
    }

    @Override
    public String toString() {
        return super.toString() + "Type: Horror";
    }
}