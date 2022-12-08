package GameApp.client.views.AdminMainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;

import javax.swing.text.html.ListView;
import java.sql.SQLException;

public class AdminMainShopViewController implements ViewController {
    private AdminMainShopViewModel adminMainShopViewModel;
    private ViewHandler vh;
    @FXML
    ListView gameList;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.adminMainShopViewModel = vmf.getAdminMainShopViewModel();
       gameList = getGameList();
    }

    @FXML
    public ListView getGameList() {
        return adminMainShopViewModel.getGameList();
    }
   @FXML
   private void myAccount() {vh.openMyAccountView();}

}
