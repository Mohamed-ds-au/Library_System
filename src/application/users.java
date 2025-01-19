package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class users {
	int isbn;
	String author;
	String genere;
	int year;
	String title;
	int availble;
	public users(String title,int isbn,String author,String genere,int year,int availble) {
		
		this.title = (title);
		this.isbn = ( isbn);
		this.author = (author);
		this.genere =  (genere);
		this.year = (year);
		this.availble = (availble);
		
	}
	
	  public int getIsbn() {
	        return isbn;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public String getGenere() {
	        return genere;
	    }

	    public int getYear() {
	        return year;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public int getAvailble() {
	        return availble;
	    }
}
