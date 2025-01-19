package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class controlEmpDash {
	private Stage stage;
	private Scene scene;
	private Parent root;
	public void logout(ActionEvent event) throws IOException {
		controlMemDash logout = new controlMemDash();
		logout.logout(event);
	}
	public void manageBooks(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("manageBooksFXML.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
