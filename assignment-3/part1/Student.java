package model;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String id;
    private String nameS;
    private Course[] courselist = new Course[3];

    //full contractor
    public Student(String id, String nameS) throws IllegalFirstAlphabetLetter, IllegalDigits {
        setNameS(nameS);
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalDigits {


        for (int i = 0; i < id.length(); i++) {
            if (!(id.charAt(i) <= '9' && id.charAt(i) >= '0')) {

                throw new IllegalDigits(id);
            }
        }

        if (id.length() < 9) {

            throw new IllegalDigits(id);
        }

        this.id = id;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) throws IllegalFirstAlphabetLetter {

        char firstLetter = nameS.charAt(0);
        if (((firstLetter <= 'z') && (firstLetter >= 'a')) || ((firstLetter <= 'Z') && (firstLetter >= 'A'))) {
            this.nameS = nameS;
        } else {
            throw new IllegalFirstAlphabetLetter(nameS);
        }
    }

    public Course[] getCourselist() {
        return courselist;
    }

    public void setCourselist(Course[] courselist) {
        this.courselist = courselist;
    }

    public void addCourse(Course course) {
        int flag = 0;
        try {
            for (int i = 0; i <= courselist.length && flag == 0; i++) {

                if (courselist[i] == null) { //reached arr empty spot
                    flag = 1;
                    courselist[i] = course; //add course
                }
            }
        }
        // going out of bound
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e + "new arr was created. The course added succesfully");
            Course[] new_courselist = new Course[(courselist.length) * 2]; //create new arr
            int j = 0;
            for (j = 0; j < courselist.length; j++) { //copy old arr to new
                new_courselist[j] = courselist[j];
            }
            new_courselist[j] = course; //add new course
            setCourselist(new_courselist);
        }
    }

    public double calculateAvarage() {

        try {
            int count = 0;
            int sum = 0;

            for (int i = 0; i < courselist.length && courselist[i] != null; i++) {
                count++;
                sum += courselist[i].getFinalgrade(); //sum of grades
            }

            return sum / count;
        }

        //in case no courses (divide by 0)
        catch (ArithmeticException e) {

            System.out.println(e + ", no courses yet - returned average of 0");
            return 0;
        }
    }

    private Course findCourse(Course course) {
        for (int i = 0; i < courselist.length && courselist[i] != null; i++) {
            if (courselist[i].equals(course)) //found wanted course
            {
                return new Course(course);
            }
        }
        return null; //course not found
    }

    public void findCourseAndPrint(Course course) throws NullPointerException {
        Course foundCourse = findCourse(course); //find course
        foundCourse.toString(); //print details
    }

    @Override
    public String toString() {
        return "Student3 [id=" + id + ", nameS=" + nameS + ", courselist=" + Arrays.toString(courselist) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

}
