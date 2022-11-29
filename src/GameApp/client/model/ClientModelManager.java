package GameApp.client.model;

import GameApp.client.network.Client;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

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
  public void addUser(String email, String country, String address, String username, String password) throws
      SQLException
  {
    client.addUser(new User(email, country, address, username, password));
  }

  @Override
  public void userEdit(User user) {
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
