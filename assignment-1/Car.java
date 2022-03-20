import java.util.Locale;
import java.util.Scanner;

public class Car
{
    private int year;
    private int hand;
    private int price;
    private int kilometrage;
    private String manufacturer;
    private String color;
    private int speed;
    private int carNumber;

    //Full constructor
    public Car(int year, int hand, int price, int kilometrage, String manufacturer, String color, int carNumber)
    {
        setYear(year);
        setCarNumber(carNumber);
        setColor(color);
        setHand(hand);
        setManufacturer(manufacturer);
        setPrice(price);
        setKilometrage(kilometrage);
        this.speed=0;
    }

    //Copy constructor
    public Car(Car other)
    {
        this(other.year, other.hand, other.price,other.kilometrage,other.manufacturer,other.color,other.carNumber);
    }

    //setHand is private because there is a Sell method that adds 1 hand.
    private void setHand(int hand)
    {
        Scanner input = new Scanner(System.in);
        while(hand<0) //validate input
        {
            System.out.println("Invalid input. Hand cannot be negative numbers. Please enter correct input");
            hand = input.nextInt();
        }
        this.hand=hand;
    }

    //setColor is private because car color is not changeable.
    private void setColor(String color)
    {
        Scanner input = new Scanner(System.in);
        while(!validateAlphabetString(color)) //validate input
        {
            System.out.println("Color entered is not valid. Color should contain alphabetic characters only. Please enter correct input");
            color = input.nextLine();
        }
        color = color.toLowerCase(Locale.ROOT); //save string as lower case
        this.color = color;
    }

    //setManufacturer is private because car manufacturer is not changeable.
    private void setManufacturer(String manufacturer)
    {
        Scanner input = new Scanner(System.in);
        while(!validateAlphabetString(manufacturer)) //validate input
        {
            System.out.println("Manufacturer entered is not valid. Manufacturer should contain alphabetic characters only. Please enter correct input");
            manufacturer = input.nextLine();
        }
        manufacturer = manufacturer.toLowerCase(Locale.ROOT); //save string with lower case
        this.manufacturer = manufacturer;
    }

    //setCarNumber is private because car number is not changeable.
    private void setCarNumber(int carNumber)
    {
        Scanner input = new Scanner(System.in);
        while(carNumber<0 || carNumber > 100000000) //validate input
        {
            System.out.println("Invalid input. Car number cannot be negative numbers. Please enter correct input");
            carNumber = input.nextInt();
        }
        this.carNumber = carNumber;
    }

    //setYear is private because car year is not changeable.
    private void setYear(int year)
    {
        Scanner input = new Scanner(System.in);
        while(year<0 || year > 2021) //validate input
        {
            System.out.println("Invalid input. Year should be between 1 to 2021. Please enter correct input");
            year = input.nextInt();
        }
        this.year=year;
    }

    public void setPrice(int price)
    {
        Scanner input = new Scanner(System.in);
        while(price<0) //validate input
        {
            System.out.println("Invalid input. Price cannot be negative numbers. Please enter correct input");
            price = input.nextInt();
        }
        this.price=price;
    }

    public void setKilometrage(int kilometrage)
    {
        Scanner input = new Scanner(System.in);
        while(kilometrage<0) //validate input
        {
            System.out.println("Invalid input. Kilometrage cannot be negative numbers. Please enter correct input");
            kilometrage = input.nextInt();
        }
        this.kilometrage=kilometrage;
    }

    public int getHand() {
        return hand;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCarNumber() {
        return carNumber;
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

    public void increaseSpeed()
    {
        if (speed >=180) //if car is at speed limit
        {
            System.out.println("Car is at max speed - 180 km/h.");
        }
        else
        {
            this.speed += 1;
            System.out.println("Current speed: " + this.speed + " km/h.");
        }
    }

    public void decreaseSpeed()
    {
        if (speed == 0) //if car is at minimum speed
        {
            System.out.println("Car is at minimum speed - 0 km/h.");
        }
        else
        {
            this.speed -= 1;
            System.out.println("Current speed: " + this.speed + " km/h.");
        }
    }

    public void stop()
    {
        if (speed ==0)
        {
            System.out.println("Car is at minimum speed - 0 km/h.");
        }
        else
        {
            this.speed = 0;
            System.out.println("Car stopped.");
        }
    }

    public void sell()
    {
        this.hand += 1;
    }

    //cars are equal if they have the same number
    public boolean equals(Car other)
    {
        return this.carNumber == other.carNumber;
    }

    public String toString ()
    {
        return "\nCar number: " + carNumber + "\nCar year: " + year + "\nPrice: " + price + "\nKilometrage: " + kilometrage +
            "\nManufacturer: " + manufacturer + "\nColor: " + color + "\nHand: " + hand;
    }

}
