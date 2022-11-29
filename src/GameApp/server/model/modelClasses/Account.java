package GameApp.server.model.modelClasses;

public class Account {

	private String userName;
	private User userId;
	private int accountId;

	public Account(String userName, User userId, int accountId) {
		this.userName = userName;
		this.userId = userId;
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}