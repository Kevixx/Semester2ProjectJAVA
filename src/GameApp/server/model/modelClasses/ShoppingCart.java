package GameApp.server.model.modelClasses;

import java.util.ArrayList;

public class ShoppingCart{

	private ArrayList<Game> games;

	public ShoppingCart()
	{
		games = new ArrayList<>();
	}

	public void addGame(int GameId) {
	}

	public void removeGame(int GameId) {
	}

	public double getShoppingCartvalue()
	{
		double value = 0;
		for (int i = 0; i < games.size(); i++)
		{
			value+= games.get(i).getGamePrice();
		}
		return value;
	}

}
