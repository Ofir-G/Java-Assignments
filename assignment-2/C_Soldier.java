//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;

public class C_Soldier extends Customer {
    private LocalDate dischargedDate;

    //Constructor
    public C_Soldier(String name, int ID, String email, int phone, LocalDate birthDate, LocalDate dischargedDate) {
        super(name, ID, email, phone, birthDate);
        this.dischargedDate = dischargedDate;
    }

    public LocalDate getDischargedDate() {
        return dischargedDate;
    }

    public void setDischargedDate(LocalDate dischargedDate) {
        this.dischargedDate = dischargedDate;
    }

    @Override
    public int discount(int price) {
        LocalDate today = LocalDate.now();
        if (this.dischargedDate.isAfter(today)) {
            return 0; //soldier gets full discount
        }
        return price;
    }

    @Override
    public String toString() {
        return "Soldier: " + super.toString();
    }
}
