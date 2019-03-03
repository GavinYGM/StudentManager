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
	
	MenuBar bar=new MenuBar();//������˵���
	Menu menu1,menu2,menu2_child,menu3,menu4,menu5;
	MenuItem menu1_item1,menu1_item2,menu1_item3,menu2_item1,child_item1,child_item2,child_item3,child_item4,menu3_item1,
	menu3_item2,memu3_item3,menu4_item,menu5_item1,menu5_item2;
	JFrame jFrame;
	JPanel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14;//���������
	public Manager_Interface() {
		// TODO Auto-generated constructor stub
		jFrame=new JFrame("ѧ����Ϣ����ϵͳ");
		//setTitle("ѧ����Ϣ����ϵͳ");
		jFrame.setLayout(null);
		jFrame.setSize(700, 520);
		
		jFrame.setLocationRelativeTo(null);
		
		menu1=new Menu("��Ϣ����");
		menu1_item1=new MenuItem("¼��");
		menu1_item2=new MenuItem("�޸�");
		menu1_item3=new MenuItem("ɾ��");
		menu2=new Menu("��Ϣ���");
		menu2_item1=new MenuItem("ѧ������");
		menu2_child=new Menu("��ѯ");
		child_item1=new MenuItem("ѧ�Ų�ѯ");
		child_item2=new MenuItem("������ѯ");
		child_item3=new MenuItem("�Ա��ѯ");
		child_item4=new MenuItem("�����ѯ");
		menu3=new Menu("��Ϣͳ��");
		menu3_item1=new MenuItem("�Ա�ͳ��");
		menu3_item2=new MenuItem("����ͳ��");
		memu3_item3=new MenuItem("������òͳ��");
		menu4=new Menu("�޸�����");
		menu4_item=new MenuItem("�޸�");
		menu5=new Menu("����");
		menu5_item1=new MenuItem("��������");
		menu5_item2=new MenuItem("������Ŀ");
		
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
		//���������
		//¼��
		j1=new AddItems();
		j2=new AlterItems();
		j3=new Del_Items();	
		//����еĲ�ѯ
		j5=new SearchByNum();
		j6=new SearchByName();
		j7=new SearchBySex();
		j8=new SearchByNative();
		//��Ϣͳ��
		//j9=new Gender_Statistics();
		//�޸�����
		j12=new UpdatePassword();
		//����
		j13=new About_Author();
		j14=new About_Project();
		//���Ӳ˵����������
		menu1_item1.addActionListener(this);//¼��������
		menu1_item2.addActionListener(this);//�޸�������
		menu1_item3.addActionListener(this);//ɾ��������
		menu2_item1.addActionListener(this);//����������
		child_item1.addActionListener(this);//ѧ�Ų�ѯ������
		child_item2.addActionListener(this);//������ѯ������
		child_item3.addActionListener(this);//�Ա��ѯ������
		child_item4.addActionListener(this);//�����ѯ������
		menu3_item1.addActionListener(this);//�Ա�ͳ��������
		//menu3_item2.addActionListener(this);//����ͳ��������
		memu3_item3.addActionListener(this);//������òͳ��������
		menu4_item.addActionListener(this);//�޸�����������
		menu5_item1.addActionListener(this);//��������������
		menu5_item2.addActionListener(this);//����ϵͳ������
		
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
