package BankManagementSystemApp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime transactionTime;
	private double amount;
	private String transactiontype;
	
	//constructor
	public Transaction(double amount, String transactiontype)
	{
		this.amount = amount;
		this.transactiontype = transactiontype;
		transactionTime = LocalDateTime.now();
	}
	
	@Override
	public String toString()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String appTime = transactionTime.format(formatter);
		return String.format("Transaction Time: "+appTime
				+", Amount: "+amount+", Transaction Type: "+transactiontype+"\n");
	}

}