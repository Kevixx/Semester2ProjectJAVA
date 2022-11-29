package GameApp.server.model.modelClasses;
import java.util.Date;

public class Order {

	private int orderId;
	private String status;
	private Date date;

	public Order(int orderId, String status, Date date) {
		this.orderId = orderId;
		this.status = status;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
