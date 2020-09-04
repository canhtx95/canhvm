package model;

import java.util.ArrayList;
import java.util.Scanner;



import controller.JDBCConnection;

public class AccountManager {
	ArrayList<Account> acc = JDBCConnection.getAccFromSQL();
	static BookManagement bm = new BookManagement();
	
	static Scanner sc = new Scanner(System.in);

	public void adminAcess() {
		int choice = 0;
		boolean flag = true;

		while (flag) {
			showAdminMenu();
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				bm.showBook();
				break;
			case 2:
				bm.searchBook();
				break;
			case 3:
				bm.addBook();
				break;
			case 4:
				bm.deleteBook();
				break;
			case 5:
				flag = false;
				System.out.println(" Dang xuat thanh cong ");
				break;

			}
		}
	}

	public void memberAcess() {
		int choice = 0;
		boolean flag = true;

		while (flag) {
			showMemberMenu();
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				bm.showBook();
				break;
			case 2:
				bm.searchBook();
				break;
			case 3:

				flag = false;
				System.out.println(" Tam biet quy khach ");
				break;

			}
		}
	}
public void showMenu() {
	boolean w = true ;
	while(w) {
	System.out.println("1. Dang nhap");
	System.out.println("2. Tao tai khoan");
	int x = sc.nextInt();
	switch(x) {
	case 1:
		
		break ;
	case 2 :
		createAcc();
		break ;
	}
	}
}
	public static void showAdminMenu() {

		System.out.println("1: Hien thi thong tin sach ");
		System.out.println("2: Tim kiem sach ");
		System.out.println("3: Them thong tin sach ");
		System.out.println("4: Xoa thong tin sach");
		System.out.println("5: Dang xuat ");
	}

	public static void showMemberMenu() {

		System.out.println("1: Hien thi thong tin sach ");
		System.out.println("2: Tim kiem sach ");
		System.out.println("3: Dang xuat ");
	}

	public void createAcc() {
		int signal ;
		String user ;
		String pass ;
		while (true) {
		signal = 0;
		System.out.println(" Nhap tai khoan muon tao : ");
		user = sc.nextLine();
		System.out.println(" Mat khau : ");
		pass = sc.nextLine();
		
			for (int i = 0; i < acc.size(); i++) {
				if (user.equals(acc.get(i).getUser())) {
					System.out.println("Trung tai khoan , xin moi nhap lai : "+i);
					signal = 1;
					break;
					}
			}
		if(signal == 0) {
			
			break ;
		}
		}
		
		String sql = "insert into info.account(user,pass) values(?,?)";
		JDBCConnection.addInfoToSQL1(user, pass, sql);
		acc = JDBCConnection.getAccFromSQL();
		System.out.println(" Tao tai khoan thanh cong , quay ve trang dang nhap ");
		
	}
}
