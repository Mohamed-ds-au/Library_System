package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class alertControl {
	private Stage stage;
	private Parent root;
	private Scene scene;
	public void alert() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("alert.fxml"));
		root = loader.load();
		scene =new Scene(root, 413, 190);
		stage = new Stage();
		stage.setTitle("Error!!");
		try {
		stage.setScene(scene);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		stage.show();
		
	}
}
