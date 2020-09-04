package model;

public class Book {
	private int idbook ;
	private String bookname ;
	private String author ;
	public Book() {
		
	}
	public Book(int idbook, String bookname, String author) {
		super();
		this.idbook = idbook;
		this.bookname = bookname;
		this.author = author;
	}
	public int getIdbook() {
		return idbook;
	}
	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
}