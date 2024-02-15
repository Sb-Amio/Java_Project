package BankManagementSystemApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public abstract class BankAccount implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberName;
	private String memberNID;
	private String accountNumber;
	private double accountBalance;
	private double minimumBalance;
	ArrayList<Transaction> transactions = new ArrayList<>();
	
	//constructor
	public BankAccount(String memberName, String memberNID, double accountBalance, double minimumBalance)
	{
		super();
		Random rand = new Random();
		accountNumber = ""+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10)+ rand.nextInt(10);
		
		this.memberName = memberName;
		this.memberNID = memberNID;
		this.accountBalance = accountBalance;
		this.minimumBalance = minimumBalance;
	}
	public String getName()
	{
		return memberName;
	}
	public double getMinimumBalance()
	{
		return minimumBalance;
	}
	public void addTransaction(double amount, String type)
	{
		Transaction t = new Transaction(amount, type);
		transactions.add(t);
	}
	public ArrayList<Transaction> getTransactions()
	{
		return transactions;
	}
	protected void deposit(double depAmount, String transactionType)
	{
		accountBalance += depAmount;
		addTransaction(depAmount,transactionType);
	}
	public void deposit(double depAmount)
	{
		deposit(depAmount,"Deposit");
	}
	protected void withdraw(double withAmount, String transactionType)throws InSufficientBalanceException, MaximumWithdrawLimitException
	{
		if(withAmount > (accountBalance-minimumBalance))
		{
			throw new InSufficientBalanceException(getaccountNumber());
		}
		else
		{
			accountBalance-=withAmount;
		}
		addTransaction(withAmount,transactionType);
		
	}
	protected void withdraw(double withAmount) throws InSufficientBalanceException, MaximumWithdrawLimitException
	{
		withdraw(withAmount,"Withdraw");
	}
	
	public String getaccountNumber()
	{
		return accountNumber;
	}
	public double getaccountBalance()
	{
		return accountBalance;
	}
	public void setaccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public String getmemberNID()
	{
		return memberNID;
	}
	
	
	@Override
	public String toString()
	{
		return " Account Type: "+getClass().getSimpleName()+String.format(", Name: "
				+memberName+", NID: "+memberNID+", Account No.: "+accountNumber+", Balance: "
				+accountBalance);
	}
	

}
