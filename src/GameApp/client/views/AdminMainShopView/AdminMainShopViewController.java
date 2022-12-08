package GameApp.client.views.AdminMainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;

public class AdminMainShopViewController implements ViewController {
    private AdminMainShopViewModel adminMainShopViewModel;
    private ViewHandler vh;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.adminMainShopViewModel = vmf.getAdminMainShopViewModel();
    }
   @FXML
   private void myAccount() {vh.openMyAccountView();}

}
