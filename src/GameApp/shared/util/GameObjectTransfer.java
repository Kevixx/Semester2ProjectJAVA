package GameApp.shared.util;

import GameApp.server.database.GameDAOImpl;
import GameApp.server.model.modelClasses.Game;

import java.sql.SQLException;

public class GameObjectTransfer
{
  private static GameObjectTransfer instance;
  private Game selectedGame;

  private GameObjectTransfer() throws SQLException
  {
    selectedGame = GameDAOImpl.getInstance().readByID(1);
  }

  public static GameObjectTransfer getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new GameObjectTransfer();
    }
    return instance;
  }

  public void setSelectedGame(int gameId) throws SQLException
  {
    selectedGame = GameDAOImpl.getInstance().readByID(gameId);
  }

  public Game getSelectedGame()
  {
    return selectedGame;
  }
}
