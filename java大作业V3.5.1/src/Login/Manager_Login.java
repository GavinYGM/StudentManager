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

import Main_Interface.Manager_Interface;
import Public.JDBC;
import Public.SaveName;

public class Manager_Login extends JFrame{

	/**
	 * ����Ա��¼
	 */
	JTextField text_pass = new JTextField();
	JTextField text_manager = new JTextField();
	private static final long serialVersionUID = 1L;
	public Manager_Login() {
		// TODO Auto-generated constructor stub
		this.setTitle("����Ա��¼");
		this.setLayout(null);
		this.setSize(400, 300);
		/* ��ӱ�ǩ���ı��� */
		Label lbManager = new Label("����Ա��");
		Label lbPass = new Label("��    �룺");
		lbManager.setFont((new Font("����", Font.BOLD, 20)));
		lbPass.setFont((new Font("����", Font.BOLD, 20)));
		lbManager.setBounds(60, 50, 75, 40);
		lbPass.setBounds(60, 100, 75, 40);		
		

		text_manager.setFont((new Font("����", Font.BOLD, 23)));
		text_pass.setFont((new Font("����", Font.BOLD, 23)));
		text_manager.setBounds(135, 55, 180, 30);
		text_pass.setBounds(135, 103, 180, 30);
	
		
		Button btn_ok = new Button("��¼");
		Button btn_cancel = new Button("ȡ��");
		Button btn_register=new Button("ע��");
		btn_ok.setBounds(145, 170, 80, 25); // ȷ����ť
		btn_cancel.setBounds(245, 170, 80, 25);//ȡ����ť
		btn_register.setBounds(45, 170, 80, 25);
		
		add(lbManager);
		add(lbPass);
		add(text_manager);
		add(text_pass);
		add(btn_ok);
		add(btn_cancel);
		add(btn_register);
		
		btn_ok.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_okActionPerformed(e);
			}
		});
		btn_cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDBC.Close();
				System.exit(0);
			}
		});
		btn_register.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login_Items.isManager=1;
				btn_registerActionPerformed(e);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JDBC.Close();
				System.exit(0);
			}
		});
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		this.setVisible(true); // ʹ����ɼ�
	}
	public void btn_registerActionPerformed(ActionEvent e) {
		new Register();
		//dispose();
	}
	public void btn_okActionPerformed(ActionEvent e) {
		String user = text_manager.getText();
		String pass = text_pass.getText();
		
		// ����û�����������һΪ�գ�����ֹ��������
		if (user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�");
			return;
		}
		try {
			// �˶��û���������
			String sql = "select * from user where name='"+user
					+ "'and password='" +pass+"'";
			ResultSet rs = JDBC.executeQuery(sql);
			
			if (rs.next()&&rs.getInt(4)==1) {
				JOptionPane.showMessageDialog(null, "����Ա��¼�ɹ���");
				SaveName.login_user = user; // ��¼��¼���û���
				dispose();
				new Manager_Interface();
			} else {
				JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��");
				this.text_manager.setText("");
				this.text_pass.setText("");
				return;
			}	

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "�û����ݿ�����");
		}

	}
}
