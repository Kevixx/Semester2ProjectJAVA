package GameApp.client.core;

import GameApp.client.model.ClientModelManager;
import GameApp.client.model.ClientModelManagerFactory;

public class ModelFactory
{
  private static ModelFactory instance = new ModelFactory();
  public static ModelFactory getInstance(){
    return instance;
  }
  private ClientModelManagerFactory clientModelManagerFactory;

  private ModelFactory() {
  }

  public ClientModelManagerFactory getClientModelManagerFactory() {
    if(clientModelManagerFactory == null)
      clientModelManagerFactory = new ClientModelManager(ClientFactory.getInstance().getClient());
    return clientModelManagerFactory;
  }
}
