package GameApp.client.core;

import GameApp.client.network.Client;
import GameApp.client.network.RMIClient;

public class ClientFactory
{
  private static ClientFactory instance;

  static {
    instance = new ClientFactory();
  }
  public static ClientFactory getInstance(){
    return instance;
  }

  private Client client;

  private ClientFactory() {
  }

  public Client getClient() {
    if (client == null) {
      client = new RMIClient();
    }
    return client;
  }
}
