//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;

public class C_Retiree extends Customer {
    //Constructor
    public C_Retiree(String name, int ID, String email, int phone, LocalDate birthDate) {
        super(name, ID, email, phone, birthDate);
    }

    @Override
    public int discount(int price) {
        if (getAge() >= 65) {
            return price / 3; //retiree gets third of the price
        }
        return price;
    }

    @Override
    public String toString() {
        return "Retiree: " + super.toString();
    }

}
