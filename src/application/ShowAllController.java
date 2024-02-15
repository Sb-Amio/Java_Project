package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ShowAllController implements Initializable {

    @FXML
    private Button backID;

    @FXML
    private ListView<String> listviewID;


    @FXML
    void backButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("EmployeeLogin.fxml");

    }
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		String s = Main.bank.getAccounts().toString();
		String[] t = s.split("\n");
		listviewID.getItems().addAll(t);
	}

}
