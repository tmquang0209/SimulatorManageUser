public class App {

	public static void main(String[] args) {
		AccountManage accountManage = new AccountManage();
		Login login = new Login(accountManage);
		System.out.println(accountManage.isLogin());
	}
}