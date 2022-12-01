package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Client extends Subject
{
  void startClient();
  void addUser(User user);
  boolean checkEmail(String email);
   Game readByID(int game_id) throws SQLException, RemoteException;

  ArrayList<Game> getAllGames();
}
