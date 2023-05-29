import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField oldPassword;
	private JTextField newPassword;
	private JTextField reNewPassword;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblReNewPassword;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {

	}

	public ChangePassword(AccountManage accountManage) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Change Password", SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblTitle.setBounds(10, 11, 452, 93);
		contentPane.add(lblTitle);

		oldPassword = new JPasswordField();
		oldPassword.setBounds(300, 189, 450, 50);
		oldPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(oldPassword);
		oldPassword.setColumns(10);

		newPassword = new JPasswordField();
		newPassword.setBounds(300, 269, 450, 50);
		newPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(newPassword);
		newPassword.setColumns(10);

		reNewPassword = new JPasswordField();
		reNewPassword.setBounds(300, 347, 450, 50);
		reNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
		reNewPassword.setColumns(10);
		contentPane.add(reNewPassword);

		lblOldPassword = new JLabel("Mật khẩu cũ ");
		lblOldPassword.setBackground(Color.BLACK);
		lblOldPassword.setForeground(Color.BLACK);
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblOldPassword.setBounds(36, 189, 260, 50);
		contentPane.add(lblOldPassword);

		lblNewPassword = new JLabel("Mật khẩu mới");
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewPassword.setBackground(Color.BLACK);
		lblNewPassword.setBounds(36, 269, 260, 50);
		contentPane.add(lblNewPassword);

		lblReNewPassword = new JLabel("Nhập lại mật khẩu");
		lblReNewPassword.setForeground(Color.BLACK);
		lblReNewPassword.setBackground(Color.CYAN);
		lblReNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblReNewPassword.setBackground(Color.BLACK);
		lblReNewPassword.setBounds(36, 347, 254, 50);
		contentPane.add(lblReNewPassword);

		btnSubmit = new JButton("Đổi mật khẩu");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnSubmit.setBounds(261, 438, 206, 52);
		contentPane.add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String oldPw = oldPassword.getText();
				String newPw = newPassword.getText();
				String reNewPw = reNewPassword.getText();

				boolean hasUppercase = !newPw.equals(newPw.toLowerCase());
				boolean hasSpecialCharacter = !newPw.matches("[A-Za-z0-9]*");

				if (oldPw.isEmpty() || newPw.isEmpty() || reNewPw.isEmpty()) {
				    JOptionPane.showMessageDialog(btnSubmit, "Vui lòng nhập đủ thông tin.");
				} else if (!newPw.equals(reNewPw)) {
				    JOptionPane.showMessageDialog(btnSubmit, "Mật khẩu nhập lại không chính xác.");
				} else if (!hasUppercase || !hasSpecialCharacter) {
				    JOptionPane.showMessageDialog(btnSubmit, "Mật khẩu mới phải có ít nhất một chữ hoa và một ký tự đặc biệt.");
				} else if (newPw.length() < 8){
					JOptionPane.showMessageDialog(btnSubmit, "Độ dài mật khẩu tối thiểu 8 ký tự.");					
				} else {
				    AccountInfo info = accountManage.getAccountInfo();
				    if (!oldPw.equals(info.getPassword())) {
				        JOptionPane.showMessageDialog(btnSubmit, "Mật khẩu cũ không đúng.");
				    } else {
				    	accountManage.changePassword(newPw);
				    	
				        JOptionPane.showMessageDialog(btnSubmit, "Đổi mật khẩu thành công.");
				        Home home = new Home(accountManage);
						home.setVisible(true);
						
						dispose();
				    }
				}
			}
		});
	}
}
