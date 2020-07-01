package sys.ldk.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDemo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 24));
		
		JLabel lblNewLabel_2 = new JLabel("\u8D26\u53F7");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 19));
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		passwordText = new JTextField();
		passwordText.setColumns(10);
		
		JButton loginButton = new JButton("登入");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log();
			}
		});
		
		JButton registerButton = new JButton("注册");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    RegFrame reg = new RegFrame();
			    reg.setVisible(true);
			}
		});
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameText.setText("");
				passwordText.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(218)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(187)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addComponent(loginButton)
							.addGap(40)
							.addComponent(registerButton)
							.addGap(34)
							.addComponent(resetButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))))
					.addGap(111))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(13)
							.addComponent(lblNewLabel_1)
							.addGap(46)
							.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(registerButton)
							.addComponent(loginButton))
						.addComponent(resetButton)))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void log() {
		// TODO Auto-generated method stub
		String username = usernameText.getText().toString();
		String password = passwordText.getText().toString();
		if("".equals(username)||username == null){
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;	
		}
		if("".equals(password)||password == null){
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;	
		}
		

		Student s =  new Student();
		s.setName(username);
		s.setPassword(password);
		
		try {
			if(StudentDemo.searchStudent(s))
				JOptionPane.showMessageDialog(this, "登入成功");
			else{
				JOptionPane.showMessageDialog(this, "账号、密码错误,请重新输入");
				usernameText.setText("");
				passwordText.setText("");
			}
				
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
