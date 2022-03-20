//Nicole Gam Ze Letova, 315310235
//Ofir Gerbi, 203519525

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class CarAgency
{
    private String name;
    private ArrayList<Car> carsList;
    private ArrayList<Agent> agentList;

    //Constructor
    public CarAgency(String name)
    {
        this.name = name;
        carsList = new ArrayList<>();
        agentList = new ArrayList<>();
    }

    public void setName(String name)
    {
        Scanner input = new Scanner(System.in);
        while(!validateAlphabetString(name)) //name validation
        {
            System.out.println("Name entered is not valid. Name should contain alphabetic characters only. Please enter correct input.");
            name = input.nextLine();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Agent> getAgentList() {
        return agentList;
    }

    public ArrayList<Car> getCarsList() {
        return carsList;
    }

    public void addCar(Car car)
    {
        if (findCarIndex((car.getCarNumber())) != -1) // if car number is already on the list
        {
            System.out.println("Car is already in the list.");
        }
        else //car is not on the list
        {
            carsList.add(car);
        }
    }

    public void carSell(int carNumber, int agentNumber)
    {
        int carIndex = findCarIndex(carNumber); //find car index on car list
        int agentIndex = findAgentIndex(agentNumber); //find agent index on agent list

        if (carIndex!=-1 && agentIndex!=-1) //if car & agent were found
        {
            agentList.get(agentIndex).addSale(); //add to agent 1 sale
            double carPricePercentage = (3 * carsList.get(carIndex).getPrice()) / 100.00; //save percentage amount from sale price
            agentList.get(agentIndex).addSalary(carPricePercentage); //add amount to agent salary
            carsList.remove(carIndex); // remove the car from the list
            System.out.println("Car number " + carNumber + " was removed from the list. agent number " + agentNumber + " was updated accordingly.");
        }
        else if (carIndex==-1 && agentIndex==-1) //if both were not found
        {
            System.out.println("Car number and agent number are not valid and/or not in the list.");
        }
        else if (carIndex==-1) //if car was not found
        {
            System.out.println("Car number is not valid and/or not in the list.");
        }
        else if (agentIndex==-1) //if agent was not found
        {
            System.out.println("Agent number is not valid and/or not in the list.");
        }
    }

    public void addAgent(String agentName)
    {
        Scanner input = new Scanner(System.in);
        while(!validateAlphabetString(agentName)) //name validation
        {
            System.out.println("Name entered is not valid. Name should contain alphabetic characters only. Please try again.");
            agentName = input.nextLine();
        }
        int randomAgentNumber;
        do // generate random number scale 1000-9999 for agent number
        {
            Random randomNum = new Random();
            randomAgentNumber = 1000+randomNum.nextInt(9000);
        }
        while (findAgentIndex(randomAgentNumber) != -1); //if the number exists already on the list

        agentList.add(new Agent(agentName,randomAgentNumber)); //add new agent to list
        System.out.println("Agent \"" + agentName + "\" Number " + randomAgentNumber + " was added to the agency \"" + this.name +"\".");
    }

    //remove agent from the list
    public void removeAgent(int agentNumber)
    {
        int agentIndex = findAgentIndex(agentNumber); //find agent index on the list
        if (agentIndex != -1) //agent was found
        {
            agentList.remove(agentIndex);
            System.out.println("Agent number "+ agentNumber + " was removed from the list.");
        }
        else //agent was not found
        {
            System.out.println("No agent was found with number entered.");
        }
    }

    public void carSearch(int maxKilometrage, int maxPrice,int maxHand)
    {
        if(!negativeNumValidation(maxPrice) || !negativeNumValidation(maxHand) || !negativeNumValidation(maxKilometrage)) //if input are not valid
        {
            System.out.println("Input not valid. Numbers can't be negative.");
            return;
        }
        int agentIndex = findLowestSalaryAgent(); //find agent with lowest salary
        if(agentIndex == -1) //no agents on the list
        {
            return;
        }
        System.out.println("\nBegins search...");
        if (!agentList.get(agentIndex).searchCar(carsList, maxKilometrage,maxPrice,maxHand)) //if no cars were found with given demands
        {
            return;
        }
        System.out.println("\nEnd results.");
        System.out.println("Would you like to purchase a car? Please enter Yes/No");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine(); //answer input
        answer=answer.toLowerCase(Locale.ROOT); //change string to lower case
        if (answer.equals("yes")) //wants to buy a car
        {
            System.out.println("Enter car number you would like to purchase.");
            int wantedCarNumber = input.nextInt(); //input car number
            carSell(wantedCarNumber,agentList.get(agentIndex).getAgentNumber()); // send to car sell method
        }
        else if (answer.equals("no")) //doesn't want to buy a car
        {
            System.out.println("Have a good day.");
        }
        else //input is not vaild
        {
            System.out.println("Invalid input entered. Yes/No only. Please restart the search and try again.");
        }
    }

    public void carSearch(int maxPrice, int minYear)
    {
        if(!negativeNumValidation(maxPrice) || !negativeNumValidation(minYear)) //if input are not valid
        {
            System.out.println("Input not valid. Numbers can't be negative.");
            return;
        }
        int agentIndex = findLowestSalaryAgent(); //find agent with lowest salary
        if(agentIndex == -1) //no agents on the list
        {
            return;
        }
        System.out.println("\nBegins search...");
        if (!agentList.get(agentIndex).searchCar(carsList, maxPrice, minYear)) //if no cars were found with given demands
        {
            return;
        }
        System.out.println("\nEnd results.");
        System.out.println("Would you like to purchase a car? Please enter Yes/No");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine(); //answer input
        answer=answer.toLowerCase(Locale.ROOT); //change string to lower case
        if (answer.equals("yes")) //wants to buy a car
        {
            System.out.println("Enter car number you would like to purchase.");
            int wantedCarNumber = input.nextInt();
            carSell(wantedCarNumber,agentList.get(agentIndex).getAgentNumber());
        }
        else if (answer.equals("no")) //doesn't want to buy a car
        {
            System.out.println("Have a good day.");
        }
        else //input is not vaild
        {
            System.out.println("Invalid input entered. Yes/No only. Please restart the search and try again.");
        }
    }

    public void carSearch(String manufacturer, int minYear)
    {
        if(!validateAlphabetString(manufacturer) || !negativeNumValidation(minYear)) //if input are not valid
        {
            System.out.println("Input not valid. Manufacturer should contain alphabetic characters only, Year can't be negative.");
            return;
        }
        manufacturer = manufacturer.toLowerCase(Locale.ROOT); //change string to lower case
        int agentIndex = findLowestSalaryAgent(); //find agent with lowest salary
        if(agentIndex == -1) //no agents on the list
        {
            return;
        }
        System.out.println("\nBegins search...");
        if (!agentList.get(agentIndex).searchCar(carsList, manufacturer, minYear)) //if no cars were found with given demands
        {
            return;
        }
        System.out.println("\nEnd results.");
        System.out.println("Would you like to purchase a car? Please enter Yes/No");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine(); //answer input
        answer=answer.toLowerCase(Locale.ROOT); //change string to lower case
        if (answer.equals("yes")) //wants to buy a car
        {
            System.out.println("Enter car number you would like to purchase.");
            int wantedCarNumber = input.nextInt();
            carSell(wantedCarNumber,agentList.get(agentIndex).getAgentNumber());
        }
        else if (answer.equals("no")) //doesn't want to buy a car
        {
            System.out.println("Have a good day.");
        }
        else //input is not vaild
        {
            System.out.println("Invalid input entered. Yes/No only. Please restart the search and try again.");
        }
    }

    //method to find lowest salary agent index on the list
    private int findLowestSalaryAgent()
    {
        if(agentList.isEmpty()) //list is empty
        {
            System.out.println("No agents on the list. Add agents and try again.");
            return -1;
        }

        int minSalaryIndex = 0;
        double minSalary = agentList.get(0).getSalary();
        for(int i=0;i<agentList.size();i++)
        {
            if (agentList.get(i).getSalary() < minSalary)
            {
                minSalary = agentList.get(i).getSalary(); //save new minimum salary
                minSalaryIndex = i; //save new lowest salary index
            }
        }
        return minSalaryIndex;
    }

    //method to find car index on the list
    private int findCarIndex(int carNumber)
    {
        for(int i=0;i<carsList.size();i++)
        {
            if(carsList.get(i).getCarNumber() == carNumber)
            {
                return i;
            }
        }
        return -1;
    }

    //method to find agent index on the list
    private int findAgentIndex(int agentNumber)
    {
        for(int i=0;i<agentList.size();i++)
        {
            if(agentList.get(i).getAgentNumber() == agentNumber)
            {
                return i;
            }
        }
        return -1;
    }

    //method to validate int negative numbers
    private boolean negativeNumValidation(int num)
    {
        return num >= 0;
    }

    //method to validate string to alphabet
    private boolean validateAlphabetString(String string)
    {
        if (string == null)
        {
            return false;
        }
        for (int i = 0; i < string.length(); i++)
        {
            char c = string.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z'))
            {
                return false;
            }
        }
        return true;
    }

    //agencies are equal if they have the same name
    public boolean equals(CarAgency other)
    {
        return other.getName().equals(this.name);
    }

    public String toString()
    {
        return "Agency name: " + this.name + "\nNumber of cars on the list: " + this.carsList.size() + "\nNumber of agents on the list: " + this.agentList.size();
    }
}
