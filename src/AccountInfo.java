import java.util.ArrayList;

public class AccountInfo {

	private String avatar;
	private String fullname;
	private String email;
	private String phone;
	private String type;
	private String username;
	private String password;
	private boolean isDisable;
	private int changePassword;

	public AccountInfo() {
		
	}

	public AccountInfo(String avatar, String fullname, String email, String phone, String type, String username, String password, boolean isDisable, int changePassword) {
		super();
		this.avatar = avatar;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.username = username;
		this.password = password;
		this.isDisable = isDisable;
		this.changePassword = changePassword;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisable() {
		return isDisable;
	}

	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

	public int getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(int changePassword) {
		this.changePassword = changePassword;
	}
}
