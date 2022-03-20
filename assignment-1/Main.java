//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //create an agency
        CarAgency agency = new CarAgency("Ofirs Agency");

        //create 10 cars
        Car car1 = new Car(2000, 0, 50000, 200000, "Honda", "Green", 123);
        Car car2 = new Car(2001, 1, 60000, 233000, "Volkswagen", "Red", 234);
        Car car3 = new Car(2002, 2, 70000, 133000, "Toyota", "Black", 345);
        Car car4 = new Car(2003, 3, 80000, 222000, "Mazda", "Yellow", 456);
        Car car5 = new Car(2004, 4, 90000, 250000, "Toyota", "Brown", 567);
        Car car6 = new Car(2005, 5, 100000, 50000, "Mazda", "Blue", 789);
        Car car7 = new Car(2006, 6, 110000, 0, "Hyundai", "Blue", 987);
        Car car8 = new Car(2008, 7, 120000, 123456, "Ford", "White", 654);
        Car car9 = new Car(2009, 8, 130000, 56423, "Mazda", "White", 321);
        Car car10 = new Car(2010, 9, 140000, 45623, "Renault", "Blue", 432);

        //add cars to agency
        agency.addCar(car1);
        agency.addCar(car2);
        agency.addCar(car3);
        agency.addCar(car4);
        agency.addCar(car5);
        agency.addCar(car6);
        agency.addCar(car7);
        agency.addCar(car8);
        agency.addCar(car9);
        agency.addCar(car10);

        Scanner input = new Scanner(System.in);

        //add agents
        System.out.println("How many agents would you like to add?");
        int agentSize = input.nextInt(); //how many agents to add

        while (agentSize<0) //size validation
        {
            System.out.println("Size should be a positive number. Please enter again.");
            System.out.println("How many agents would you like to add?");
            agentSize = input.nextInt();
        }

        for (int i=0;i<agentSize;i++)
        {
            System.out.println("What is the name of the agent?");
            String agentName = input.next(); //name input
            agency.addAgent(agentName); //add agent to agency
        }

        //run car searches
        agency.carSearch(100000,2003);
        agency.carSearch(200000,60000,2);
        agency.carSearch("Mazda",2002);

    }
}