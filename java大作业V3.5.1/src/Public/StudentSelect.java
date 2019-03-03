package Public;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class StudentSelect {

	public static Student SelectStudentByName(String name) {
		String sql = "select * from student where name='" + name + "'";
		ResultSet rs = JDBC.executeQuery(sql);
		Student student = null;
		try {
			if (rs.next()) {
				student=new Student();
				student.setName(rs.getString("name"));
				student.setNum(rs.getString("num"));
				student.setAge(rs.getString("age"));
				student.setPolitics(rs.getString("politics"));
				student.setSex(rs.getString("sex"));
				student.setClas(rs.getString("class"));
				student.setTel(rs.getString("tel"));
				student.setQQ(rs.getString("QQ"));
				student.setAddress(rs.getString("address"));
				student.setNative(rs.getString("native"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		};
		
		return student;
		
	}
	public static Student SelectStudentByNum(String num) {
		String sql = "select * from student where num='" + num + "'";
		ResultSet rs = JDBC.executeQuery(sql);
		Student student = null;
		try {
			if (rs.next()) {
				student=new Student();
				student.setName(rs.getString("name"));
				student.setNum(rs.getString("num"));
				student.setAge(rs.getString("age"));
				student.setPolitics(rs.getString("politics"));
				student.setSex(rs.getString("sex"));
				student.setClas(rs.getString("class"));
				student.setTel(rs.getString("tel"));
				student.setQQ(rs.getString("QQ"));
				student.setAddress(rs.getString("address"));
				student.setNative(rs.getString("native"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		};
		
		return student;
	}
}
