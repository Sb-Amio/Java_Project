package BankManagementSystemApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankname;
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public Bank(String name)
	{
		this.bankname = name;
	}
	
	public String getbankname()
	{
		return bankname;
	}
	
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}


	//savings account create
	private void addAccount(BankAccount acc)
	{
		accounts.add(acc);
	}
	
	
	public String addaccount(String membername,String memberNID, double accountbalance, double maxwithdrawlimit)
	{
		SavingsAccount sa = new SavingsAccount(membername,memberNID ,accountbalance, maxwithdrawlimit);
		addAccount(sa);
		return sa.getaccountNumber();
		//System.out.println("Your Account Number is: "+sa.getaccountNumber());
	}
	
	
	//current account create
	public String addaccount(String name,String memberNID, double balance, String trade)
	{
		CurrentAccount ca = new CurrentAccount(name,memberNID,balance,trade);
		addAccount(ca);
		return ca.getaccountNumber();
		//System.out.println("Your Account Number is: "+ca.getaccountNumber());
	}
	
	//account finder -> for employee
	public BankAccount findaccount(String accnum)throws InvalidAccountException
	{
		int flag=0;
		for(int i=0;i<accounts.size();i++)
		{
			BankAccount b = accounts.get(i);
			if(b.getaccountNumber().equals(accnum))
			{
				flag=1;
				return b;
			}
		}
		if(flag==0)
		{
			throw new InvalidAccountException(accnum);
		}
		return null;
	}
	
	//deposit block -> for employee and customer
	public void deposit(String accnum, double amount) throws InvalidAccountException
	{
		BankAccount b = findaccount(accnum);
		b.deposit(amount);
	}
	
	//withdraw block -> for employee and customer
	public void withdraw(String accnum, double amount) throws InSufficientBalanceException, MaximumWithdrawLimitException, InvalidAccountException
	{
		BankAccount b = findaccount(accnum);
		b.withdraw(amount);
	}
	//specific account information finder -> for employee
	public void display(String accnum) throws InvalidAccountException
	{
		BankAccount b = findaccount(accnum);
		System.out.println(b);
	}
	//all accounts display -> for employee
	public void display()
	{
		for(int i=0;i<accounts.size();i++)
		{
			BankAccount b = accounts.get(i);
			if(b==null)
			{
				break;
			}
			else 
			{
				System.out.println(b);
				//return accounts;
				
			}
		}
		//return accounts;
	}
	//display all
	/*public ArrayList<BankAccount> display()
	{
		ArrayList<BankAccount> bankaccount = new ArrayList<>();
		for(int i=0;i<accounts.size();i++)
		{
			BankAccount b = accounts.get(i);
			if(b==null)
			{
				break;
					
			}
			else
			{
				bankaccount.add(b);
			}
		}
		return bankaccount;
	}*/

	//money transfer -> employee and customer
	public void transfer(String fromAccNum, String toAccNum, double amount) throws InvalidAccountException, InSufficientBalanceException, MaximumWithdrawLimitException
	{
		BankAccount a = findaccount(fromAccNum);
		BankAccount b = findaccount(toAccNum);
		if(a==null || b==null)
		{
			throw new InvalidAccountException(fromAccNum);
		}
		else
		{
			a.withdraw(amount, "Transferred to "+toAccNum);
			b.deposit(amount, "Received from "+fromAccNum);
		}
		
	}
	
	//get balance -> for employee
	public double getbalance(String accnum) throws InvalidAccountException
	{
		BankAccount b = findaccount(accnum);
		
		if(b instanceof CurrentAccount) 
		{
			CurrentAccount c = (CurrentAccount)b;
			return c.getbalance();
		}
		else 
		{
			SavingsAccount s = (SavingsAccount)b;
			return s.getnetbalance();
		}
		
	}
	
	
	//similar type of accounts viewer -> for employee
	public ArrayList<BankAccount> getAccounts(String type)
	{
		 ArrayList<BankAccount> bankaccount = new ArrayList<>();
		for(int i=0;i<accounts.size();i++)
		{
			BankAccount b = accounts.get(i);
			if(b.getClass().getSimpleName().equals(type))
			{
				bankaccount.add(b);
			}
		}
		return bankaccount;
	}
	//transaction information  -> for employee
	public ArrayList<Transaction> getAccTransaction (String accountNum) throws InvalidAccountException
	{
		BankAccount b = findaccount(accountNum);
		return b.getTransactions();
	}
	
	//same nid number accounts viewer -> for customer
	public ArrayList<BankAccount> findAccounts(String memberNID)
	{
		ArrayList<BankAccount> matching_acc = new ArrayList<>();
		for(int i=0;i<accounts.size();i++)
		{
			BankAccount b = accounts.get(i);
			if(b.getmemberNID().equals(memberNID))
			{
				matching_acc.add(b);
			}
		}
		return matching_acc;
	}
	//account founder -> for customer
	public BankAccount findAccount(String memberNID, String accountNumber)throws InvalidAccountException 
	{
		int flag=0;
		ArrayList<BankAccount> matching_acc = findAccounts(memberNID);
		for(BankAccount ba: matching_acc) 
		{
			if(ba.getaccountNumber().equals(accountNumber)) 
			{
				flag=1;
				return ba;
			}
		}
		if(flag==0)
		{
			throw new InvalidAccountException(accountNumber);
		}
		return null;
	}
	
	//transaction information  -> for customer
	public ArrayList<Transaction> getAccTransactiions(String memberNID, String accountNumber) throws InvalidAccountException
	{
		BankAccount b = findAccount(memberNID, accountNumber);
		if(b==null)
		{
			System.out.println("Account not found");
		}		
		return b.getTransactions();
	}
	
	public boolean password(String pass)
	{
		if(pass.equals("0000"))
		{
			return true;
		}
		return false;
	}
}
