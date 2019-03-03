package Child_Interface;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Public.SeeImg;
import Public.Student;
import Public.StudentSelect;

public class SearchByName extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel child=new JPanel();
	JPanel img=new JPanel();
	ImageIcon icon;
	JLabel lbimg;
	File f;
	Label lbname1=new Label("�� �� :");
	Label lbname=new Label("����");
	Label lbnum=new Label("ѧ��");
	Label lbclass=new Label("�༶");
	Label lbage=new Label("����");
	Label lbsex=new Label("�Ա�");
	Label lbpolitics=new Label("������ò");
	Label lbnative=new Label("����");
	Label lbaddress=new Label("��ͥסַ");
	Label lbtel=new Label("�绰");
	Label lbQQ=new Label("QQ");
	Button SearchBtn=new Button("��ѯ");
	TextField tf_name1=new TextField();
	TextField tf_name = new TextField();
	TextField tf_num = new TextField();
	TextField tf_class=new TextField();
	TextField tf_age = new TextField();
	TextField tf_QQ = new TextField();
	TextField tf_native = new TextField();
	TextField tf_address = new TextField();
	TextField tf_tel = new TextField();
	Choice tf_politics = new Choice();
	Choice tf_sex=new Choice();
	public SearchByName() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		lbname1.setBounds(200, 20, 50, 20);
		lbname1.setFont((new Font("����", Font.BOLD, 16)));
		tf_name1.setBounds(260, 20, 100, 20);
		lbname.setBounds(50, 50, 50, 20); // ����
		tf_name.setBounds(110, 50, 100, 20);
		lbnum.setBounds(240, 50, 50, 20); // ѧ��
		tf_num.setBounds(300, 50, 100, 20);
		lbclass.setBounds(50, 130, 50, 20); // �༶
		tf_class.setBounds(110, 130, 100, 20);
		lbpolitics.setBounds(50, 90, 50, 20); // ������ò
		tf_politics.setBounds(110, 90, 100, 20);
		tf_politics.add("��Ա");
		tf_politics.add("Ԥ����Ա");
		tf_politics.add("�뵳��������");
		tf_politics.add("������Ա");
		tf_politics.add("Ⱥ��");
		lbsex.setBounds(240, 90, 50, 20); // �Ա�
		tf_sex.setBounds(300, 90, 100, 20);
		tf_sex.add("��");
		tf_sex.add("Ů");
		lbnative.setBounds(240, 210, 50, 20); // ����
		tf_native.setBounds(300, 210, 100, 20);
		lbage.setBounds(240, 130, 50, 20); // ����
		tf_age.setBounds(300, 130, 100, 20);
		lbtel.setBounds(50, 170, 50, 20); // �绰
		tf_tel.setBounds(110, 170, 100, 20);
		lbQQ.setBounds(240, 170, 50, 20); // QQ
		tf_QQ.setBounds(300, 170, 100, 20);
		lbaddress.setBounds(50, 210, 50, 20); // ��ͥסַ
		tf_address.setBounds(110, 210, 100, 20);

	
		SearchBtn.setBounds(370, 20, 80, 20);//�����Ƭ��ť
		SearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_SearchBtnActionPerformed(e);
			}
		});
		child.setSize(500, 250);
		child.setBounds(200, 40, 500, 250);
		child.setLayout(null);
		child.add(lbname);
		child.add(lbnum);
		child.add(lbsex);
		child.add(lbage);
		child.add(lbaddress);
		child.add(lbpolitics);
		child.add(lbtel);
		child.add(lbnative);
		child.add(lbQQ);
		child.add(tf_name);
		child.add(tf_num);
		child.add(tf_age);
		child.add(tf_address);
		child.add(tf_sex);
		child.add(tf_tel);
		child.add(tf_native);
		child.add(tf_QQ);
		child.add(tf_politics);
		child.add(lbclass);
		child.add(tf_class);
		add(child);

		add(SearchBtn);
		img.setBackground(Color.lightGray);
		img.setBounds(20, 60,180, 220);
		lbimg=new JLabel();
		img.add(lbimg);
		add(lbname1);
		add(tf_name1);
		add(img);
		setVisible(true);
	}
	
	public void btn_SearchBtnActionPerformed(ActionEvent e) {
		String name = tf_name1.getText();
		// ���ͼ����Ϊ�գ����ѯ������ֹ
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
			return;
		}
		
		Student student = StudentSelect.SelectStudentByName(name);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (student != null) {
			tf_name.setText(student.getName());
			tf_num.setText(student.getNum());
			tf_politics.select(student.getPolitics());
			tf_sex.select(student.getSex());
			tf_class.setText(student.getClas());
			tf_age.setText(student.getAge());
			tf_tel.setText(student.getTel());
			tf_QQ.setText(student.getQQ());
			tf_address.setText(student.getAddress());
			tf_native.setText(student.getNative());
			try {
				icon=new ImageIcon(SeeImg.seeImage(name));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				lbimg.setIcon(null);
				JOptionPane.showMessageDialog(null, "����Ƭ��");
				return;
			}
			icon.setImage(icon.getImage().getScaledInstance(180,220,Image.SCALE_DEFAULT));//80��100Ϊ��С ������������		
			
			lbimg.setIcon(icon);
			
			
		} else {
			JOptionPane.showMessageDialog(null, "�������󣬲��޴��ˣ�");
			clearAllTextfield();
		}
			
		
	}
	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_name1.setText("");
		tf_name.setText("");
		tf_num.setText("");
		tf_class.setText("");
		tf_age.setText("");
		tf_tel.setText("");
		tf_QQ.setText("");
		tf_address.setText("");
		tf_native.setText("");
		lbimg.setIcon(null);
	}
}
