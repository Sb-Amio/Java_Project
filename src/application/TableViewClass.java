package application;

public class TableViewClass 
{
	public String accType;
	public String name;
	public String accNum;
	public String accNid;
	public double accBalance;
	public double accMinbalance;
	
	public TableViewClass(String accType, String name, String accNum, String accNid, double accBalance,
			double accMinbalance) 
	{
		this.accType = accType;
		this.name = name;
		this.accNum = accNum;
		this.accNid = accNid;
		this.accBalance = accBalance;
		this.accMinbalance = accMinbalance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccNid() {
		return accNid;
	}

	public void setAccNid(String accNid) {
		this.accNid = accNid;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAccMinbalance() {
		return accMinbalance;
	}

	public void setAccMinbalance(double accMinbalance) {
		this.accMinbalance = accMinbalance;
	}
}
