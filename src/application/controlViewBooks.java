package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class controlViewBooks {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TableView<users> table;
	@FXML
	private TableColumn<users, String> title;
	@FXML
	private TableColumn<users, Integer> isbnc;
	@FXML
	private TableColumn<users, String> author;
	@FXML
	private TableColumn<users, String> genere;
	@FXML
	private TableColumn<users, Integer> year;
	@FXML
	private TableColumn<users, Integer> ava;
	ObservableList<users> listm;
	 @FXML
	   public void initialize() throws SQLException {
	        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert ava != null : "fx:id=\"ava\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert genere != null : "fx:id=\"genere\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert isbnc != null : "fx:id=\"isbnc\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'viewBooks.fxml'.";
	        title.setCellValueFactory( new PropertyValueFactory <users, String> ("title"));
	        isbnc.setCellValueFactory( new PropertyValueFactory <users, Integer> ("isbn"));
			author.setCellValueFactory( new PropertyValueFactory <users, String> ("author"));
			genere.setCellValueFactory( new PropertyValueFactory <users, String> ("genere"));
			year.setCellValueFactory( new PropertyValueFactory <users, Integer> ("year"));
			ava.setCellValueFactory( new PropertyValueFactory <users, Integer> ("availble"));
			listm = insertValues();
			table.setItems(listm);

	    }
	
	public ObservableList<users> insertValues() throws SQLException {
		String query = "select * from books";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ObservableList<users> list = FXCollections.observableArrayList();
		while(rs.next()) {
			list.add(new users(rs.getString("title"), rs.getInt("ISBN"),rs.getString("AUTHOR"), rs.getString("genere"),rs.getInt("publish_year"),rs.getInt("is_available_book")));
		}
		return list;
		 
		
		
	}
	
	public void back(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("memberDashboard.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
