import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountList {
	private ArrayList<AccountInfo> list;

	public AccountList() {
		list = new ArrayList<AccountInfo>();
		readFile();
	}

	public AccountList(ArrayList<AccountInfo> list) {
		super();
		this.list = list;
	}

	public ArrayList<AccountInfo> getList() {
		return list;
	}

	public void setList(ArrayList<AccountInfo> list) {
		this.list = list;
	}

	public void readFile() {
		try {
			FileReader reader = new FileReader("src/account.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] getElement = line.split("#");

				String avatar = getElement[0];
				String fullname = getElement[1];
				String email = getElement[2];
				String type = getElement[3];
				String username = getElement[4];
				String password = getElement[5];
				boolean isDisable = getElement[6].equals("true");

				AccountInfo account = new AccountInfo();
				account.setAccountInfo(avatar, fullname, email, type, username, password, isDisable);
				list.add(account);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AccountInfo getInfoUser(String username) {
		for (AccountInfo acc : list) {
			if (acc.getUsername().equals(username))
				return acc;
		}
		return new AccountInfo();
	}

	public boolean checkAccount(String username, String password) {
		for (AccountInfo acc : list) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public boolean checkDisable(String username) {
		for (AccountInfo acc : list) {
			if (acc.getUsername().equals(username)) {
				return acc.isDisable();
			}
		}
		return false;
	}

	/*
	 * Error code: 
	 * -1: The old password is incorrect. 
	 * -2: Re-enter the new password isn't the same.
	 * -99: Unknown
	 */
	public int changePassword(String username, String oldPassword, String newPassword, String reenteredPassword) {
	    if (!newPassword.equals(reenteredPassword)) {
	        return -2; // Re-entered password doesn't match
	    }

	    for (AccountInfo info : getList()) {
	        if (info.getUsername().equals(username)) {
	            if (info.getPassword().equals(oldPassword)) {
	                info.setPassword(newPassword);
	                return 1; // Password changed successfully
	            } else {
	                return -1; // Incorrect old password
	            }
	        }
	    }
	    return -99; // Unknown error, username not found
	}}
