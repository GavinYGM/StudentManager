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
	 * 账号注册界面
	 */
	private static final long serialVersionUID = 1L;
	JTextField text_pass = new JTextField();
	JTextField text_num = new JTextField();
	public Register() {
		// TODO Auto-generated constructor stub
		this.setTitle("账号注册");
		this.setSize(400, 300);
		this.setLayout(null);
		/* 添加标签与文本框 */
		Label lbNum = new Label("账    号：");
		Label lbPass = new Label("密    码：");
		lbNum.setFont((new Font("宋体", Font.BOLD, 20)));
		lbPass.setFont((new Font("宋体", Font.BOLD, 20)));
		lbNum.setBounds(60, 50, 75, 40);
		lbPass.setBounds(60, 100, 75, 40);		
		

		text_num.setFont((new Font("宋体", Font.BOLD, 23)));
		text_pass.setFont((new Font("宋体", Font.BOLD, 23)));
		text_num.setBounds(135, 55, 180, 30);
		text_pass.setBounds(135, 103, 180, 30);
		
		text_num.setToolTipText("必须为3-6位字母_或者数字");
		text_pass.setToolTipText("密码必须为6位字母_或者数字");
		
		Button btn_cancel = new Button("取消");
		Button btn_register=new Button("注册");

		btn_cancel.setBounds(220, 170, 80, 25);//取消按钮
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
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		this.setVisible(true); // 使窗体可见
		
	}
	public void btn_registerActionPerformed(ActionEvent e) {
		String num="\\w{3,6}"; //用户名必须是3-6位
		boolean flag1=text_num.getText().matches(num);
		String pwd="\\w{6}"; //密码必须是6位
		boolean flag2=text_pass.getText().matches(pwd);

		if(flag1==false)
		{
			JOptionPane.showMessageDialog(null, "账号填写错误,必须为3-6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
			text_num.setText("");
		}else if(flag2==false)
		{
			JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
			text_pass.setText("");
		}else {
			zhuceVerify(text_num.getText());
		}
		
	}
	public void zhuceVerify(String num) {
		try {
			// 检查用户名是否存在
			String sql = "select * from user where name="+ "'"+num+"'";
			ResultSet rs = JDBC.executeQuery(sql);
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
				text_num.setText("");
				text_pass.setText("");
			}else {
				String name=text_num.getText();
				String pwd=text_pass.getText();
				String sql1="insert into user values(null,'"+name+"','"+pwd+"',"+Login_Items.isManager+")";
				UserRegis(sql1);
			} 

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "用户数据库有误！");
		}
	}
	// 用户注册，更新数据库
	public  void UserRegis(String sql) throws SQLException {
		// 执行
		int i = JDBC.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "注册成功", "提示消息", JOptionPane.WARNING_MESSAGE);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "注册失败", "提示消息", JOptionPane.ERROR_MESSAGE);
		}
	}
}
