/*
 * This is the Car class.
 * It stores information about the car. This will be connected with Lease class with miles
 */
import java.util.Calendar;


public class Car 
{
	private String carMake;
	private String carModel;
	private int carYear;
	private double miles;
	
	public Car()
	{
		
	}
	
	public Car(String make, String model, int year, double mile)
	{
		this();
		carMake = make;
		carModel = model;
		carYear = year;
		miles = mile;
	}
	
	public String getCarMake()
	{
		return carMake;
	}
	
	public String getCarModel()
	{
		return carModel;
	}
	
	public int getCarYear()
	{
		return carYear;
	}
	
	public double getMiles()
	{
		return miles;
	}
	
	public void setCarMake(String make)
	{
		carMake = make;
	}
	
	public void setCarModel(String model)
	{
		carModel = model;
	}
	
	public boolean setCarYear(int year)
	{
		if (year > (Calendar.getInstance().get(Calendar.YEAR) + 2) && year < (Calendar.getInstance().get(Calendar.YEAR) - 2))
			return false;
		else 
			carYear = year;
		return true;
	}
	
	public boolean setMiles(double mile)
	{
		if (mile < 0)
			return false;
		else
			miles = mile;
		return true;
	}
	
	public String toString()
	{
		return "Make: " + getCarMake() + "\nModel: " + getCarModel() + "\nYear: " + getCarYear() + "\nMiles: " + getMiles();
	}
}

