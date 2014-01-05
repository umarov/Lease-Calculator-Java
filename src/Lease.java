
public class Lease 
{
	private double maximumMiles;
	private double costPerMile;
	private int lengthOfLease;
	private int currentMonthOfLease;
	private Car[] cars = new Car[5];
	private int numberOfCars = 0;
	
	public Lease()
	{
		
	}
	
	public Car addCarToLease(String make, String model, int year, double mile)
	{
		cars[numberOfCars++] = new Car(make, model, year, mile);
		return cars[numberOfCars];
	}
	
	public double getMaximumMiles()
	{
		return maximumMiles;
	}
	
	public double getCostPerMile()
	{
		return costPerMile;
	}
	
	public int getLengthOfLease()
	{
		return lengthOfLease;
	}
	
	public int getCurrentMonthOfLease()
	{
		return currentMonthOfLease;
	}
	
	public boolean setMaximumMiles(double max)
	{
		if (max < 0)
			return false;
		else 
			maximumMiles = max;
		return true;
	}
	
	public boolean setCostPerMile(double cost)
	{
		if (cost < 0)
			return false;
		else 
			costPerMile = cost;
		return true;
	}
	
	public boolean setLengthOfLease(int length)
	{
		if (length < 0)
			return false;
		else
			lengthOfLease = length;
		return true;
	}
	
	public boolean setCurrentMonthOfLease(int month)
	{
		if (month < 0)
			return false;
		else
			currentMonthOfLease = month;
		return true;
	}
	
	public String toString()
	{
		return "Limit of Miles to be driven per year :" + getMaximumMiles() + "\nCost of miles driver over the limit of " + getMaximumMiles() + ": $" + 
				getCostPerMile() + " per mile\n" + "Length of the Lease: " + getLengthOfLease() + " months\n" + "Current number of months of the lease: " + getCurrentMonthOfLease() + " out of " + getLengthOfLease(); 
	}
	
	
}
