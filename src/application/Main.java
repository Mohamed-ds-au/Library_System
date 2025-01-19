package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
public class Main extends Application {
	static Scanner input = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
			Scene scene = new Scene(root,Color.GREEN);
			//TableView table = new TableView();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		launch(args);
		//Sql.Connect();
		//useDatabase();
	}
	public static void useDatabase() throws SQLException, IOException {
		int option = 0;
		do {
			System.out.println("Choose opertion:");
			System.out.println("1-Search about book");
			System.out.println("2-Add book");
			System.out.println("3-Delete book");
			System.out.println("4-show tables");
			System.out.println("5-Exit");
			option = input.nextInt();
			switch(option){
			
			case 1:
				System.out.println("Which books do you want:");
				String title = br.readLine();
				Sql.searchBook(title);
				break;
			case 2:
				System.out.println("isbn:");
				int isbn = input.nextInt();
				System.out.println("author:");
				String author = br.readLine();
				System.out.println("genere:");
				String genere = br.readLine();
				System.out.println("year:");
				int year = input.nextInt();				
				System.out.println("title:");
				String title1 = br.readLine();
				System.out.println("availble:");
				int availble = input.nextInt();
				Sql.addBook(isbn, author, genere, year, title1, availble);
				break;
			case 3:
				System.out.println("ISBN:");
				isbn = input.nextInt();
				Sql.deleteBook(isbn);
				break;
			case 4:
				Sql.showTables();
				break;
			case 5:
				option =4;
				break;
			default:
				System.out.println("Choose valid choice");
			}
		}
		while(option !=4);
	}
}
