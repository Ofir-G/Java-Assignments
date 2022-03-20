//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525
//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;

public class C_Student extends Customer {
    private LocalDate graduationDate;
    private String institution;

    //Constructor
    public C_Student(String name, int ID, String email, int phone, LocalDate birthDate, LocalDate graduationDate, String institution) {
        super(name, ID, email, phone, birthDate);
        this.graduationDate = graduationDate;
        this.institution = institution;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public int discount(int price) {
        LocalDate today = LocalDate.now();
        if (this.graduationDate.isAfter(today)) {
            return (price / 2); //student gets half price
        }
        return price;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
