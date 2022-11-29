package GameApp.shared.networking;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote, Serializable
{
  void update(String entry) throws RemoteException;
}

