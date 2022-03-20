//Employee can't be a student/retiree/soldier and gets regular price

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    protected String name;
    protected int ID;
    protected String email;
    protected int phone;
    protected LocalDate birthDate;

    //Constructor
    public Person(String name, int ID, String email, int phone, LocalDate birthDate) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //return person's age
    public int getAge() {
        LocalDate today = LocalDate.now(); //Today's date
        Period age = Period.between(this.birthDate, today);
        return age.getYears();
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", phone=" + phone + " age=" + getAge() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Person)) return false;
        Person person = (Person) o;
        return ID == person.ID;
    }

}
