import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LeaseCalculator 
{
	public static void main(String[] args) 
	{
		String[] customerTypeMenu = { "New Customer", "Current Customer", "Exit"};
		String choice = mainMenu(customerTypeMenu);
		while(!choice.equals(customerTypeMenu[2]))
		{
			if (choice.equals(customerTypeMenu[0]))
			{
				Customer customer = new Customer();
				JOptionPane.showMessageDialog(null, "Great, let's some information about your lease\nSo we can come up with a budget for your miles");
				customer.setFirstName(JOptionPane.showInputDialog("What is your First Name?"));
				customer.setLastName(JOptionPane.showInputDialog("What is your Last Name?"));
				boolean validEmail = false;
				if (!customer.setEmail(JOptionPane.showInputDialog("What is your Email Address?")))
					do
					{
						validEmail = customer.setEmail(JOptionPane.showInputDialog("Sorry, that was an invalid email address.\nPlease enter a valid email address:"));
					} while(!validEmail);
				customer.addLease();
				customer.getLease().addCarToLease(JOptionPane.showInputDialog("What is the make your car?"),
							JOptionPane.showInputDialog("What is the model of the car"),
							Integer.parseInt(JOptionPane.showInputDialog("What is the year of your car?")),
							Double.parseDouble(JOptionPane.showInputDialog("What is the number of miles on the car?")));
				customer.getLease().setLengthOfLease(Integer.parseInt(JOptionPane.showInputDialog("What is the length of your lease in months?")));
				customer.getLease().setMaximumMiles(Double.parseDouble(JOptionPane.showInputDialog("What is the limit of the number of miles you can drive per year?")));
				customer.getLease().setCostPerMile(Double.parseDouble(JOptionPane.showInputDialog("What is the cost of each mile gone of the limit?")));
				customer.getLease().setCurrentMonthOfLease(Integer.parseInt(JOptionPane.showInputDialog("How many months out of " + customer.getLease().getLengthOfLease() + " months have you had your lease?")));
				JOptionPane.showMessageDialog(null, "Now let's calculate a budget for you and some future statistics to help you out.");
				JOptionPane.showMessageDialog(null, customer.toString() + "\n" + customer.getLease().getLeasedCar().toString() + "\n" + customer.getLease().toString() +
						"\nCurrent Rate of miles: " + currentRateOfMiles(customer) + "\nTotal Estimated Miles To Be Driven Per Year: " + totalEstimatedMilesPerYear(customer) + 
						"\nForecasted Charges: " + forecastedCharges(customer, totalEstimatedMilesPerYear(customer)) + "\nSuggest Budget: " + suggestedBudget(customer));
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Sorry, current customer system is coming soon.");
			}
		}
		choice = mainMenu(customerTypeMenu);
	}
	
	public static String mainMenu(String[] customerTypeMenu)
	{
		Frame frame = new JFrame("Lease Calculator");
		String choice = (String) JOptionPane.showInputDialog(frame, 
				"Hello,\nAre you a New or Current Customer?",
				"Main Menu", JOptionPane.QUESTION_MESSAGE, null, customerTypeMenu, customerTypeMenu[0]);
		return choice;
	}
	
	public static double currentRateOfMiles(Customer customer)
	{
		if (customer.getLease().getLeasedCar().getMiles() == 0 && customer.getLease().getCurrentMonthOfLease() == 0)
			return 0;
		else
			return customer.getLease().getLeasedCar().getMiles() / (customer.getLease().getCurrentMonthOfLease());
	}
	
	public static double totalEstimatedMilesPerYear(Customer customer)
	{
		if (customer.getLease().getLeasedCar().getMiles() == 0 && customer.getLease().getCurrentMonthOfLease() == 0)
			return 0;
		else
		{
			int years = customer.getLease().getLengthOfLease() / 12;
			return ((currentRateOfMiles(customer) * (customer.getLease().getLengthOfLease() - customer.getLease().getCurrentMonthOfLease())) + 
					customer.getLease().getLeasedCar().getMiles()) / years;
		}
	}
	
	public static double forecastedCharges(Customer customer, double totalEstimatedMilesPerYear)
	{
		if ((totalEstimatedMilesPerYear) > customer.getLease().getMaximumMiles())
		{
			return (totalEstimatedMilesPerYear - customer.getLease().getMaximumMiles()) * customer.getLease().getCostPerMile();
		}
		else
			return 0;
	}
	
	public static double suggestedBudget(Customer customer)
	{
		double leftoverMiles = (customer.getLease().getMaximumMiles() * (customer.getLease().getLengthOfLease() / 12)) - customer.getLease().getLeasedCar().getMiles();
		return leftoverMiles / (customer.getLease().getLengthOfLease() - customer.getLease().getCurrentMonthOfLease());		
	}

}
