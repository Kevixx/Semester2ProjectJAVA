package GameApp.server.model.modelClasses;

public class Payment {

	private double total;
	private String details;
	private String cardNumber;
	private User user;

	public Payment(double total, String details, String cardNumber, User user) {
		this.total = total;
		this.details = details;
		this.cardNumber = cardNumber;
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
