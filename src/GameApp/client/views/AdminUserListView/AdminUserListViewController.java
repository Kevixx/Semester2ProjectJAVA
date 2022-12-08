package GameApp.client.views.AdminUserListView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.AdminMainShopView.AdminMainShopViewModel;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;

import javax.swing.text.html.ListView;

public class AdminUserListViewController implements ViewController {
    private AdminUserListViewModel adminUserListViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.adminUserListViewModel = vmf.getAdminUserListViewModel();
    }
}
