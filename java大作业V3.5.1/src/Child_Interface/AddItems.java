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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Public.JDBC;
import Public.SaveImg;


public class AddItems extends JPanel{
	/**
	 *�����Ϣģ��
	 */
	private static final long serialVersionUID = 1L;
	JPanel child=new JPanel();
	JPanel img=new JPanel();
	ImageIcon icon;
	JLabel lbimg;
	File f;
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
	Button addImg=new Button("�����Ƭ");
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
	public AddItems() {	
		
		
		setLayout(null);
		setSize(700, 520);
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

		saveBtn.setBounds(180, 300,300, 100); // ���水ť
		saveBtn.setBackground(Color.CYAN);
		saveBtn.setFont((new Font("����", Font.BOLD, 50)));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_saveActionPerformed(e);
			}
		});
		addImg.setBounds(55, 240, 100, 30);//�����Ƭ��ť
		addImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_addImgActionPerformed(e);
			}
		});
		child.setSize(500, 250);
		child.setBounds(200, 0, 500, 250);
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
		add(addImg);
		//�����Ƭ���
		
		img.setBackground(Color.lightGray);
		img.setBounds(20, 20,180, 220);
		lbimg=new JLabel();
		img.add(lbimg);
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
	//���水ť������
	
	
	private void btn_saveActionPerformed(ActionEvent e) {
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
		
		if (IfNameHave(name)) {
			JOptionPane.showMessageDialog(null, "�����ظ���");
			tf_name.setText("");
			return;
		}
		if (IfNumHave(num)) {
			JOptionPane.showMessageDialog(null, "ѧ���ظ���");
			tf_num.setText("");
			return;
		}
		try {
			SaveImg.saveImage(f, name);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {

			// ����¼���浽student����
			String sql = "insert into student values(null,'" + name
					+ "','" + num + "','" + politics + "','" + sex
					+ "','" + Class + "','" + age + "','"
					+ tel + "','" + QQ + "','" + address+"','" 
					+Native+ "')";
			int i = JDBC.executeUpdate(sql);
			if (i == 1) {
				
				JOptionPane.showMessageDialog(null, "��Ϣ��ӳɹ���");
				// ���ȫ���ı���
				
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "ӦΪ���֣�");
		}
		
	}

	// �ж�student�����Ƿ����ָ��������������ڣ�����true�����򣬷���false
	private boolean IfNameHave(String name) {
		String sql = "select * from student where name='" + name + "'";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return false;
	}
	private boolean IfNumHave(String num) {
		String sql = "select * from student where num='" + num + "'";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return false;
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
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