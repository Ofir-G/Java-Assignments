package model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = null;
	
        do {
            try {
                System.out.println("Please enter your name");
                String nameS = scanner.nextLine();
                System.out.println("Please enter your ID");
                String idS = scanner.nextLine();
                student = new Student(idS, nameS);
            } catch (IllegalFirstAlphabetLetter e) { //name invalid
                System.out.println(e);
            } catch (IllegalDigits e) { //ID invalid
                System.out.println(e);
            }
        } while (student == null);

        student.calculateAvarage();

        //create courses
        Course course_1 = new Course("JAVA", 100);
        Course course_2 = new Course("data structures", 97);
        Course course_3 = new Course("C++", 93);
        Course course_4 = new Course("Networking", 95);

        //add courses to student
        student.addCourse(course_1);
        student.addCourse(course_2);
        student.addCourse(course_3);
        student.addCourse(course_4);

        Course course_5 = new Course("psychology", 0);

        try {
            student.findCourseAndPrint(course_5);
        } catch (NullPointerException e) { //course is not in arr
            System.out.println(e);
            System.out.println("Course " + course_5.getName() + " doesn't exist for student " + student.getNameS());
        } finally {
            System.out.println(course_5);
            scanner.close();
        }

    }
}
