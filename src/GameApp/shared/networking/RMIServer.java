package GameApp.shared.networking;

import GameApp.server.model.modelClasses.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIServer extends Remote
{

  void registerCallback(ClientCallback ccb) throws RemoteException;
  void addUser(User user) throws SQLException, RemoteException;
}
