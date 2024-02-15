package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class EmployeeIDController {
	@FXML
	private Button nextID;
	@FXML
	private Label labelID;
	@FXML
	private Button backID;
	 @FXML
	    private PasswordField passwordID;
	// Event Listener on Button[#nextID].onAction
	@FXML
	public void nextButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		if(Main.bank.password(passwordID.getText()))
		{
			m.changeStage("EmployeeLogin.fxml");
		}
		else
		{
			labelID.setText("Wrong Employee ID!");
			passwordID.clear();
		}
	}
	
	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("LoginPage.fxml");
	}
}
