package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LoginPageController implements Initializable{

    @FXML
    private Button employeeID;
    
    @FXML
    private Button customerID;

    @FXML
    private Label labelID;
    
    
    
    @FXML
    private void employeeButton(ActionEvent event) throws IOException
    {
    	Main main = new Main();
    	main.changeStage("EmployeeID.fxml");
    }
    @FXML
    private void customerButton(ActionEvent event) throws IOException
    {
    	Main main = new Main();
    	main.changeStage("CustomerID.fxml");
    	
    }
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		labelID.setText(Main.bank.getbankname());
		
	}
   

}


