package application;
import java.sql.*;
public class Sql {
	
	
	public static void Connect() throws SQLException, ClassNotFoundException {
		//Class.forName( "com.mysql.jdbc.Driver");
		String sql = "select * from books";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		System.out.println(rs.next());
		
	}
	
	public static void searchBook(String name) throws SQLException {
		String query = "select * from books where title = \""+name+"\"";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String isbn = rs.getString("ISBN");
		String author = rs.getString("AUTHOR");
		String genere = rs.getString("genere");
		String availble = rs.getString("is_avaliable_book");
		String year = rs.getString("publish_year");
		
		System.out.println(isbn +" "+ author+" "+genere+" "+year+" "+rs.getString("title")+" "+availble);
		
	}
	
	public static void addBook(int isbn, String author, String genere, int year, String title,int availble ) throws SQLException {
		String query  = "insert into books values (?,?,?,?,?,?)";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, isbn);
		st.setString(2, author);
		st.setString(3, genere);
		st.setInt(4, year);
		st.setString(5, title);
		st.setInt(6, availble);
		int count = st.executeUpdate();
		System.out.println(count+" row/s is effected");
	}
	
	public static void deleteBook(int isbn) throws SQLException {
		String query = "delete from books where isbn = "+isbn;
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		int count = st.executeUpdate(query);
		System.out.println(count+" row/s is effected");
	}
	public static void showTables() throws SQLException {
		String query = "show tables";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
	
	public static void showBookForMem() throws SQLException {
		String query = "select * from books";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString("title")+ rs.getString("AUTHOR")+rs.getString("genere"));
		}
	}
	 public static void showEmployees() throws SQLException {
		 
		 String query = "select * from employee";
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("emp_id")+ rs.getString("emp_name")+rs.getString("departments_dep_id"));
			}
	 }
	 public static void showBorrowedBooks() throws SQLException {
		 
		 String query = "select * from borrowed_books";
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
		 Statement st=con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 while(rs.next()) {
			 System.out.println(rs.getString("members_member_id")+ rs.getString("emplouee_emp_id")+rs.getString("book_id"));
		 }
	 }
	 public static void borrowBook() {
		 
	 }
	 public static void deleteMember(int id) throws SQLException {
			String query = "delete from members where id = "+id;
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
			Statement st=con.createStatement();
			int count = st.executeUpdate(query);
			System.out.println(count+" row/s is effected");
		}
	 public static void addMember( String pass, String email, String member_name, int zip_code,String state, String street, String city ) throws SQLException {
			String query  = "insert into members(mem_pass, mem_email, member_name,zip_code,state, street, city) values (?,?,?,?,?,?,?)";
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");  
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, pass);
			st.setString(2, email);
			st.setString(3, member_name);
			st.setInt(4, zip_code);
			st.setString(5, state);
			st.setString(6, street);
			st.setString(7, city);
			int count = 0;
			try {
			 count = st.executeUpdate();
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			System.out.println(count+" row/s is effected");
		}
	 
	 
}
