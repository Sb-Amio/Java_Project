package BankManagementSystemApp;

public class InSufficientBalanceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InSufficientBalanceException(String accNum) 
	{
		super(String.format(" Account number :"+accNum+" doesn't have enough balance"));
		
	}
}
