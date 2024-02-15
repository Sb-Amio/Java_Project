package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BankManagementSystemApp.InvalidAccountException;
import javafx.event.ActionEvent;

public class SummaryCustomerController implements Initializable
{

	@FXML
	private TextField accountID;
	@FXML
	private Button showID;
	@FXML
	private Button backID;
    @FXML
    private ListView<String> listviewID;

	
	// Event Listener on Button[#showID].onAction
	@FXML
	public void showButton(ActionEvent event) throws IOException ,InvalidAccountException 
	{
		
		String text1 = accountID.getText();
		String text2 = CustomerIDController.s;
		try
		{
			String t = Main.bank.findAccount(text2, text1).toString();
			String [] s = t.split(",");
			listviewID.getItems().addAll(s);
			accountID.clear();
		}
		catch(InvalidAccountException e)
		{
			String t = e.getMessage();
			listviewID.getItems().addAll(t);
			accountID.clear();
		}
	}
	// Event Listener on Button[#backID].onAction
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("CustomerLogin.fxml");
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
