package GameApp.server.model.modelClasses;

import java.util.ArrayList;

public class ShoppingCart{

	private ArrayList<Game> games;

	public ShoppingCart()
	{
		games = new ArrayList<>();
	}


	public ArrayList<Game> getGames()
	{
		return games;
	}

	public void addGame(Game game) {
		games.add(game);
	}

	public void removeGame(Game game)
	{
		games.remove(game);
	}

	public void clearCart()
	{
		games.clear();
	}

	public double getShoppingCartValue()
	{
		double value = 0;
		for (int i = 0; i < games.size(); i++)
		{
			value+= games.get(i).getGamePrice();
		}
		return value;
	}

	public boolean contains(Object obj)
	{
		if (obj instanceof Game)
		{
			Game temporary = (Game) obj;
			for (int i = 0; i < games.size(); i++)
			{
				if (temporary.getGameTitle().equals(games.get(i).getGameTitle())
						&& temporary.getGamePrice() == games.get(i).getGamePrice()
						&& temporary.getGameDescription().equals(games.get(i).getGameDescription())
						&& temporary.getGameGenre().equals(games.get(i).getGameGenre()))
				{
					return true;
				}
			}
		}
		return false;
	}

}
