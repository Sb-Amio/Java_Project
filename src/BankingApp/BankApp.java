package BankingApp;

import java.util.Scanner;

import javax.swing.JOptionPane;

import BankManagementSystemApp.Bank;
import BankManagementSystemApp.DataHandler;
import BankManagementSystemApp.InSufficientBalanceException;
import BankManagementSystemApp.InvalidAccountException;
import BankManagementSystemApp.MaximumWithdrawLimitException;


public class BankApp 
{
	public static void main(String[]args)
	{
		Bank bank = DataHandler.loadData();
		
		while(true)
		{
			boolean check = true;
			System.out.println(" >>> "+bank.getbankname()+" <<<");
			System.out.println(" 1 -> Enter as an Employee");
			System.out.println(" 2 -> Enter as a Customer");
			System.out.println(" 0 -> Exit");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			if(a==1)
			{
				System.out.print(" Enter Employee ID: ");
				String pass = sc.next();
				if(bank.password(pass))
				{
					System.out.print(" You Have Entered as an Employee");
					while(check == true)
					{
						System.out.println("");
						System.out.println(" 1 -> Add New Account");
						System.out.println(" 2 -> Deposit Money");
						System.out.println(" 3 -> Withdraw Money");
						System.out.println(" 4 -> Transfer Money");
						System.out.println(" 5 -> Summary(Specific Account)");
						System.out.println(" 6 -> Transaction(Specific Account)");
						System.out.println(" 7 -> Show Accounts(Specific types)");
						System.out.println(" 8 -> Show All Accounts");
						System.out.println(" 9 -> Switch Mode");
						System.out.println(" 0 -> Exit");
						
						int b = sc.nextInt();
						switch(b)
						{
						case 0: System.exit(a);
						case 9:	check = false; break;
						default: System.out.println(" Invalid input");break;
						
						case 1: System.out.println(" 1 -> Savings Account");
						System.out.println(" 2 -> Current Accounts");
						int c = sc.nextInt();
						if(c==1)
						{
							String c1name = JOptionPane.showInputDialog("Enter Your Name: ");
							String c1nid = JOptionPane.showInputDialog("Enter your nid number: ");
							double c1balance = Double.parseDouble(JOptionPane.showInputDialog("Enter your balance: "));
							double c1limit = Double.parseDouble(JOptionPane.showInputDialog("Enter max withdraw limit: "));
							System.out.println(" Your Account Number: "+bank.addaccount(c1name, c1nid, c1balance, c1limit));
							DataHandler.saveData(bank);
						}
						else
						{
							String c1name = JOptionPane.showInputDialog("Enter Your Name: ");
							String c1nid = JOptionPane.showInputDialog("Enter your nid number: ");
							double c1balance = Double.parseDouble(JOptionPane.showInputDialog("Enter your balance: "));
							String c1trade = JOptionPane.showInputDialog("Enter Your trade Lisence number: ");
							System.out.println(" Your Account Number: "+bank.addaccount(c1name, c1nid, c1balance, c1trade));
							DataHandler.saveData(bank);
						}
						break;
						
						case 2: while(true) 
						{
							String c2accnum = JOptionPane.showInputDialog("Enter account number: ");
							double c2depamount = Double.parseDouble(JOptionPane.showInputDialog("Enter Deposit Amount: "));
							try 
							{
								bank.deposit(c2accnum, c2depamount);
								break;
							} 
						
							catch (InvalidAccountException e) 
							{
								System.out.println(e.getMessage());
							}
							DataHandler.saveData(bank);
						}
						break;
						
						case 3: while(true)
							{
								String c3accnum = JOptionPane.showInputDialog("Enter account number: ");
								double c3withdrawamount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdraw amount:"));
								try 
								{
									bank.withdraw(c3accnum, c3withdrawamount);
									break;
								} 
								catch (InSufficientBalanceException | MaximumWithdrawLimitException | InvalidAccountException e) 
								{
									
									System.out.println(e.getMessage());
								}
								DataHandler.saveData(bank);
							}
							break;
						
						case 4: while(true)
						{

							String c4fromaccount = JOptionPane.showInputDialog("Enter Sender account number: ");
							String c4toaccount = JOptionPane.showInputDialog("Enter receiver account number: ");
							double c4amount = Double.parseDouble(JOptionPane.showInputDialog("Enter transfer amount: "));
								try 
								{
									bank.transfer(c4fromaccount, c4toaccount, c4amount);
									break;
								} 
								catch (InvalidAccountException | InSufficientBalanceException | MaximumWithdrawLimitException e) 
								{
									
									System.out.println(e.getMessage());
								}
								DataHandler.saveData(bank);
						}
						break;
						
						case 5: while(true)
						{

							String c5accnum = JOptionPane.showInputDialog("Enter account number: ");
								try 
								{
									bank.display(c5accnum);
									break;
								} 
								catch (InvalidAccountException e) 
								{
									System.out.println(e.getMessage());
								}
						}
						break;
						
						case 6: while(true)
						{

							String c6accnum = JOptionPane.showInputDialog("Enter account number: ");
							try 
							{
								System.out.println(bank.getAccTransaction(c6accnum));
								break;
							} 
							catch (InvalidAccountException e) 
							{
								System.out.println(e.getMessage());
								
							}
						}
						break;
						
						case 7: String c7type = JOptionPane.showInputDialog("Enter Account type: ");
						System.out.println(bank.getAccounts(c7type));break;
						
						case 8: bank.display();break;
						}
						
					}
				}
				else
				{
					System.out.println(" You Have Entered Wrong Employee ID\n");
				}
			}
				
				
				
			else if(a==2)
			{
				System.out.print(" YOU HAVE ENTERED AS A CUSTOMER");
				while(check == true)
				{
					System.out.println("");
					System.out.println(" 1 -> Summary");
					System.out.println(" 2 -> Transaction");
					System.out.println(" 3 -> Show All Your Accounts");
					System.out.println(" 9 -> Switch Mode");
					System.out.println(" 0 -> Exit");
					int b = sc.nextInt();
					switch(b)
					{
					case 0: System.exit(a);
					case 9: check = false; break;
					default: System.out.println(" Invalid input");break;
										
					case 1: while(true)
					{
						try
						{
							String c1accnum = JOptionPane.showInputDialog("Enter account number: ");
							String c1memberNID = JOptionPane.showInputDialog("Enter nid number: ");
							System.out.println(bank.findAccount(c1memberNID, c1accnum));
							break;
						}
						catch(InvalidAccountException e)
						{
							System.out.println(e.getMessage());
						}
					}
					break;
					
					case 2: while(true)
					{
						try
						{
							String c2accnum = JOptionPane.showInputDialog("Enter account number: ");
							String c2membernid = JOptionPane.showInputDialog("Enter nid number: ");
							System.out.println(bank.getAccTransactiions(c2membernid, c2accnum));
							break;
						}
						catch(InvalidAccountException e)
						{
							System.out.println(e.getMessage());
						}
					}
					break;
					
					case 3: String c3memberNID = JOptionPane.showInputDialog("Enter nid number: ");
					System.out.println(bank.findAccounts(c3memberNID));break;
					}
				}
			}
			else 
			{
				sc.close();System.exit(a);
			}
		}
		
		
	}
}
