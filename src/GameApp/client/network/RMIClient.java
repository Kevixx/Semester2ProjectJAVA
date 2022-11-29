package GameApp.client.network;

import GameApp.server.model.modelClasses.User;
import GameApp.shared.networking.ClientCallback;
import GameApp.shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  public PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    Registry registry = null;
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      registry = LocateRegistry.getRegistry("localhost", 2910);
      server = (RMIServer) registry.lookup("ShopServer");
      //Not sure if we need callback functionality
      server.registerCallback(this);
    } catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update(String entry) throws RemoteException
  {
    //in case we need to fire events, change name
    support.firePropertyChange("NewChatEntry", null, entry);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

  public void addUser(User user)
  {
    try {
      server.addUser(user);
    } catch (RemoteException | SQLException e) {
      e.printStackTrace();
    }
    System.out.println("RMI Client");
  }
}
