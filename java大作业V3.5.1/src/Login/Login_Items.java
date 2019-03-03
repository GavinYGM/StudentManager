package Login;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import Public.JDBC;

public class Login_Items extends JFrame{

	/**
	 * 登录选择界面：用来选择进入用户界面还是管理员界面
	 */
	public static int isManager=1;//判断是否为管理员
	
	private static final long serialVersionUID = 1L;
	public Login_Items() {
		// TODO Auto-generated constructor stub
		Button Manager_btn=new Button("管理员登录");
		Button User_btn=new Button("用户登录");
		Label Title_label=new Label("学生信息管理系统");
		this.setTitle("登录选择");
		this.setLayout(null);
		this.setSize(400, 300);
		Title_label.setFont((new Font("宋体", Font.BOLD, 30)));
		Manager_btn.setFont((new Font("宋体", Font.BOLD, 20)));
		User_btn.setFont(new Font("宋体", Font.BOLD, 20));
		Title_label.setBounds(60, 40, 250, 30);
		Manager_btn.setBounds(120, 100, 130, 35);
		User_btn.setBounds(120, 145, 130, 35);
		add(Title_label);
		add(Manager_btn);
		add(User_btn);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JDBC.Close();
				System.exit(0);
			}
		});
		Manager_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager_ActionPerformed(e);
			}
		});
		User_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user_ActionPerformed(e);
			}
		});
		
	}
	public void manager_ActionPerformed(ActionEvent e) {
		dispose();
		new Manager_Login();
	}
	public void user_ActionPerformed(ActionEvent e) {
		dispose();
		new User_Login();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login_Items();
	}

}
