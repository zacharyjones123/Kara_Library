import java.util.ArrayList;

public class Vehicle
{

private String type;
private String make;
private int year;
public double finalPrice;
private double price;
private char option;
private  final int FEE=2500;

public Vehicle(String carType, String carMake, int carYear, double carPrice, char carOption, double carFinal)
{
if (!carType.equals("Car") && !carType.equals("car") && !carType.equals("Truck") && !carType.equals("truck"))
{ 
System.out.println("Error: Invalid car type entered");
}
else
{
type=carType;
}

make=carMake;
year=carYear;
if(carPrice>=1)
{
price=carPrice;
}
else 
{
System.out.println("Error: Invalid Price Entered");
}
if(carOption !='Y' && carOption !='y' && carOption!='n' && carOption!='N')
{
System.out.println("Invalid option entered!");
}
else
{
option=carOption;
}


}

public Vehicle()
{
type="";
make="";
year=0;
price=0.0;
option='\0';
finalPrice=0.0;

}


public void setType(String carType)
{
type=carType;
}

public void setMake(String carMake)
{
make=carMake;
}

public void setYear(int carYear)
{
year=carYear;
}

public void setPrice(double carPrice)
{
price=carPrice;
}

public void setOption(char carOption)
{
option=carOption;
}


public String getType()
{
return type;
}

public String getMake()
{
return make;
}

public int getYear()
{
return year;
}

public char getOption()
{
return option;
}

public double getPrice()
{

return price;
}

public double getFinalPrice(double price)
{
double finalPrice=0.0;
if (option=='Y'||option=='y')
{
finalPrice=FEE+price;
}
else 
{
finalPrice=price;
}
return finalPrice;

}

public static double calcAverage(ArrayList<Vehicle> vehicle, double totalPrice) 
   {
		return totalPrice/vehicle.size();
	}


}
