package BankManagementSystemApp;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class DataHandler 
{
	private static String fileName = "data.txt";
	
	public static void saveData(Bank bank) 
	{
			ObjectOutputStream oos = null;
			try 
			{
				oos = new ObjectOutputStream(new FileOutputStream(fileName));
				oos.writeObject(bank);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();// delete this once project is complete
			}
			finally 
			{
				if(oos != null)
				{
					try 
					{
						oos.close();
					} 
					catch (IOException e) 
					{
					
					}
				}
			}
	}

	public static Bank loadData() 
	{
		ObjectInputStream oos = null;
		//Bank b = null;
		try 
		{
			oos = new ObjectInputStream(new FileInputStream(fileName));
			return (Bank)oos.readObject();
		} 
		catch (IOException e) 
		{
			e.printStackTrace(); // delete this once project is complete
			return new Bank("UAPIAN");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();// delete this once project is complete
		}
		finally 
		{
			if(oos != null)
			{
				try 
				{
					oos.close();
				} 
				catch (IOException e)
				{
				
				}
			}
	
		}
		return new Bank("UAPIAN");
	}
}
