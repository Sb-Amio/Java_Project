package BankManagementSystemApp;

public class MaximumWithdrawLimitException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaximumWithdrawLimitException(double maxWithLimit) {
		super(" You are not allowed to withdraw more than "+maxWithLimit+" money");
	}
}
