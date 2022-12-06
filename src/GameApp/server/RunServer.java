package GameApp.server;

import GameApp.server.model.ServerModelManager;
import GameApp.server.model.TransactionServerModelManager;
import GameApp.server.model.UserServerModelManager;
import GameApp.server.networking.RMIServerImpl;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, SQLException {

    RMIServerImpl server = new RMIServerImpl(new ServerModelManager(), new UserServerModelManager(), new TransactionServerModelManager());
    server.startServer();
  }
}
