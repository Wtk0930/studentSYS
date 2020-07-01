package sys.ldk.com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDemo;
import sys.ldk.com.view.Login;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class register extends JFrame{

	private JFrame frame;
	private JTextField username_text;
	private JTextField password_text;
	private JTextField email_text;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ע��ҳ��");;
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setIcon(new ImageIcon(register.class.getResource("/image/\u5B66\u751F\u7BA1\u7406-2.png")));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setIcon(new ImageIcon(register.class.getResource("/image/\u9501.png")));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 17));
		
		JLabel lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setIcon(new ImageIcon(register.class.getResource("/image/\u90AE\u7BB1.png")));
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 17));
		
		username_text = new JTextField();
		username_text.setColumns(10);
		
		password_text = new JTextField();
		password_text.setColumns(10);
		
		email_text = new JTextField();
		email_text.setColumns(10);
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			reg(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username_text.setText("");
				password_text.setText("");
				email_text.setText("");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel)
					.addGap(12)
					.addComponent(username_text, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel_1)
					.addGap(12)
					.addComponent(password_text, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel_2)
					.addGap(12)
					.addComponent(email_text, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(173)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(173)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(username_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(password_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(email_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addComponent(btnNewButton)
					.addGap(28)
					.addComponent(btnNewButton_1))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void reg(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = username_text.getText().toString();
		String password = password_text.getText().toString();
		String email = email_text.getText().toString();
		
		//�жϷǿ�
		if("".equals(username)||username == null){
			JOptionPane.showMessageDialog(this, "ע���˺Ų���Ϊ��");
			return;	
		}
		if("".equals(password)||password == null){
			JOptionPane.showMessageDialog(this, "ע�����벻��Ϊ��");
			return;	
		}
		if("".equals(email)||email == null){
			JOptionPane.showMessageDialog(this, "ע�����䲻��Ϊ��");
			return;	
		}
		
		
		Student s =  new Student();
		s.setName(username);
		s.setPassword(password);
        s.setEmail(email);
        
        //
        try {
			if(StudentDemo.addStudent(s) == 0)
				JOptionPane.showMessageDialog(this, "ע��ɹ�");
			else
				JOptionPane.showMessageDialog(this, "ע��ʧ��");
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block;
			e1.printStackTrace();
		}
        
        this.frame.setVisible(false);;
        Login log = new Login();
        log.getFrame().setVisible(true);
        
	}
	
	public JFrame getFrame() {
		return frame;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "ע��");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "����");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
}
