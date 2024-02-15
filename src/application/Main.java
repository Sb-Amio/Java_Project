package application;
	
import java.io.IOException;

import BankManagementSystemApp.Bank;
import BankManagementSystemApp.DataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Stage stg;
	public static Bank bank = DataHandler.loadData();
	

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("BankApp");
        stage.setScene(scene);
        stage.show();
    }

    public void changeStage(String fxml) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
    }
	public static void main(String[] args) {
		launch(args);
	}
    
}
