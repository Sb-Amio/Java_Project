package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmployeeLoginController {

    @FXML
    private Button addaccountID;

    @FXML
    private Button backID;

    @FXML
    private Button depositID;

    @FXML
    private Button showallID;

    @FXML
    private Button showspecificID;

    @FXML
    private Button summaryID;

    @FXML
    private Button transactionID;

    @FXML
    private Button transferID;

    @FXML
    private Button withdrawID;

    @FXML
    void addaccountButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("AccountTypePage.fxml");
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) backID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene
    }

    @FXML
    void depositButton(ActionEvent event) throws IOException 
    {
    	Parent root = FXMLLoader.load(getClass().getResource("Deposit.fxml")); // load the new FXML file
        Scene scene = new Scene(root); // create a new scene with the new FXML file
        Stage stage = (Stage) depositID.getScene().getWindow(); // get the current stage
        stage.setScene(scene); // set the new scene in the stage
        stage.show(); // show the new scene

    }

    @FXML
    void showallButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("ShowAll.fxml");
    }

    @FXML
    void showspecificButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("ShowSpecific.fxml");
    }

    @FXML
    void summaryButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("Summary.fxml");
    }

    @FXML
    void transactionButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("Transaction.fxml");
    }

    @FXML
    void transferButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("Transfer.fxml");
    }

    @FXML
    void withdrawButton(ActionEvent event) throws IOException 
    {
    	Main m = new Main();
    	m.changeStage("Withdraw.fxml");
    }

}

