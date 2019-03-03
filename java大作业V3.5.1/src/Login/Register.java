package Login;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Public.JDBC;

public class Register extends JFrame{

	/**
	 * �˺�ע�����
	 */
	private static final long serialVersionUID = 1L;
	JTextField text_pass = new JTextField();
	JTextField text_num = new JTextField();
	public Register() {
		// TODO Auto-generated constructor stub
		this.setTitle("�˺�ע��");
		this.setSize(400, 300);
		this.setLayout(null);
		/* ��ӱ�ǩ���ı��� */
		Label lbNum = new Label("��    �ţ�");
		Label lbPass = new Label("��    �룺");
		lbNum.setFont((new Font("����", Font.BOLD, 20)));
		lbPass.setFont((new Font("����", Font.BOLD, 20)));
		lbNum.setBounds(60, 50, 75, 40);
		lbPass.setBounds(60, 100, 75, 40);		
		

		text_num.setFont((new Font("����", Font.BOLD, 23)));
		text_pass.setFont((new Font("����", Font.BOLD, 23)));
		text_num.setBounds(135, 55, 180, 30);
		text_pass.setBounds(135, 103, 180, 30);
		
		text_num.setToolTipText("����Ϊ3-6λ��ĸ_��������");
		text_pass.setToolTipText("�������Ϊ6λ��ĸ_��������");
		
		Button btn_cancel = new Button("ȡ��");
		Button btn_register=new Button("ע��");

		btn_cancel.setBounds(220, 170, 80, 25);//ȡ����ť
		btn_register.setBounds(100, 170, 80, 25);
		
		add(lbNum);
		add(lbPass);
		add(text_num);
		add(text_pass);
		add(btn_cancel);
		add(btn_register);
		
		btn_cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btn_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_registerActionPerformed(e);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JDBC.Close();
				dispose();
			}
		});
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		this.setVisible(true); // ʹ����ɼ�
		
	}
	public void btn_registerActionPerformed(ActionEvent e) {
		String num="\\w{3,6}"; //�û���������3-6λ
		boolean flag1=text_num.getText().matches(num);
		String pwd="\\w{6}"; //���������6λ
		boolean flag2=text_pass.getText().matches(pwd);

		if(flag1==false)
		{
			JOptionPane.showMessageDialog(null, "�˺���д����,����Ϊ3-6λ��ĸ_��������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			text_num.setText("");
		}else if(flag2==false)
		{
			JOptionPane.showMessageDialog(null, "������д����,����Ϊ6λ��ĸ_��������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			text_pass.setText("");
		}else {
			zhuceVerify(text_num.getText());
		}
		
	}
	public void zhuceVerify(String num) {
		try {
			// ����û����Ƿ����
			String sql = "select * from user where name="+ "'"+num+"'";
			ResultSet rs = JDBC.executeQuery(sql);
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "���û����Ѿ�����", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				text_num.setText("");
				text_pass.setText("");
			}else {
				String name=text_num.getText();
				String pwd=text_pass.getText();
				String sql1="insert into user values(null,'"+name+"','"+pwd+"',"+Login_Items.isManager+")";
				UserRegis(sql1);
			} 

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "�û����ݿ�����");
		}
	}
	// �û�ע�ᣬ�������ݿ�
	public  void UserRegis(String sql) throws SQLException {
		// ִ��
		int i = JDBC.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "ע��ʧ��", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
		}
	}
}
