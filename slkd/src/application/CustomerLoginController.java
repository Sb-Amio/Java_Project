package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class CustomerLoginController {
	@FXML
	private Button summaryID;
	@FXML
	private Button transactionID;
	@FXML
	private Button allacountsID;
	@FXML
	private Button backID;

	// Event Listener on Button[#summaryID].onAction
	@FXML
	public void summaryButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("SummaryCustomer.fxml");
	}
	// Event Listener on Button[#transactionID].onAction
	@FXML
	public void transactionButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("TransactionCustomer.fxml");
	}
	// Event Listener on Button[#allacountsID].onAction
	@FXML
	public void allacountsButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("AllAccountsCustomer.fxml");
	}
	// Event Listener on Button[#backID].onAction
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("LoginPage.fxml");
	}
}
