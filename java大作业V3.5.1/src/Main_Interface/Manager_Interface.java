package Main_Interface;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Child_Interface.About_Author;
import Child_Interface.About_Project;
import Child_Interface.AddItems;
import Child_Interface.AlterItems;
import Child_Interface.Del_Items;
import Child_Interface.Gender_Statistics;
import Child_Interface.Num_Sort;
import Child_Interface.Politics_Statistics;
import Child_Interface.SearchByName;
import Child_Interface.SearchByNative;
import Child_Interface.SearchByNum;
import Child_Interface.SearchBySex;
import Child_Interface.UpdatePassword;

public class Manager_Interface implements ActionListener{
	
	MenuBar bar=new MenuBar();//主界面菜单栏
	Menu menu1,menu2,menu2_child,menu3,menu4,menu5;
	MenuItem menu1_item1,menu1_item2,menu1_item3,menu2_item1,child_item1,child_item2,child_item3,child_item4,menu3_item1,
	menu3_item2,memu3_item3,menu4_item,menu5_item1,menu5_item2;
	JFrame jFrame;
	JPanel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14;//声明子面板
	public Manager_Interface() {
		// TODO Auto-generated constructor stub
		jFrame=new JFrame("学生信息管理系统");
		//setTitle("学生信息管理系统");
		jFrame.setLayout(null);
		jFrame.setSize(700, 520);
		
		jFrame.setLocationRelativeTo(null);
		
		menu1=new Menu("信息管理");
		menu1_item1=new MenuItem("录入");
		menu1_item2=new MenuItem("修改");
		menu1_item3=new MenuItem("删除");
		menu2=new Menu("信息浏览");
		menu2_item1=new MenuItem("学号排序");
		menu2_child=new Menu("查询");
		child_item1=new MenuItem("学号查询");
		child_item2=new MenuItem("姓名查询");
		child_item3=new MenuItem("性别查询");
		child_item4=new MenuItem("籍贯查询");
		menu3=new Menu("信息统计");
		menu3_item1=new MenuItem("性别统计");
		menu3_item2=new MenuItem("籍贯统计");
		memu3_item3=new MenuItem("政治面貌统计");
		menu4=new Menu("修改密码");
		menu4_item=new MenuItem("修改");
		menu5=new Menu("关于");
		menu5_item1=new MenuItem("关于作者");
		menu5_item2=new MenuItem("关于项目");
		
		menu1.add(menu1_item1);
		menu1.add(menu1_item2);
		menu1.add(menu1_item3);
		menu2.add(menu2_item1);
		menu2_child.add(child_item1);
		menu2_child.add(child_item2);
		menu2_child.add(child_item3);
		menu2_child.add(child_item4);
		menu2.add(menu2_child);
		menu3.add(menu3_item1);
		//menu3.add(menu3_item2);
		menu3.add(memu3_item3);
		menu4.add(menu4_item);
		menu5.add(menu5_item1);
		menu5.add(menu5_item2);
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		bar.add(menu5);
		jFrame.setMenuBar(bar);
		//创建子面板
		//录入
		j1=new AddItems();
		j2=new AlterItems();
		j3=new Del_Items();	
		//浏览中的查询
		j5=new SearchByNum();
		j6=new SearchByName();
		j7=new SearchBySex();
		j8=new SearchByNative();
		//信息统计
		//j9=new Gender_Statistics();
		//修改密码
		j12=new UpdatePassword();
		//关于
		j13=new About_Author();
		j14=new About_Project();
		//给子菜单添加侦听器
		menu1_item1.addActionListener(this);//录入侦听器
		menu1_item2.addActionListener(this);//修改侦听器
		menu1_item3.addActionListener(this);//删除侦听器
		menu2_item1.addActionListener(this);//排序侦听器
		child_item1.addActionListener(this);//学号查询侦听器
		child_item2.addActionListener(this);//姓名查询侦听器
		child_item3.addActionListener(this);//性别查询侦听器
		child_item4.addActionListener(this);//籍贯查询侦听器
		menu3_item1.addActionListener(this);//性别统计侦听器
		//menu3_item2.addActionListener(this);//籍贯统计侦听器
		memu3_item3.addActionListener(this);//政治面貌统计侦听器
		menu4_item.addActionListener(this);//修改密码侦听器
		menu5_item1.addActionListener(this);//关于作者侦听器
		menu5_item2.addActionListener(this);//关于系统侦听器
		
		jFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if (o==menu1_item1) {
			jFrame.setContentPane(j1);
		}else if (o==menu1_item2) {
			jFrame.setContentPane(j2);
		}else if (o==menu1_item3) {
			jFrame.setContentPane(j3);
		}else if (o==menu2_item1) {
			jFrame.setContentPane(Num_Sort.getJPanel());
		}else if (o==child_item1) {
			jFrame.setContentPane(j5);
		}else if (o==child_item2) {
			jFrame.setContentPane(j6);
		}else if (o==child_item3) {
			jFrame.setContentPane(j7);
		}else if (o==child_item4) {
			jFrame.setContentPane(j8);
		}else if (o==menu3_item1) {
			jFrame.setContentPane(Gender_Statistics.getPanel());
		}else if (o==menu3_item2) {
			
		}else if (o==memu3_item3) {
			jFrame.setContentPane(Politics_Statistics.getPanel());
		}else if (o==menu4_item) {
			jFrame.setContentPane(j12);
		}else if (o==menu5_item1) {
			jFrame.setContentPane(j13);
		}else if (o==menu5_item2) {
			jFrame.setContentPane(j14);
		}
		
	}
	public static void main(String[] args) {
		new Manager_Interface();
	}
}
