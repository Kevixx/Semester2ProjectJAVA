package GameApp.client.views.AdminTransactionHistoryView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class AdminTransactionHistoryViewController implements ViewController {

    private ViewHandler viewHandler;
    private AdminTransactionHistoryViewModel adminTransactionHistoryViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
        adminTransactionHistoryViewModel = vmf.getAdminTransactionHistoryViewModel();
    }

    public void storeClicked(MouseEvent mouseEvent) {
        viewHandler.openAdminMainShopView();
    }

    public void saveChanges(ActionEvent actionEvent) {

    }

    public void cancelChanges(ActionEvent actionEvent) {

    }


}
