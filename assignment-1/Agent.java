
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Agent
{
    private String name;
    private int agentNumber;
    private double salary;
    private int salesNumber;

    //Full constructor
    public Agent(String name, int agentNumber, double salary, int salesNumber)
    {
        setName(name);
        setSalary(salary);
        setAgentNumber(agentNumber);
        setSalesNumber(salesNumber);
    }

    //Constructor
    public Agent(String name,int agentNumber)
    {
     this(name,agentNumber,0,0);
    }

    //Copy constructor
    public Agent(Agent other)
    {
        this(other.name, other.agentNumber,other.salary,other.salesNumber);
    }

    // name can change so it's public
    public void setName(String name)
    {
        Scanner input = new Scanner(System.in);
        while(!validateAlphabetString(name)) //validate input
        {
            System.out.println("Name entered is not valid. Name should contain alphabetic characters only. Please enter correct input");
            name = input.nextLine();
        }
        name = name.toLowerCase(Locale.ROOT); //save string with lower case
        this.name = name;
    }

    //setAgentNumber is private because agent number is not changeable.
    private void setAgentNumber(int agentNumber)
    {
        Scanner input = new Scanner(System.in);
        while(agentNumber<0) //validate input
        {
            System.out.println("Invalid input. Agent number cannot be negative numbers. Please enter correct input");
            agentNumber = input.nextInt();
        }
        this.agentNumber = agentNumber;
    }

    public void setSalary(double salary)
    {
        Scanner input = new Scanner(System.in);
        while(salary<0) //validate input
        {
            System.out.println("Invalid input. Salary number cannot be negative numbers. Please enter correct input");
            salary = input.nextInt();
        }
        this.salary = salary;
    }

    //setSalesNumber is private because there is a addSell method that adds to salesNumber accordingly.
    private void setSalesNumber(int salesNumber)
    {
        Scanner input = new Scanner(System.in);
        while(salesNumber<0) //validate input
        {
            System.out.println("Invalid input. Salary number cannot be negative numbers. Please enter correct input");
            salesNumber = input.nextInt();
        }
        this.salesNumber = salesNumber;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public int getAgentNumber() {
        return agentNumber;
    }

    public boolean searchCar(ArrayList <Car> carsList, int maxKilometrage, int maxPrice, int maxHand)
    {
        int flag=0;
        for (Car car : carsList)
        {
            // check if demands are met
            if (car.getKilometrage() <= maxKilometrage && car.getPrice() <= maxPrice && car.getHand() <= maxHand)
            {
                System.out.println(car); //print car details
                flag = 1;
            }
        }

        if (flag==0) //no cars were found
        {
            System.out.println("No cars were found with entered conditions.");
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean searchCar(ArrayList <Car> carsList, int maxPrice, int minYear)
    {
        int flag=0;
        for (Car car : carsList)
        {
            // check if demands are met
            if (car.getYear() >= minYear && car.getPrice() <= maxPrice)
            {
                System.out.println(car); //print car details
                flag = 1;
            }
        }
        if (flag==0) //no cars were found
        {
            System.out.println("No cars were found with entered conditions.");
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean searchCar(ArrayList <Car> carsList, String manufacturer, int minYear)
    {
        int flag=0;
        for (Car car : carsList)
        {
            // check if demands are met
            if (car.getYear() >= minYear && car.getManufacturer().equals(manufacturer))
            {
                System.out.println(car); //print car details
                flag = 1;
            }
        }
        if (flag==0) //no cars were found
        {
            System.out.println("No cars were found with entered conditions.");
            return false;
        }
        else
        {
            return true;
        }
    }

    // adds 1 sale to agent
    public void addSale()
    {
        this.salesNumber += 1;
    }

    // adds salary amount to agent
    public void addSalary(double amount)
    {
        this.salary += amount;
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

    //agents are equal if they have the same number
    public boolean equals(Agent other)
    {
        return this.agentNumber == other.agentNumber;
    }

    public String toString()
    {
        return "Agent number: " + agentNumber + "\nName: " + name + "\nSales: " + salesNumber;
    }
}
