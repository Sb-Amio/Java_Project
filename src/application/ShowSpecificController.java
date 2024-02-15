package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class ShowSpecificController {
	
	@FXML
	private Button savingsID;
	@FXML
	private Button currentID;
	@FXML
	private TextArea textareaID;
	@FXML
	private Button backID;

	// Event Listener on Button[#savingsID].onAction
	@FXML
	public void savingsButton(ActionEvent event) 
	{
		textareaID.setText(Main.bank.getAccounts("SavingsAccount").toString());
		
	}
	// Event Listener on Button[#currentID].onAction
	@FXML
	public void currentButton(ActionEvent event) 
	{
		textareaID.setText(Main.bank.getAccounts("CurrentAccount").toString());
	}
	// Event Listener on Button[#backID].onAction
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("EmployeeLogin.fxml");
	}
}
