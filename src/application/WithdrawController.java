package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import BankManagementSystemApp.DataHandler;
import BankManagementSystemApp.InSufficientBalanceException;
import BankManagementSystemApp.InvalidAccountException;
import BankManagementSystemApp.MaximumWithdrawLimitException;
import javafx.event.ActionEvent;

public class WithdrawController {
	 	@FXML
	    private TextField accountID;

	    @FXML
	    private TextField amountID;

	    @FXML
	    private Button backID;

	    @FXML
	    private Label labelID;

	    @FXML
	    private Button nextID;


	// Event Listener on Button[#nextID].onAction
	@FXML
	public void nextButton(ActionEvent event) throws IOException,InvalidAccountException,  InSufficientBalanceException, MaximumWithdrawLimitException 
	{
		String text1 = accountID.getText();
		double text2 = Double.parseDouble(amountID.getText());
		
		try
		{
			Main.bank.withdraw(text1, text2);
			labelID.setText("Withdraw Successful");
			amountID.clear();
		}
		catch(InvalidAccountException | MaximumWithdrawLimitException | InSufficientBalanceException e)
		{
			labelID.setText(e.getMessage());
			amountID.clear();
		}
			
		DataHandler.saveData(Main.bank);
	}
	// Event Listener on Button[#backID].onAction
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) backID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
	}
}
