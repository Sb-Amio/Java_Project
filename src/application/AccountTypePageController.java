package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AccountTypePageController {
	@FXML
	private Button savingsID;
	@FXML
	private Button currentID;
	@FXML
	private Button backID;

	@FXML
	public void savingsButton(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("SavingsAccount.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) savingsID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
	}
	@FXML
	public void currentButton(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("CurrentAccount.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) currentID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
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
