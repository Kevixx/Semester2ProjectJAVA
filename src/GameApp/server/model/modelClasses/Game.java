package GameApp.server.model.modelClasses;

public class Game {

	private String gameName;
	private String description;
	private int gameId;

	public Game(String gameName, String description, int gameId) {
		this.gameName = gameName;
		this.description = description;
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
