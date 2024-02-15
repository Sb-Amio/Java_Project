package BankManagementSystemApp;

public class CurrentAccount extends BankAccount
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tradeLicenseNumber;

	public CurrentAccount(String memberName, String memberNID, double accountBalance,String tradeLicenseNumber) 
	{
		super(memberName, memberNID, accountBalance, 5000);
		super.setaccountNumber("22-"+super.getaccountNumber());;
		this.tradeLicenseNumber = tradeLicenseNumber;
	}
	@Override
	public void withdraw(double amount) throws InSufficientBalanceException, MaximumWithdrawLimitException
	{
		
		super.withdraw(amount);

	}
	public double getbalance()
	{
		return super.getaccountBalance();
	}
	public String toString()
	{
		return super.toString()+", Trade lisence No.: "+tradeLicenseNumber+"\n";
	}
	

}