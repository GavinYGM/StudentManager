package Child_Interface;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class About_Author extends JPanel{
	/**
	 * ����--�ӽ���
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,name,namet,num,numt,class1,classt,collage,collaget;
	public About_Author() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		title=new JLabel("��  ��  ��  ��");
		name=new JLabel("�� ��:");
		namet=new JLabel("�����");
		num=new JLabel("ѧ ��:");
		numt=new JLabel("8002117056");
		class1=new JLabel("�� ��:");
		classt=new JLabel("��1702��");
		collage=new JLabel("ѧ У:");
		collaget=new JLabel("�ϲ���ѧ���ѧԺ");
		
		title.setFont((new Font("����", Font.BOLD, 50)));
		name.setFont((new Font("����", Font.BOLD, 20)));
		namet.setFont((new Font("����", Font.BOLD, 20)));
		num.setFont((new Font("����", Font.BOLD, 20)));
		numt.setFont((new Font("����", Font.BOLD, 20)));
		class1.setFont((new Font("����", Font.BOLD, 20)));
		classt.setFont((new Font("����", Font.BOLD, 20)));
		collage.setFont((new Font("����", Font.BOLD, 20)));
		collaget.setFont((new Font("����", Font.BOLD, 20)));
		
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
		setVisible(true); // ʹ����ɼ�
	}
}
