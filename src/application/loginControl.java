package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class loginControl {
	@FXML
	private TextField enterUserid;
	@FXML
	private TextField enterPassword;
	int userid;
	String password;
	private Stage stage;
	private Scene scene;
	private Parent root;
	public  void login(ActionEvent e) throws SQLException, IOException {
		
		userid = Integer.parseInt(enterUserid.getText());
		password = enterPassword.getText();
		String query1 = "select * from members where member_id = "+userid;
		String query2 = "select * from employee where emp_id = "+userid;
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		Statement st2 = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		ResultSet rs2 = st2.executeQuery(query2);
		//rs.next();
		//rs2.next();
		if(rs2.next()) {
			if(rs2.getInt("emp_id") == userid ) {
				if(rs2.getString("emp_pass").equals(password)) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("employeeDashboardFXML.fxml"));
					try {
						root = loader.load();
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					System.out.println(rs2.getString(1));
					
					stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					try {
						scene =new Scene(root);
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					stage.setScene(scene);
					stage.show();
				}
				else {
					System.out.println("wrong password");
					return;
				}
			}
		}
		
			
		
		if(rs.next()) {
			if(rs.getInt("member_id") == userid ) {
				if(rs.getString("mem_pass").equals(password)) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("memberDashboard.fxml"));
					try {
						root = loader.load();
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					System.out.println(rs.getString(1));
					
					stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					scene =new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
				else {
					System.out.println("wrong password");
					return;
				}
			}
		}
		else {
			System.out.println("Id dose not exist");
		}
	
	}
	
	public void BackToWelcome(ActionEvent event) throws IOException {
		controlMemDash logout = new controlMemDash();
		logout.logout(event);
	}
}


