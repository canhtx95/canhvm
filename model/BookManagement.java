package model;

import java.util.ArrayList;
import java.util.Scanner;

import controller.JDBCConnection;

public class BookManagement {
	private static ArrayList<Book> arr = JDBCConnection.getBookFromSQL();
	static Scanner sc = new Scanner(System.in);
	public  void showBook() {

		for (int i = 0; i < arr.size(); i++) {
			System.out.println("__________________________________________________________");
			System.out.println("ID          : " + arr.get(i).getIdbook());
			System.out.println("Ten Sach    : " + arr.get(i).getBookname());
			System.out.println("Ten Tac gia : " + arr.get(i).getAuthor());
			System.out.println("__________________________________________________________");

		}
	}

	public  void searchBook() {
		String notice = " Khong tim thay sach ";
		System.out.println(" moi ban nhap ten sach ");
		String s = sc.nextLine();
		 
		for (int i = 0; i < arr.size(); i++) {
			if (s.equals(arr.get(i).getBookname())) {
				System.out.println("**********");
				System.out.println("ID          : " + arr.get(i).getIdbook());
				System.out.println("Ten Sach    : " + arr.get(i).getBookname());
				System.out.println("Ten Tac gia : " + arr.get(i).getAuthor());
				System.out.println("**********");
				notice ="";
			}		
			
		} 
		System.out.println(notice);
		
	}
	public void addBook() {
		System.out.println(" moi ban nhap ten sach : ");
		String bookname = sc.nextLine();
		System.out.println(" Ten tac gia : ");
		String author = sc.nextLine();
		String sql="insert into info.book(bookname,author) values(?,?)";
		JDBCConnection.addInfoToSQL1(bookname,author,sql);
		arr = JDBCConnection.getBookFromSQL();
		System.out.println("them thanh cong");
		System.out.println("_____________________");

	}
	
	public  void deleteBook() {
		
		System.out.println("moi ban nhap ID sach muon xoa : ");
		int id = sc.nextInt();
		JDBCConnection.deleteInfoSQL(id);
		arr.remove(id -1);
		
	}
	
}
