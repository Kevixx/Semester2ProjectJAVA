package GameApp.server;

import GameApp.server.model.ServerModelManager;
import GameApp.server.model.UserServerModelManager;
import GameApp.server.networking.RMIServerImpl;

import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException
  {

    RMIServerImpl server = new RMIServerImpl(new ServerModelManager(), new UserServerModelManager());
    server.startServer();
  }
}
