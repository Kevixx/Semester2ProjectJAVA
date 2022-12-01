package GameApp.server.model;

import GameApp.server.database.GameDAO;
import GameApp.server.database.GameDAOImpl;
import GameApp.server.model.modelClasses.Game;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelManager implements ServerModelManagerFactory {
  private PropertyChangeSupport support;

  //Constructor
  public ServerModelManager() {
    support = new PropertyChangeSupport(this);
  }


  public ArrayList<Game> getAllGames() throws SQLException {
    return GameDAOImpl.getInstance().getAllGames();
  }

  public Game readByID(int game_id) throws SQLException {
    return GameDAOImpl.getInstance().readByID(game_id);
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
}
