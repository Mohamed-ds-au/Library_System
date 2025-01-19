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

public class controlAddBook {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField isbn1;
	@FXML
	private TextField author1;
	@FXML
	private TextField genere1;
	@FXML
	private TextField year1;
	@FXML
	private TextField title1;
	@FXML
	private TextField ava;
	int isbn ;
	
	String author; 
	String genere ;
	int year ;
	String title ;
	int availble ;
	alertControl cn = new alertControl();
	public void addBook() {}
	public void back(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("manageBooksFXML.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void addBook(ActionEvent e) throws SQLException, IOException {
		try {
		isbn = Integer.parseInt(isbn1.getText());
		}catch(Exception ex) {
			cn.alert();
			return;
		}
		author = author1.getText();
		genere = genere1.getText();
		try {
		year = Integer.parseInt(year1.getText());
		}catch(Exception ex) {
			cn.alert();
			return;
		}
		title = title1.getText();
		try {
		availble = Integer.parseInt(ava.getText());
		}catch(Exception ex) {
			cn.alert();
			return;
		}
		Sql.addBook(isbn, author, genere, year, title, availble);
	}
	public void showTablesAction(ActionEvent e) throws SQLException {
		
		
		Sql.showTables();
	}
}
