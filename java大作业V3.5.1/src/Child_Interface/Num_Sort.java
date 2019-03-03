package Child_Interface;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Public.JDBC;
import Public.Student;

public class Num_Sort extends JPanel{
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane scrollPane;
	String[] heads= {"姓名","学号","政治面貌","性别","班级","年龄","电话","QQ","家庭住址","籍贯"};
	public Num_Sort() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		String sql="select * from student";
		List<Student> students=new ArrayList<>();
 		Object[][] stu=new Object[30][heads.length];
		try {
			ResultSet rs=JDBC.executeQuery(sql);
			while (rs.next()) {
				Student student=new Student();
				student.setName(rs.getString("name"));
				student.setNum(rs.getString("num"));
				student.setPolitics(rs.getString("politics"));
				student.setSex(rs.getString("sex"));
				student.setClas(rs.getString("class"));
				student.setAge(rs.getString("age"));
				student.setTel(rs.getString("tel"));
				student.setQQ(rs.getString("QQ"));
				student.setAddress(rs.getString("address"));
				student.setNative(rs.getString("native"));
				students.add(student);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Collections.sort(students);
        Iterator<Student> it= students.iterator();
        int j=0;
        while(it.hasNext()){
            Student s = it.next();
            stu[j][0]=s.getName();
			stu[j][1]=s.getNum();
			stu[j][2]=s.getPolitics();
			stu[j][3]=s.getSex();
			stu[j][4]=s.getClas();
			stu[j][5]=s.getAge();
			stu[j][6]=s.getTel();
			stu[j][7]=s.getQQ();
			stu[j][8]=s.getAddress();
			stu[j][9]=s.getNative();
			j++;
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
		setVisible(true);
	}
	public static Num_Sort getJPanel() {
		return new Num_Sort();
	}

}
