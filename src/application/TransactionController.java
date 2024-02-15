package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import BankManagementSystemApp.InvalidAccountException;
import javafx.event.ActionEvent;

public class TransactionController {
	  	@FXML
	  	private TextField accountID;

	    @FXML
	    private Button backID;

	    @FXML
	    private ListView<String> listviewID;

	    @FXML
	    private Button showID;
	    
	@FXML
	public void showButton(ActionEvent event)throws InvalidAccountException
	{
		String text1 = accountID.getText();
		try
		{
			//System.out.println(Main.bank.getAccTransaction(text1));
			String s = Main.bank.getAccTransaction(text1).toString();
			String [] t = s.split("\n");
			listviewID.getItems().addAll(t);
			accountID.clear();
		}
		catch(InvalidAccountException e)
		{
			listviewID.getItems().addAll(e.getMessage());
			accountID.clear();
		}
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
