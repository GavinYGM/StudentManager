package Public;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JDBC {
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection con = null;
	
	private JDBC() {
		// TODO Auto-generated constructor stub
		try {
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login?characterEncoding=UTF-8", "root",
						"admin");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据库未能打开！");
		}
	}

	// 执行数据库查询工作。如果出现异常，返回null
	public static ResultSet executeQuery(String sql) {
		try {
			// 如果未创建数据库连接，则创建连接
			if (con == null)
				new JDBC();
			// 返回查询结果
			return con.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库不存在，或存在错误！");
			return null;
		}
	}

	// 执行数据库更新操作。如果有问题，则返回-1
	public static int executeUpdate(String sql) {
		try {
			// 如果未创建数据库连接，则创建连接
			if (con == null)
				new JDBC();
			// 返回操作结果
			return con.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据有误，记录无法正常保存或更新！");
			return -1;
		}
	}

	// 关闭数据库
	public static void Close() {
		try {
			// 如果数据库已打开，则关闭之
			if (con != null)
				con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库未打开！");
		}
	}



}
