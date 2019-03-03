package Login;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main_Interface.User_Interface;
import Public.JDBC;
import Public.SaveName;

public class User_Login extends JFrame{
	/**
	 * 用户登录界面
	 */
	private static final long serialVersionUID = 1L;
	TextField text_pass = new TextField();
	TextField text_user = new TextField();
	
	public User_Login() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		this.setTitle("用户登录");
		this.setLayout(null);
		this.setSize(400, 300);
		/* 添加标签与文本框 */
		Label lbUser = new Label("用户名：");
		Label lbPass = new Label("密    码：");
		lbUser.setFont((new Font("宋体", Font.BOLD, 20)));
		lbPass.setFont((new Font("宋体", Font.BOLD, 20)));
		lbUser.setBounds(60, 50, 75, 40);
		lbPass.setBounds(60, 100, 75, 40);		
		

		text_user.setFont((new Font("宋体", Font.BOLD, 23)));
		text_pass.setFont((new Font("宋体", Font.BOLD, 23)));
		text_user.setBounds(135, 55, 180, 30);
		text_pass.setBounds(135, 103, 180, 30);
		
		
		Button btn_ok = new Button("登录");
		Button btn_cancel = new Button("取消");
		Button btn_register=new Button("注册");
		btn_ok.setBounds(145, 170, 80, 25); // 确定按钮
		btn_cancel.setBounds(245, 170, 80, 25);//取消按钮
		btn_register.setBounds(45, 170, 80, 25);
		
		add(lbUser);
		add(lbPass);
		add(text_user);
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
				Login_Items.isManager=2;
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
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		this.setVisible(true); // 使窗体可见
	}
	public void btn_okActionPerformed(ActionEvent e) {
		String user = text_user.getText();
		String pass = text_pass.getText();
		
		// 如果用户名或密码任一为空，则终止后续操作
		if (user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
			return;
		}
		try {
			// 核对用户名和密码
			String sql = "select * from user where name="+ "'"+user
					+ "'and password='" +pass+"'";
			ResultSet rs = JDBC.executeQuery(sql);
			
			if (rs.next()&&rs.getInt(4)==2) {
				JOptionPane.showMessageDialog(null, "用户登录成功！");
				SaveName.login_user = user; // 记录登录的用户名
				dispose();
				new User_Interface();
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
				this.text_user.setText("");
				this.text_pass.setText("");
				return;
			}	

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "用户数据库有误！");
		}
	}
	public void btn_registerActionPerformed(ActionEvent e) {
		new Register();
		//dispose();
	}
}
