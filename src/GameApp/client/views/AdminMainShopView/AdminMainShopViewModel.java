package GameApp.client.views.AdminMainShopView;

import GameApp.client.model.ClientModelManagerFactory;

import javax.swing.text.html.ListView;
import java.sql.SQLException;

public class AdminMainShopViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    public AdminMainShopViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }

//    public ListView getGameList() {
//        try {
//            return (ListView) clientModelManagerFactory.getAllGames();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
