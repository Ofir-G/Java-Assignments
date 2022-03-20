package model;

public class Course {

    private String nameC;
    private double finalgrade;

    //contractor
    public Course(String nameC, double finalgrade) {
        this.nameC = nameC;
        this.finalgrade = finalgrade;
    }

    //copy contractor
    public Course(Course other) {
        this.nameC = other.nameC;
        this.finalgrade = other.finalgrade;
    }

    //gets + sets
    public String getName() {
        return nameC;
    }

    public void setName(String nameC) {
        this.nameC = nameC;
    }

    public double getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(double finalgrade) {
        this.finalgrade = finalgrade;
    }

    @Override
    public String toString() {
        return "Course [name=" + nameC + ", finalgrade=" + finalgrade + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Course) {
            Course course = (Course) other;
            if (course.nameC == this.nameC) {
                return true;
            }
        }
        return false;
    }
}
