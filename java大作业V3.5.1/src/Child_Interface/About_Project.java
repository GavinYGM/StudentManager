package Child_Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class About_Project extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel title,name,namet,ver,vert,time1,timet,dec,dect1,dect2,dect3,dect4;
	public About_Project() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		title=new JLabel("��  ��  ��  Ŀ");
		name=new JLabel("�� ��:"); 
		namet=new JLabel("ѧ����Ϣ����ϵͳ");
		ver=new JLabel("�� ��:");
		vert=new JLabel("Ver 3.5.0");
		time1=new JLabel("ʱ ��:");
		timet=new JLabel("2018.12.18��2018.12.31");
		dec=new JLabel("�� ��:");
		dect1=new JLabel("����Ŀ��ȫ�ɸ��˶���������ģ��ȫ��");
		dect2=new JLabel("���Լ���ƣ����κγ�Ϯ���󣡱���Ŀ���ѵ����������ݿ�ʵ");
		dect3=new JLabel("��ͼƬ�Ķ����ƴ�ȡ�����˻��Ѵ���ʱ�������ʵ�֣�ϣ����");
		dect4=new JLabel("������ʦ���ӣ�");
		
		title.setFont((new Font("����", Font.BOLD, 50)));
		name.setFont((new Font("����", Font.BOLD, 20)));
		namet.setFont((new Font("����", Font.BOLD, 20)));
		ver.setFont((new Font("����", Font.BOLD, 20)));
		vert.setFont((new Font("����", Font.BOLD, 20)));
		time1.setFont((new Font("����", Font.BOLD, 20)));
		timet.setFont((new Font("����", Font.BOLD, 20)));
		dec.setFont((new Font("����", Font.BOLD, 20)));
		dect1.setFont((new Font("����", Font.BOLD, 20)));
		dect2.setFont((new Font("����", Font.BOLD, 20)));
		dect3.setFont((new Font("����", Font.BOLD, 20)));
		dect4.setFont((new Font("����", Font.BOLD, 20)));
		
		title.setBounds(130, 30, 400, 60);
		name.setBounds(200, 110, 80, 30);
		namet.setBounds(280, 110, 180, 30);
		ver.setBounds(200, 150, 80, 30);
		vert.setBounds(280, 150, 120, 30);
		time1.setBounds(200, 190, 80, 30);
		timet.setBounds(280, 190, 250, 30);
		dec.setBounds(200, 230, 80, 30);
		dect1.setBounds(280, 230, 400, 30);
		dect2.setBounds(70, 270, 600, 30);
		dect3.setBounds(70, 310, 600, 30);
		dect4.setBounds(70, 350, 600, 30);
		
		add(title);
		add(name);
		add(namet);
		add(ver);
		add(vert);
		add(time1);
		add(timet);
		add(dec);
		add(dect1);
		add(dect2);
		add(dect3);
		add(dect4);
		setVisible(true); // ʹ����ɼ�
	}
}
