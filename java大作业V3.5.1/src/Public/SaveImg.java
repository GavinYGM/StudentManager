package Public;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class SaveImg {
	public static void saveImage(File f,String name) throws IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch ( ClassNotFoundException e) {
			// TODO: handle exception
		}
		try (
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login?characterEncoding=UTF-8","root","admin");
			Statement s=con.createStatement();
				){
			FileInputStream str;
			if (f==null) {
				str=null;
			}else {
				str=new FileInputStream(f.getAbsolutePath()); //Õº∆¨Œƒº˛¬∑æ∂
			}
			
			String sql="insert into img(name,photo) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setBinaryStream(2,str,str.available()); //Õº∆¨ ˝æ›
			int i = pstmt.executeUpdate();
			if (i>0) {
				JOptionPane.showMessageDialog(null, "Õº∆¨±£¥Ê≥…π¶£°");
			}else {
				JOptionPane.showMessageDialog(null, "Õº∆¨±£¥Ê ß∞‹£°");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(null, "Œ¥ÃÌº”’’∆¨£°");
		}
	}
}
