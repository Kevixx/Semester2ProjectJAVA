package GameApp.server.model.modelClasses;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String lastName;
	private String email;
	private String country;
	private String address;
	private String userId;
	private String dateOfBirth;
	private String password;
	private String phoneNumber;

	//Adrian: please fix functionality between user and account because it seems to overlap
	public User(String name, String lastName, String email, String country, String address, String userId, String dateOfBirth, String password, String phoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.address = address;
		this.userId = userId;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	//Adrian: added constructor for Andreea's database implementation because it was different from Saran's
	public User(String email, String country, String address, String username,
			String password)
	{
		//Adrian: we had no username in this class - I have changed it to name for now to make it work
		this.name = username;
//		this.username = username;
		this.email = email;
		this.country = country;
		this.address = address;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
