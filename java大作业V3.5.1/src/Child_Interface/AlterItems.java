package Child_Interface;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Public.JDBC;
import Public.SeeImg;
import Public.Student;
import Public.StudentSelect;

public class AlterItems extends JPanel{

	/**
	 *�޸���Ϣ����
	 */
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
	Button saveBtn=new Button("��   ��");
	Button SearchBtn=new Button("��ѯ");
	Button addImg=new Button("�����Ƭ");
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
	public AlterItems() {
		// TODO Auto-generated constructor stub
		
		setLayout(null);
		setSize(700, 520);
		lbname1.setBounds(200, 20, 50, 20);
		lbname1.setFont((new Font("����", Font.BOLD, 16)));
		tf_name1.setBounds(260, 20, 100, 20);
		lbname.setBounds(50, 50, 50, 20); // ����
		tf_name.setBounds(110, 50, 100, 20);
		tf_name.setEnabled(false);
		tf_name.setEditable(false);
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

		saveBtn.setBounds(180, 300,300, 100); // ���水ť
		saveBtn.setBackground(Color.CYAN);
		saveBtn.setFont((new Font("����", Font.BOLD, 50)));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					btn_saveActionPerformed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addImg.setBounds(55, 280, 100, 30);//�����Ƭ��ť
		addImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_addImgActionPerformed(e);
			}
		});
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
		add(saveBtn);
		//add(addImg);
		add(SearchBtn);
		//�����Ƭ���
		
		img.setBackground(Color.lightGray);
		img.setBounds(20, 60,180, 220);
		lbimg=new JLabel();
		img.add(lbimg);
		add(lbname1);
		add(tf_name1);
		add(img);
		setVisible(true);
	}
	//�����Ƭ������
	private void btn_addImgActionPerformed(ActionEvent e) {
		
		JFileChooser fileChooser=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("jpeg,gif,bmp,png", "jpg","gif","png","gif");
		fileChooser.setFileFilter(filter);
		try {
			fileChooser.showOpenDialog(null);
			
		} catch (HeadlessException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		try {
			f=fileChooser.getSelectedFile();
			icon=new ImageIcon(f.getPath());
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "���ͼƬʧ�ܣ�");
			return;
		}
		
		icon.setImage(icon.getImage().getScaledInstance(180,220,Image.SCALE_DEFAULT));//80��100Ϊ��С ������������		
		lbimg.setIcon(icon);
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
				icon=new ImageIcon(SeeImg.seeImage(student.getName()));
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
	private void btn_saveActionPerformed(ActionEvent e) throws IOException {
		String name = tf_name.getText();
		String num = tf_num.getText();
		String politics = tf_politics.getSelectedItem().toString();
		String sex = tf_sex.getSelectedItem().toString();
		String Class = tf_class.getText();
		String age = tf_age.getText();
		String tel = tf_tel.getText();
		String QQ=tf_QQ.getText();
		String address=tf_address.getText();
		String Native=tf_native.getText();
		// �������Ϊ�գ�����ֹ�����¼����
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
			return;
		}
		
		try {
			//String img1 = null;
			//img1 = f.getPath();
			//SaveImg.saveImage(f,name);
			// ����¼���浽student����
			
			String sql = "update student set num='" + num + 
					"',politics='" + politics + "',sex='" + sex
					+ "',class='" + Class + "',age='" + age + "',tel='"
					+ tel + "',QQ='" + QQ + "',address='" + address+"',native='" 
					+Native+"'where name='"+name+"'";
			int i = JDBC.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "��Ϣ����ɹ���");
				// ���ȫ���ı���	
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "ӦΪ���֣�");
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
