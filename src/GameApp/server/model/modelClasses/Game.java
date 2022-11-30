package GameApp.server.model.modelClasses;

public class Game {

	private int game_id;
	private String title;

	private String genre;
	private String description;
	private double price;


	public Game(int game_id, String title,String genre, String description, double price) {

		this.game_id = game_id;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.price = price;
	}

	public int getGame_id() {
		return game_id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
