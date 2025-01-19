package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controlSignUp {
	@FXML
	private TextField enterName;
	@FXML
	private TextField enterEmail;
	@FXML
	private TextField enterState;
	@FXML
	private TextField enterCity;
	@FXML
	private TextField enterStreet;
	@FXML
	private TextField enterZipCode;
	@FXML
	private TextField enterPass;
	@FXML
	private TextField confirmPass;
	
	String name;
	String email;
	String State;
	String city;
	String street;
	int zipCode;
	String confirmPass2;
	private Stage stage;
	private Scene scene;
	private Parent root;
	public void signUpAsMember(ActionEvent event) throws SQLException, IOException {
		confirmPass2 = confirmPass.getText();
		name = enterName.getText();
		email = enterEmail.getText();
		State = enterState.getText();
		city = enterCity.getText();
		street = enterStreet.getText();
		zipCode = Integer.parseInt(enterZipCode.getText());
		Sql.addMember(confirmPass2, email, name, zipCode, State, street, city);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void backToWelcome(ActionEvent event) throws IOException {
		controlMemDash logout = new controlMemDash();
		logout.logout(event);
	}
}
