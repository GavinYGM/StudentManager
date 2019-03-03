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
			JOptionPane.showMessageDialog(null, "���ݿ�δ�ܴ򿪣�");
		}
	}

	// ִ�����ݿ��ѯ��������������쳣������null
	public static ResultSet executeQuery(String sql) {
		try {
			// ���δ�������ݿ����ӣ��򴴽�����
			if (con == null)
				new JDBC();
			// ���ز�ѯ���
			return con.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
			return null;
		}
	}

	// ִ�����ݿ���²�������������⣬�򷵻�-1
	public static int executeUpdate(String sql) {
		try {
			// ���δ�������ݿ����ӣ��򴴽�����
			if (con == null)
				new JDBC();
			// ���ز������
			return con.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�������󣬼�¼�޷������������£�");
			return -1;
		}
	}

	// �ر����ݿ�
	public static void Close() {
		try {
			// ������ݿ��Ѵ򿪣���ر�֮
			if (con != null)
				con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�δ�򿪣�");
		}
	}



}
