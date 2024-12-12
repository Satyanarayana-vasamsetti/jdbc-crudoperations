package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropdatabase {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "Satya@22551A4261";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter database name");
			String sql = "drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			pmst.close();
			conn.close();
			if(i==0) {
				System.out.println("Successfully droped");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
