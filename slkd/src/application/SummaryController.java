package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BankManagementSystemApp.InvalidAccountException;
import javafx.event.ActionEvent;

public class SummaryController implements Initializable{
	@FXML
	private TextField accountID;
	@FXML
	private Button showID;
    @FXML
    private ListView<String> listviewID;
	 
	@FXML
	private Button backID;

	
	@FXML
	public void showButton(ActionEvent event) throws InvalidAccountException 
	{
		String text1 = accountID.getText();
		try
		{
			String t = Main.bank.findaccount(text1).toString();
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
	
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) backID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
