
public class Customer 
{
	private String firstName;
	private String lastName;
	private String email;
	Lease lease;
	
	public Customer()
	{}
	
	public Lease addLease()
	{
		lease = new Lease();
		return lease;
	}
	
	public Lease getLease()
	{
		return lease;
	}
	
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	
	public boolean setEmail(String mail)
	{
		int count = 0;
		for (int i = 0; i < mail.length(); i++)
		{
			if (mail.charAt(i) == '@')
				count++;
		}
		if (count > 1)
			return false;
		return true;	
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String toString()
	{
		return "Name: " + getFirstName() + " " + getLastName() + "\nEmail: " + getEmail();
	}
}
