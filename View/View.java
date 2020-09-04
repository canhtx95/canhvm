package View;

import java.util.ArrayList;
import java.util.Scanner;

import controller.JDBCConnection;
import model.Account;
import model.AccountManager;
import model.BookManagement;

public class View {
	static ArrayList<Account> acc = JDBCConnection.getAccFromSQL();
	static Scanner sc = new Scanner(System.in);
	static BookManagement bm = new BookManagement();
	static AccountManager account = new AccountManager();

	public static void logIn() {
		boolean w = true;
		while (w) {
			System.out.println("1. Dang nhap");
			System.out.println("2. Tao tai khoan");
			int x = sc.nextInt();

			switch (x) {
			case 1:
				String notice = "Tai khoan hoac mat khau khong dung ";

				for (; true;) {

					System.out.println("____Dang Nhap______");
					System.out.println("                   ");
					System.out.println("Tai Khoan : ");
					String user = sc.nextLine();
					String user1=user;
					
					System.out.println("Mat Khau : ");
					String pass = sc.nextLine();
					if (user1.equals("admin") && pass.equals("admin")) {
						System.out.println(" Dang nhap voi tu cach admin ");
						account.adminAcess();
						logIn();
					}
					for (int i = 0; i < acc.size(); i++) {
						if (acc.get(i).getUser().equals(user) && acc.get(i).getPass().equals(pass)) {
							System.out.println(" Dang nhap thanh cong ");
							System.out.println("");
							account.memberAcess();
							logIn();

						}
					}

					System.out.println(notice);

					break;
				}
				break;
			case 2:
				account.createAcc();
				break;
			}
		}
	}

	public static void main(String[] args) {
		logIn();
	}

}
