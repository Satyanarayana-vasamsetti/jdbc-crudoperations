package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
			String sql = "insert into operations(name,email,password) values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter name");
			pmst.setString(1,sc.next());
			System.out.println("Enter email");
			pmst.setString(2,sc.next());
			System.out.println("Enter password");
			pmst.setString(3,sc.next());
			int i = pmst.executeUpdate();
			
			if(i>0) {
				System.out.println("Data is Inserted");
			}
			else {
				System.out.println("Error");
			}
			pmst.close();
			conn.close();
			sc.close();;
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}
