package Child_Interface;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class About_Author extends JPanel{
	/**
	 * 关于--子界面
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,name,namet,num,numt,class1,classt,collage,collaget;
	public About_Author() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		title=new JLabel("关  于  作  者");
		name=new JLabel("姓 名:");
		namet=new JLabel("杨高明");
		num=new JLabel("学 号:");
		numt=new JLabel("8002117056");
		class1=new JLabel("班 级:");
		classt=new JLabel("软工1702班");
		collage=new JLabel("学 校:");
		collaget=new JLabel("南昌大学软件学院");
		
		title.setFont((new Font("宋体", Font.BOLD, 50)));
		name.setFont((new Font("宋体", Font.BOLD, 20)));
		namet.setFont((new Font("宋体", Font.BOLD, 20)));
		num.setFont((new Font("宋体", Font.BOLD, 20)));
		numt.setFont((new Font("宋体", Font.BOLD, 20)));
		class1.setFont((new Font("宋体", Font.BOLD, 20)));
		classt.setFont((new Font("宋体", Font.BOLD, 20)));
		collage.setFont((new Font("宋体", Font.BOLD, 20)));
		collaget.setFont((new Font("宋体", Font.BOLD, 20)));
		
		title.setBounds(130, 40, 400, 60);
		name.setBounds(200, 140, 80, 30);
		namet.setBounds(280, 140, 80, 30);
		num.setBounds(200, 180, 80, 30);
		numt.setBounds(280, 180, 120, 30);
		class1.setBounds(200, 220, 80, 30);
		classt.setBounds(280, 220, 120, 30);
		collage.setBounds(200, 260, 80, 30);
		collaget.setBounds(280, 260, 200, 30);
		
		add(title);
		add(name);
		add(namet);
		add(num);
		add(numt);
		add(class1);
		add(classt);
		add(collage);
		add(collaget);
		setVisible(true); // 使窗体可见
	}
}
