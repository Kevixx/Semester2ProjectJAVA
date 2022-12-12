package GameApp.client.model;

import GameApp.client.network.Client;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientModelManager implements ClientModelManagerFactory
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  private int selectedPictureId;

  public ClientModelManager(Client client) {
    this.client = client;
    client.startClient();
//    client.addListener("NewImageClicked", this::onNewImageClicked);
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
    } catch (SQLException | RemoteException e) {
      e.printStackTrace();
    }
  }

    public boolean checkEmail(String email) {
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

    public void setSelectedId(int id)
    {
      this.selectedPictureId = id;
      support.firePropertyChange("NewPictureSelected", null, selectedPictureId);
    }

    public int getSelectedPictureId()
    {
        return selectedPictureId;
    }

    @Override
    public void addGameToShoppingCart() throws SQLException, RemoteException {
        client.addGameToShoppingCart(selectedPictureId);
        support.firePropertyChange("NewItemInShoppingCart", null, 1);
    }

    @Override
    public void removeGameFromShoppingCart(int id) throws SQLException, RemoteException {
    client.removeGameFromShoppingCart(id);
    }

  public void removeGameFromShoppingCart(Game game) throws SQLException, RemoteException {
    client.removeGameFromShoppingCart(game);
    support.firePropertyChange("ItemDeletedFromShoppingCart", null, 1);
  }

    @Override
    public void removeAllGamesFromCart() {
    client.removeAllGamesFromCart();
    }

    @Override
    public ArrayList<Game> getAllGamesFromShoppingCart() throws SQLException, RemoteException {
        return client.getAllGamesFromShoppingCart();
    }

  @Override
  public List<Game> getGamesByGenre(String genre) throws SQLException, RemoteException {
    return client.getGamesByGenre(genre);
  }

  @Override
  public List<Game> getGamesByTitle(String title) throws SQLException, RemoteException {
    return client.getGamesByTitle(title);
  }

  public boolean login(String email, String password) {
        return client.login(email, password);
    }

    public User getLoggedUser(String email, String password) {
        support.firePropertyChange("UserLoggedIn", null, 1);
        try {
            return client.getLoggedUser(email, password);
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser() {
        return client.getUser();
    }

    @Override
    public List<User> getAllUsers() throws SQLException, RemoteException {
        return client.getAllUsers();
    }

    public User findUserByEmail(String email)
    {
        return client.findUserByEmail(email);
    }

    public void deleteUser(User user) throws SQLException, RemoteException {

            client.deleteUser(user);

    }
    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException {

      support.firePropertyChange("TransactionMade", null, 1);

        return client.create(usersEmail, games);
    }

    @Override
    public List<Game> getGamesByEmail(String email) throws SQLException, RemoteException {
        return client.getGamesByEmail(email);
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException {
        return client.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException, RemoteException {
        client.delete(transaction);
    }

  @Override
  public List<Transaction> getAllTransactions() throws SQLException, RemoteException {
    return client.getAllTransactions();
  }

  @Override
  public List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException {
    return client.getAllTransactionsByEmail(email);
  }

  @Override
  public Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException {
    return client.getTransactionByTransactionId(transactionId);
  }
  //TRANSACTION METHODS END
}
