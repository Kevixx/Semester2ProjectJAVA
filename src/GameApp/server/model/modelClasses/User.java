package GameApp.server.model.modelClasses;

import java.io.Serializable;

public class User implements Serializable {

	private String username;
	private String email;
	private String country;
	private String address;
	private String userId;

	private String password;
	private boolean isAdmin;

	//Adrian: added constructor for Andreea's database implementation because it was different from Saran's
	public User(String email, String country, String address, String username,
			String password, boolean isAdmin)
	{
		//Adrian: we had no username in this class - I have changed it to name for now to make it work
		this.username = username;
		this.email = email;
		this.country = country;
		this.address = address;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getUsername()
	{
		return username;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}
}
