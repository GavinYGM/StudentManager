package Public;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
@SuppressWarnings("restriction")
public class SeeImg {
	
	public static Image seeImage(String name) throws IOException {
		Image img=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch ( ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("��������ʧ�ܣ�");
		}
		try (
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login?characterEncoding=UTF-8","root","admin");
			Statement s=con.createStatement();
				){


			//ͼƬ��ȡ��
			
			ResultSet rs = null;
			
			String sql1 = "select photo from img where name='"+name+"'";
			rs=s.executeQuery(sql1);
			if(rs.next()) {
			//ͼƬ����������
			java.io.InputStream in = rs.getBinaryStream(1);
			JPEGImageDecoder decoder=JPEGCodec.createJPEGDecoder(in);
			img=decoder.decodeAsBufferedImage();		
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return img;
	} 
}
