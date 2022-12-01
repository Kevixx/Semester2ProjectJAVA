package GameApp.server.networking;

import GameApp.server.model.ServerModelManager;
import GameApp.server.model.UserServerModelManager;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.networking.ClientCallback;
import GameApp.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  private ServerModelManager serverModelManager;

  //Adrian: I still think it is pointless to have another model manager for now.
  //Maybe later when we will have a dozens of methods in model manager it would be wise to split it between a few classes.
  private UserServerModelManager userServerModelManager;

  public RMIServerImpl(ServerModelManager serverModelManager, UserServerModelManager userServerModelManager)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 2910);
    this.serverModelManager = serverModelManager;
    this.userServerModelManager = userServerModelManager;
  }

  public void startServer()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(2910);
      registry.bind("ShopServer", this);
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void registerCallback(ClientCallback ccb)
      throws RemoteException
  {
    //what listener?
    serverModelManager.addListener("NewChatEntry", evt -> {
      try
      {
        //maybe some transfer object here?
        ccb.update((String) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    });
  }

  public void addUser(User user){
    try {
      userServerModelManager.addUser(user);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("User added successfully");
  }

  public boolean checkEmail(String email)  {

    try {
      return userServerModelManager.checkEmail(email);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public Game readByID(int game_id)
  {
    return serverModelManager.readByID(game_id);
  }

  public ArrayList<Game> getAllGames() throws SQLException {
    return serverModelManager.getAllGames();
  }
}