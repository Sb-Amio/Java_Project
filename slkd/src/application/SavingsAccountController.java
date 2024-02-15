package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



import java.io.IOException;

import BankManagementSystemApp.DataHandler;
import javafx.event.ActionEvent;

public class SavingsAccountController {
	@FXML
	private TextField nameID;
	@FXML
	private TextField nidID;
	@FXML
	private TextField amountID;
	@FXML
	private TextField maxlimitID;
	@FXML
	private Button nextID;
	@FXML
	private Button backID;
	@FXML
	private TextArea textareaID;


	@FXML
	public void nextButton(ActionEvent event) throws IOException
	{
		String text1 = nameID.getText();
		String text2 = nidID.getText();
		double text3 = Double.parseDouble(amountID.getText());
		double text4 = Double.parseDouble(maxlimitID.getText());

		String t = Main.bank.addaccount(text1, text2, text3, text4);
		textareaID.setText("Your Account No: "+t);
		DataHandler.saveData(Main.bank);
		nameID.clear();
		nidID.clear();
		amountID.clear();
		maxlimitID.clear();
	}

	@FXML
	public void backButton(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeStage("AccountTypePage.fxml");
	}
}