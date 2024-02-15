package BankManagementSystemApp;

public class SavingsAccount extends BankAccount
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double interest = 0.05;
	private double maxWithLimit;
	
	public SavingsAccount(String memberName, String memberNID, double accountBalance,double maxWithLimit) 
	{
		super(memberName, memberNID, accountBalance,2000);
		this.maxWithLimit = maxWithLimit;
		super.setaccountNumber("11-"+super.getaccountNumber());
	}
	
	public double getnetbalance()
	{
		double in = super.getaccountBalance();
		in = in*interest;
		return super.getaccountBalance()+in;
	}
	@Override
	protected void withdraw(double depamount) throws InSufficientBalanceException, MaximumWithdrawLimitException
	{
		if(depamount>maxWithLimit)
		{
			throw new MaximumWithdrawLimitException(maxWithLimit);
		}
		else
		{
			super.withdraw(depamount);
		}
	}
	@Override
	protected void withdraw(double amount, String transactionType) throws InSufficientBalanceException, MaximumWithdrawLimitException
	{
		if(amount>maxWithLimit)
		{
			throw new MaximumWithdrawLimitException(maxWithLimit);
		}
		else 
		{
			super.withdraw(amount, transactionType);
		}
	}
	@Override
	public String toString()
	{
		return super.toString() + ", Withdraw Limit: "+this.maxWithLimit+"\n";
	}
	
	
 
	 
}