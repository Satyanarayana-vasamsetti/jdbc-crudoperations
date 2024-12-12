package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "Satya@22551A4261";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter username");
			String username = sc.next();
			System.out.println("Enter password");
			Integer age = sc.nextInt();
			System.out.println("Enter table name");
			String sql = "select * from "+sc.next()+" where email=? and age=?";
			pmst = conn.prepareStatement(sql);
			pmst.setString(1,username);
			pmst.setInt(2,age);
			ResultSet rs =pmst.executeQuery();
			if(rs.next()) {
				System.out.println("Successfully logined");
			}
			else {
				System.out.println("Invalid user");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
