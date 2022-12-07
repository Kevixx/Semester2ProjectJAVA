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
  List<Game> getAllGames()throws SQLException;
  void userEdit(User user);
  boolean checkEmail(String email);
  boolean login(String email, String password);
  User getLoggedUser(String email, String password);
  User getUser();

  //TRANSACTION METHODS
  Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException, RemoteException;

  ArrayList<Game> getGamesIdsByEmail(String email) throws SQLException, RemoteException;

  ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException, RemoteException;

  void delete(Transaction transaction) throws SQLException, RemoteException;
  //TRANSACTION METHODS END
}
