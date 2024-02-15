package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;


import javafx.scene.control.TextArea;


public class AllAccountsCustomerController implements Initializable{
	
    @FXML
    private TextArea textareaID;
	@FXML
	private Button backID;
	@FXML
	 private ListView<String> listviewID;

	@FXML
	public void backButton(ActionEvent event) throws IOException 
	{
		Main m = new Main();
		m.changeStage("CustomerLogin.fxml");
	}
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		String text1 = CustomerIDController.s;
		String s = Main.bank.findAccounts(text1).toString();
		String [] t = s.split(",");
		listviewID.getItems().addAll(t);
	}
}
