package GameApp.server.model.modelClasses;

import java.util.ArrayList;

public class Game
{

	private int gameId;
	private String gameTitle;
	private ArrayList<String> gameGenre;
	private String gameDescription;
	private double gamePrice;

	public Game(int gameId, String gameTitle, String gameGenre, String gameDescription, double gamePrice)
	{

		this.gameId = gameId;
		this.gameTitle = gameTitle;

		this.gameGenre = new ArrayList<>();
		this.gameGenre.add(gameGenre);

		this.gameDescription = gameDescription;
		this.gamePrice = gamePrice;
	}

	//Constructor for a case when we create a new game and add it to database (gameId should be generated in DB) ~ Adrian
	public Game(String gameTitle, String gameGenre, String gameDescription, double gamePrice)
	{

		this.gameTitle = gameTitle;

		this.gameGenre = new ArrayList<>();
		this.gameGenre.add(gameGenre);

		this.gameDescription = gameDescription;
		this.gamePrice = gamePrice;
	}

	public int getGameId()
	{
		return gameId;
	}

	public String getGameTitle()
	{
		return gameTitle;
	}

	//for now just to have one genre
	public String getGameGenre()
	{
		return gameGenre.get(0);
	}

	public ArrayList<String> getGameGenres()
	{
		return gameGenre;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public double getGamePrice()
	{
		return gamePrice;
	}

	//We should not be able to do it ~ Adrian
//	public void setGameId(int gameId) {
//		this.gameId = gameId;
//	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public void setGameGenre(String gameGenre)
	{
		this.gameGenre.set(0, gameGenre);
	}

	public void setGameDescription(String gameDescription)
	{
		this.gameDescription = gameDescription;
	}

	public void setGamePrice(double gamePrice)
	{
		this.gamePrice = gamePrice;
	}

	public String getPictureURL()
	{
		String pictureURL = "GameApp/client/views/styles/images/" + gameId + ".JPG";
		return pictureURL;
	}
}






