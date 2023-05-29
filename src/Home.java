import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Home", SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblTitle.setBounds(10, 11, 452, 93);
		contentPane.add(lblTitle);

		JLabel lblFullname = new JLabel("Hello, ");
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFullname.setBounds(472, 11, 314, 36);
		contentPane.add(lblFullname);
		
		displayForAdmin();
	}

	public Home(AccountManage accountManage) {
		AccountInfo info = accountManage.getAccountInfo();
		
		System.out.println(accountManage.isLogin());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Home", SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblTitle.setBounds(10, 11, 452, 93);
		contentPane.add(lblTitle);

		JLabel lblFullname = new JLabel("Hello, " + info.getFullname());
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFullname.setBounds(472, 11, 314, 36);
		contentPane.add(lblFullname);

		if(info.getType().equals("administrator")) {
			displayForAdmin();
		}else if(info.getType().equals("security")) {
			
		}else if(info.getType().equals("standard_user")) {
			
		}
	}

	private void displayForAdmin() {
		JButton btnAccountManage = new JButton("Quản lý tài khoản");
		btnAccountManage.setBounds(434, 113, 270, 100);
		btnAccountManage.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnAccountManage);

		JButton btnActLog = new JButton("Quản lý hoạt động");
		btnActLog.setBounds(82, 240, 270, 100);
		btnActLog.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnActLog);

		JButton btnLogout = new JButton("Đăng xuất");
		btnLogout.setBounds(434, 240, 270, 100);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnLogout);
		
		JButton btnAccountInfo = new JButton("Thông tin tài khoản");
		btnAccountInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAccountInfo.setBounds(82, 115, 270, 100);
		contentPane.add(btnAccountInfo);

		/*
		 * Hiện thị bảng menu: + Quản lý người dùng (Sửa, xóa, phân quyền). + Quản lý
		 * hoạt động của người dùng
		 */

	}
}
