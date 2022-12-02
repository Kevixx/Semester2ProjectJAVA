package GameApp.shared.networking;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RMIServer extends Remote
{

  void registerCallback(ClientCallback ccb) throws RemoteException;
  void addUser(User user) throws SQLException, RemoteException;
  boolean checkEmail(String email) throws SQLException, RemoteException;
   Game readByID(int game_id) throws SQLException, RemoteException;

  public ArrayList<Game> getAllGames() throws RemoteException, SQLException;

    boolean login(String email, String password) throws RemoteException, SQLException;
}
