import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountList {
	private ArrayList<AccountInfo> list;

	public AccountList() {
		list = new ArrayList<AccountInfo>();
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
	
	public void setObjToList(AccountInfo info)
	{
		list.add(info);
	}
	
	public AccountInfo getInfoUser(String username) {
		for (AccountInfo acc : list) {
			if (acc.getUsername().equals(username))
				return acc;
		}
		return new AccountInfo();
	}

}
