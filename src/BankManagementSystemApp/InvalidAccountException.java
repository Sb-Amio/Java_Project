package BankManagementSystemApp;

public class InvalidAccountException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccountException(String accNum) 
	{
		super(String.format(" "+accNum+" is not a valid account"));
	}
}
