import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {
//	private AccountList accountList;

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private JLabel lblTest;
	private JPanel contentPane;
	private AccountManage accountManage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
//		accountManage = new AccountManage();
//		AccountList accountList = accountManage.getAccountList();
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(150, 50, 800, 600);
//		setResizable(false);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Login", SwingConstants.CENTER);
//		lblNewLabel.setForeground(Color.BLACK);
//		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
//		lblNewLabel.setBounds(0, 11, 786, 93);
//		contentPane.add(lblNewLabel);
//
//		textField = new JTextField();
//		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
//		textField.setBounds(294, 166, 450, 50);
//		contentPane.add(textField);
//		textField.setColumns(10);
//
//		passwordField = new JPasswordField();
//		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
//		passwordField.setBounds(294, 286, 450, 50);
//		contentPane.add(passwordField);
//
//		JLabel lblUsername = new JLabel("Username");
//		lblUsername.setBackground(Color.BLACK);
//		lblUsername.setForeground(Color.BLACK);
//		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
//		lblUsername.setBounds(70, 166, 226, 50);
//		contentPane.add(lblUsername);
//
//		JLabel lblPassword = new JLabel("Password");
//		lblPassword.setForeground(Color.BLACK);
//		lblPassword.setBackground(Color.CYAN);
//		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
//		lblPassword.setBounds(70, 286, 226, 50);
//		contentPane.add(lblPassword);
//
//		btnNewButton = new JButton("Login");
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
//		btnNewButton.setBounds(320, 410, 147, 52);
//		btnNewButton.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				String username = textField.getText();
//				String password = passwordField.getText();
//				if (username.isEmpty() || password.isEmpty()) {
//					JOptionPane.showMessageDialog(btnNewButton, "Vui lòng nhập đủ thông tin.");
//				} else if (!accountList.checkAccount(username, password)) {
//					JOptionPane.showMessageDialog(btnNewButton, "Tài khoản hoặc mật khẩu không chính xác.");
//				} else if (accountList.checkDisable(username)) {
//					JOptionPane.showMessageDialog(btnNewButton, "Tài khoản đã bị vô hiệu hóa");
//				} else {
//					JOptionPane.showMessageDialog(btnNewButton, "Đăng nhập thành công");
//
//					accountManage.saveSessionLogin(username);
//					// Create an instance of the Home class
//					Home home = new Home();
//
//					// Close the existing login frame
//					dispose();
//
//					// Show the Home frame
//					home.setVisible(true);
//				}
//				// if set password change on first login => redirect to password change form
//			}
//		});
//
//		contentPane.add(btnNewButton);
//		setVisible(true);
	}

	public Login(AccountManage accountManage) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login", SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(0, 11, 786, 93);
		contentPane.add(lblNewLabel);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		usernameField.setBounds(294, 166, 450, 50);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(294, 286, 450, 50);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(70, 166, 226, 50);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(70, 286, 226, 50);
		contentPane.add(lblPassword);

		btnSubmit = new JButton("Login");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnSubmit.setBounds(320, 410, 147, 52);
		
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(btnSubmit, "Vui lòng nhập đủ thông tin.");
				} else if (!accountManage.checkAccount(username, password)) {
					JOptionPane.showMessageDialog(btnSubmit, "Tài khoản hoặc mật khẩu không chính xác.");
				} else if (accountManage.checkDisable(username)) {
					JOptionPane.showMessageDialog(btnSubmit, "Tài khoản đã bị vô hiệu hóa");

				} else {
					accountManage.setLogin(true);
					accountManage.saveSessionLogin(username);
					if (accountManage.checkChangePassword(username)) {
						JOptionPane.showMessageDialog(btnSubmit, "Bạn cần thay đổi mật khẩu");
						ChangePassword changePw = new ChangePassword(accountManage);
						changePw.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(btnSubmit, "Đăng nhập thành công");
						// Create an instance of the Home class
						Home home = new Home(accountManage);
						home.setVisible(true);
					}

					// Close the existing login frame
					dispose();

					// Show the Home frame
				}
			}
		});

		contentPane.add(btnSubmit);
		setVisible(true);
		System.out.println(123);
	}
}
