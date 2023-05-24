import java.util.ArrayList; // Import the File class
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

public class AccountManage {
	private boolean isLogin;
	private AccountList accountList;
	private AccountInfo accountInfo;
//	private ActivityLog logAct;

	public AccountManage() {
		isLogin = false;
		accountList = new AccountList();
	}

	public AccountManage(boolean isLogin, AccountList accountList) {
		super();
		this.isLogin = isLogin;
		this.accountList = accountList;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public AccountList getAccountList() {
		return accountList;
	}

	public void setAccountList(AccountList accountList) {
		this.accountList = accountList;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public void saveSessionLogin(String username) {
		setAccountInfo(accountList.getInfoUser(username));
		try {
			FileWriter fileWriter = new FileWriter("src/infoLogin.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			String line = accountInfo.getAvatar() + "#" + accountInfo.getFullname() + "#" + accountInfo.getEmail() + "#"
					+ accountInfo.getType() + "#" + accountInfo.getUsername() + "#" + accountInfo.getPassword() + "#"
					+ accountInfo.isDisable();
			// Write data to the file
			bufferedWriter.write(line);

			// Close the writer
			bufferedWriter.close();

			System.out.println("Data has been written to the file successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}

}
