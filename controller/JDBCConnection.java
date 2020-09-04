package controller;



import java.sql.*;
import java.util.ArrayList;

import model.Account;
import model.Book;


public class JDBCConnection {
	private static String Driver ="com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/info";
	private static String user = "root";
	private static String pass = "canh12";
	static ArrayList<Book> list = new ArrayList<Book>();
	static ArrayList<Account> listAcc = new ArrayList<Account>();
	public static Connection SQLConection() { // KET NOI

		try {
			Class.forName(Driver);

			Connection conn = DriverManager.getConnection(url, user, pass);
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	
//	public static ResultSet getSQLBookInfo() {		// LAY TOAN BO THONG TIN CUA BOOK TU SQL
//		try {
//			String sql = "select*from info."+"book";
//
//			Statement st = SQLConection().createStatement();
//			return st.executeQuery(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;		
//	}
	public static ResultSet getSQLInfo(String s) {		// LAY TOAN BO THONG TIN CUA database TU SQL
		
		try {
			String sql = "select*from info."+s;

			Statement st = SQLConection().createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}

	public static ArrayList<Account> getAccFromSQL() {	// CHUYEN THONG TIN Account TU SQL VAO MANG ECLIPSE
		try {		
			ResultSet rs = getSQLInfo("account");
				
			while(rs.next()) {
				
				String user = rs.getString("user");
				String pass = rs.getString("pass");
				
				 listAcc.add(new Account(user,pass));
			}
			return listAcc ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAcc;
		
	}
		
	
	public static ArrayList<Book> getBookFromSQL() {	// CHUYEN THONG TIN BOOK TU SQL VAO MANG ECLIPSE
		try {		
			ResultSet rs = getSQLInfo("book");
				
			while(rs.next()) {
				int idbook = rs.getInt(1);
				String bookname = rs.getString("bookname");
				String author = rs.getString(3);
				
				 list.add(new Book(idbook,bookname,author));
			}
			return list ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public static void addInfoToSQL(String y , String z) { // THEM THONG TIN VAO SQL
		
		try {
			String sql="insert into info.book(bookname,author) values(?,?)";
			PreparedStatement st = SQLConection().prepareStatement(sql);
			
			st.setString(1, y);
			st.setString(2, z);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addInfoToSQL1(String y , String z , String sql) { // THEM THONG TIN VAO SQL
		
		try {
			 
			PreparedStatement st = SQLConection().prepareStatement(sql);
			
			st.setString(1, y);
			st.setString(2, z);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteInfoSQL(int x) {
		String sql="delete from info.book where idbook=?";
		try {
			PreparedStatement st = SQLConection().prepareStatement(sql);
			st.setInt(1, x);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}