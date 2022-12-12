package GameApp.client.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ClientModelManagerFactory extends Subject
{
  void addUser(String email, String country, String address, String username, String password, boolean isAdmin) throws
      SQLException;
  Game readByID(int game_id) throws SQLException, RemoteException;
  ArrayList<Game> getAllGames()throws SQLException;
  void userEdit(User user);
  boolean checkEmail(String email);
  boolean login(String email, String password);
  User getLoggedUser(String email, String password);
  User getUser();
  ArrayList<User> getAllUsers()throws SQLException, RemoteException;
  User findUserByEmail(String email) ;
  void deleteUser(User user) throws SQLException, RemoteException;

  void setSelectedId(int id) throws SQLException, RemoteException;

  //TRANSACTION METHODS
  Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException, RemoteException;

  ArrayList<Game> getGamesByEmail(String email) throws SQLException, RemoteException;

  ArrayList<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException;

  void delete(Transaction transaction) throws SQLException, RemoteException;
  //TRANSACTION METHODS END

  int getSelectedPictureId() throws SQLException, RemoteException;
  void addGameToShoppingCart()throws SQLException, RemoteException;


  void removeGameFromShoppingCart(int id)throws SQLException, RemoteException;
  void removeGameFromShoppingCart(Game game) throws SQLException, RemoteException;

  void removeAllGamesFromCart()throws SQLException, RemoteException;


  ArrayList<Game> getAllGamesFromShoppingCart()throws SQLException, RemoteException;

  ArrayList<Game> getGamesByGenre(String genre) throws SQLException,RemoteException;
  ArrayList<Game> getGamesByTitle(String title) throws SQLException, RemoteException;

}
