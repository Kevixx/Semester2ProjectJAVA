package GameApp.client.model;

import GameApp.client.network.Client;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ClientModelManager implements ClientModelManagerFactory
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;

  public ClientModelManager(Client client) {
    this.client = client;
    client.startClient();
//    client.addListener("NewChatEntry", this::onNewLogEntry);
  }

  @Override
  public void addUser(String email, String country, String address, String username, String password, boolean isAdmin) throws
      SQLException
  {
    client.addUser(new User(email, country, address, username, password, isAdmin));
  }

  @Override
  public List<Game> getAllGames() throws SQLException {
    return client.getAllGames();
  }

  public Game readByID(int game_id) throws SQLException, RemoteException {
    return client.readByID(game_id);
  }


  @Override
  public void userEdit(User user) {
    try {
      client.editUser(user);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  public boolean checkEmail(String email)
  {
    return client.checkEmail(email);
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
  public boolean login(String email, String password) {
    return client.login(email, password);
  }

  public User getLoggedUser(String email, String password)  {
    support.firePropertyChange("UserLoggedIn", null, 1);
    try {
      return client.getLoggedUser(email, password);
    } catch (SQLException | RemoteException e) {
    e.printStackTrace();
    }
    return null;
  }

  @Override
  public User getUser()
  {
    return client.getUser();
  }
}
