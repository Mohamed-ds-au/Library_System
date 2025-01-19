package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controlWelcome {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public void GoToSignUP(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("signUpFXML.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void goToLogin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
