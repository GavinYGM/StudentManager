package Child_Interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Public.JDBC;
import Public.SaveName;

public class UpdatePassword extends JPanel{

	/**
	 * 修改密码界面
	 */
	private static final long serialVersionUID = 1L;
	Label newPassword = new Label("请输入新密码");
	Label confirmPass = new Label("再次确认新密码");
	TextField text_1 = new TextField();
	TextField text_2 = new TextField();
	Button confirmBtn = new Button("确定");
	JPanel jPanel=new JPanel();
	public UpdatePassword() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setSize(700, 520);
		jPanel.setLayout(null);
		jPanel.setBounds(205, 70, 255, 140);
		jPanel.setBackground(Color.green);
		newPassword.setBounds(20, 20, 90, 30);
		text_1.setBounds(115, 23, 120, 20);
		confirmPass.setBounds(20, 70, 90, 30);
		text_2.setBounds(115, 73, 120, 20);
		confirmBtn.setBounds(95, 110, 70, 25); // 确定按钮
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonPerformed(e);
			}
		});
		jPanel.add(newPassword);
		jPanel.add(confirmPass);
		jPanel.add(text_1);
		jPanel.add(text_2);
		jPanel.add(confirmBtn);
		add(jPanel);
		setVisible(true); // 使窗体可见
	}
	private void confirmButtonPerformed(ActionEvent e) {
		System.out.println(SaveName.login_user);
		String pass1 = text_1.getText();
		String pass2 = text_2.getText();
		// 如果两个密码输入框中有一个为空，则显示错误提示信息并返回
		if (pass1.equals("") || pass1.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空，请重新输入！");
			return;
		}
		// 如果两个密码输入框中输入的内容不一致，则显示错误提示信息并返回
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致，请重新输入！");
			text_1.setText("");
			text_2.setText("");
			return;
		}
		String sql = "update user set password='" + pass1
				+ "' where name='" + SaveName.login_user + "'";
		int i = JDBC.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "修改密码成功！");
			text_1.setText("");
			text_2.setText("");
		} else
			JOptionPane.showMessageDialog(null, "用户数据库有误或不存在，修改密码失败！");
	}

	
}
