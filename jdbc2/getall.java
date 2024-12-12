package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class getall {
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
			System.out.println("Enter table name");
			String sql = "select * from "+sc.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs =pmst.executeQuery();
			while(rs.next()) {
				System.out.println("id : "+rs.getInt("id"));
				System.out.println("name :"+rs.getString("name"));
				System.out.println("email :"+rs.getString("email"));
				System.out.println("age :"+rs.getString("age"));
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
