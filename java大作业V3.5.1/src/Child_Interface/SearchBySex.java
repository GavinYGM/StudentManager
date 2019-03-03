package Child_Interface;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import Public.JDBC;

public class SearchBySex extends JPanel{
	private static final long serialVersionUID = 1L;
	Label lbsex=new Label("性  别:");
	TextField tf_sex=new TextField();
	Button SearchBtn=new Button("查询");
	JTable table;
	JScrollPane scrollPane;
	String[] heads= {"姓名","学号","政治面貌","性别","班级","年龄","电话","QQ","家庭住址","籍贯"};
	

	public SearchBySex() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		lbsex.setBounds(200, 20, 50, 20);
		lbsex.setFont((new Font("宋体", Font.BOLD, 16)));
		tf_sex.setBounds(260, 20, 100, 20);
	
		SearchBtn.setBounds(370, 20, 80, 20);//添加照片按钮
		SearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					btn_SearchBtnActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	

		add(SearchBtn);
		add(lbsex);
		add(tf_sex);
		setVisible(true);
	}
	public void btn_SearchBtnActionPerformed(ActionEvent e) throws SQLException {
		String sex = tf_sex.getText();
		// 如果图书编号为空，则查询操作终止
		if (sex.equals("")) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		}
		String sql="select * from student where sex='"+sex+"'";
		ResultSet rs=JDBC.executeQuery(sql);
		Object[][] stu=new Object[30][heads.length];
		int i=0;
		while (rs.next()) {
			stu[i][0]=rs.getString("name");
			stu[i][1]=rs.getString("num");
			stu[i][2]=rs.getString("politics");
			stu[i][3]=rs.getString("sex");
			stu[i][4]=rs.getString("class");
			stu[i][5]=rs.getString("age");
			stu[i][6]=rs.getString("tel");
			stu[i][7]=rs.getString("QQ");
			stu[i][8]=rs.getString("address");
			stu[i][9]=rs.getString("native");
			i++;
		}
		table=new JTable(stu, heads);
		scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10, 40, 670, 380);
		//分别设置水平和垂直滚动条自动出现
		scrollPane.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane);
	}
}
