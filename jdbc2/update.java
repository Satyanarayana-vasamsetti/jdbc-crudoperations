package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String user ="root";
	private static final String pass = "Satya@22551A4261";
	private static final String url ="jdbc:mysql://127.0.0.1:3306/student";
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Enter table name");
			String sql = "update "+sc.next()+" set name=?,age=? where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter name");
			pmst.setString(1,sc.next());
			System.out.println("Enter age");
			pmst.setString(2,sc.next());
			System.out.println("Enter id");
			pmst.setInt(3,sc.nextInt());
			int i=pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Update successfully");
			}
			else {
				System.out.println("Error");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
