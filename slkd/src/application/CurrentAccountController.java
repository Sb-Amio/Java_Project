package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import BankManagementSystemApp.DataHandler;
import javafx.event.ActionEvent;

public class CurrentAccountController 
{

	    @FXML
	    private TextField amountID;

	    @FXML
	    private Button backID;

	    @FXML
	    private TextArea textareaID;

	    @FXML
	    private TextField lisenceID;

	    @FXML
	    private TextField nameID;

	    @FXML
	    private Button nextID;

	    @FXML
	    private TextField nidID;


	
	@FXML
	public void nextButton(ActionEvent event) throws IOException 
	{
		String text1 = nameID.getText();
		String text2 = nidID.getText();
		double text3 = Double.parseDouble(amountID.getText());
		String text4 = lisenceID.getText();
		String t = Main.bank.addaccount(text1, text2, text3, text4);
		textareaID.setText("Your Account No: "+t);
		DataHandler.saveData(Main.bank);
		nameID.clear();
		nidID.clear();
		amountID.clear();
		lisenceID.clear();
	}
	
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("AccountTypePage.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) backID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
	}
}
