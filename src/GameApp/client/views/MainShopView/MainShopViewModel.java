package GameApp.client.views.MainShopView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainShopViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;

    public MainShopViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }

    public Game readByID(int gameId) throws SQLException, RemoteException
    {
      return clientModelManagerFactory.readByID(gameId);
    }

    public void setSelectedId(int id) throws SQLException, RemoteException
    {
      clientModelManagerFactory.setSelectedId(id);
    }

}

