package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Client extends Subject
{
  void startClient();
  void addUser(User user);
  boolean checkEmail(String email);
   Game readByID(int game_id) throws SQLException, RemoteException;

   User findUserByEmail(String email);
   User getUser();
    void editUser(User user) throws SQLException, RemoteException;

    ArrayList<Game> getAllGames();
    boolean login(String email, String password);

    User getLoggedUser(String email, String password) throws SQLException, RemoteException;
    List<User> getAllUsers() throws SQLException, RemoteException;
    void deleteUser(User user)throws SQLException, RemoteException;



    //TRANSACTION METHODS
    Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException, RemoteException;

    ArrayList<Game> getGamesIdsByEmail(String email) throws SQLException, RemoteException;

    ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException, RemoteException;

    void delete(Transaction transaction) throws SQLException, RemoteException;
    //TRANSACTION METHODS END

 public void addGameToShoppingCart(int game_id)throws SQLException, RemoteException;


 public void removeGameFromShoppingCart(int game_id)throws SQLException, RemoteException;


 public void removeAllGamesFromCart()throws SQLException, RemoteException;


 ArrayList<Game> getAllGamesFromShoppingCart()throws SQLException, RemoteException;

}
