import java.util.ArrayList; // Import the File class
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

public class AccountManage {
	private boolean isLogin;
	private AccountList accountList;
	private AccountInfo accountInfo;
	// private ActivityLog logAct;

	public AccountManage() {
		isLogin = false;
		accountList = new AccountList();
		readFile();
	}

	public AccountManage(boolean isLogin, AccountList accountList) {
		super();
		this.isLogin = isLogin;
		this.accountList = accountList;
		readFile();
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

	public boolean checkAccount(String username, String password) {
		for (AccountInfo acc : accountList.getList()) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public boolean checkDisable(String username) {
		for (AccountInfo acc : accountList.getList()) {
			if (acc.getUsername().equals(username)) {
				return acc.isDisable();
			}
		}
		return false;
	}

	/*
	 * Error code: -1: The old password is incorrect. -2: Re-enter the new password
	 * isn't the same. -99: Unknown
	 */
	public void changePassword(String newPassword) {
		writeFile(newPassword);
		accountInfo.setPassword(newPassword);
		accountList = new AccountList();
		readFile();
	}

//	public int changePassword(String username, String oldPassword, String newPassword, String reenteredPassword) {
//		if (!newPassword.equals(reenteredPassword)) {
//			return -2; // Re-entered password doesn't match
//		}
//
//		for (AccountInfo info : accountList.getList()) {
//			if (info.getUsername().equals(username)) {
//				if (info.getPassword().equals(oldPassword)) {
//					info.setPassword(newPassword);
//					accountList = new AccountList();
//					readFile();
//					return 1; // Password changed successfully
//				} else {
//					return -1; // Incorrect old password
//				}
//			}
//		}
//		return -99; // Unknown error, username not found
//	}

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

			System.out.println("Login session saved successfully.");
		} catch (IOException e) {
			System.out.println("Login session saved failed.");
			e.printStackTrace();
		}
	}

	public boolean checkChangePassword(String username) {
		for (AccountInfo info : accountList.getList()) {
			if (info.getUsername().equals(username)) {
				return info.getChangePassword() == 1;
			}
		}
		return false;
	}

	public void readFile() {
		try {
			FileReader reader = new FileReader("src/account.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			System.out.println("==== Account List ===");
			while ((line = bufferedReader.readLine()) != null) {
				String[] getElement = line.split("#");

				String avatar = getElement[0];
				String fullname = getElement[1];
				String email = getElement[2];
				String phone = getElement[3];
				String type = getElement[4];
				String username = getElement[5];
				String password = getElement[6];
				boolean isDisable = getElement[7].equals("true");
				int changePassword = Integer.parseInt(getElement[8]);
				System.out.println(username + "\t" + password);
				AccountInfo account = new AccountInfo(avatar, fullname, email, phone, type, username, password,
						isDisable, changePassword);
				accountList.setObjToList(account);
			}
			System.out.println("======================");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeFile(String newPassword) {
		String fileName = "src/account.txt";
		String searchString = "#" + accountInfo.getPassword() + "#";
		String replacementString = "#" + newPassword + "#";
		String tempFileName = "src/account_temp.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(accountInfo.getUsername())) {
					// change password in file
					line = line.replace(searchString, replacementString);
					// disable password change on first login
					line = line.replace("#1", "#0");
				}
				writer.write(line);
				writer.newLine();
			}

			System.out.println("String replacement is complete.");

		} catch (IOException e) {
			System.out.println("An error occurred while processing the file.");
			e.printStackTrace();
		}

		// Replace the original file with the temporary file
		File originalFile = new File(fileName);
		File tempFile = new File(tempFileName);

		// Delete the original file
		if (originalFile.delete()) {
			System.out.println("Original file deleted successfully.");
		} else {
			System.out.println("Failed to delete the original file.");
			return; // Exit the method if deletion fails
		}

		// Rename the temporary file to the original file name
		if (tempFile.renameTo(originalFile)) {
			System.out.println("File update is complete.");
		} else {
			System.out.println("Failed to rename the temporary file.");
		}

	}

}
