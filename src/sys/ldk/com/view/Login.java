package sys.ldk.com.view;

import java.awt.EventQueue;

import sys.ldk.com.entity.Student;
import sys.ldk.com.view.register;
import sys.ldk.com.model.StudentDemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField username_text;
	private JTextField password_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("学生管理系统");
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/\u5B66\u751F\u7BA1\u7406-2.png")));
		
		username_text = new JTextField();
		username_text.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/\u9501.png")));
		
		password_text = new JTextField();
		password_text.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log();
			}
		});
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.dispose();
			    register reg = new register();
			    reg.getFrame().setVisible(true);
		        
			}
		});
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username_text.setText("");
				password_text.setText("");
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("学生管理系统");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/\u5B66\u751F\u7BA1\u7406-1.png")));
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 24));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addComponent(username_text, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(password_text, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(username_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(password_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void log() {
		// TODO Auto-generated method stub
		String username = username_text.getText().toString();
		String password = password_text.getText().toString();
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
				username_text.setText("");
				password_text.setText("");
			}
				
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
