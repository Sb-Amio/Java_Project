package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class CustomerIDController {

    @FXML
    private Button enterID;

    @FXML
    private Button backID;
    
    @FXML
    private Label labelID;

    @FXML
    private PasswordField passwordID;
    
    public static String s;
    
    @FXML
    void nextButton(ActionEvent event) throws IOException 
    {
    	s = passwordID.getText();
    	if(Main.bank.findAccounts(s).isEmpty())
    	{
    		labelID.setText("Wrong Customer NID!");
    	}
    	else
    	{
    		Main m = new Main();
    		m.changeStage("CustomerLogin.fxml");
    	}
    	passwordID.clear();
    }
    @FXML
    void backButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
		m.changeStage("LoginPage.fxml");
    }
}
