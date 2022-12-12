package GameApp.client.views.AdminMainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminMainShopViewController implements ViewController {

    private AdminMainShopViewModel adminMainShopViewModel;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.adminMainShopViewModel = vmf.getAdminMainShopViewModel();
//       gameList = getGameList();
    }

    //    @FXML
//    public ListView getGameList() {
//        return adminMainShopViewModel.getGameList();
//    }
    @FXML
    private TextField searchField;
    @FXML
    private void myAccount() {
        vh.openMyAccountView();
    }

    @FXML
    private void openAdminUserListView() {
        vh.openAdminUserListView();
    }

    public void openAddGameView(MouseEvent mouseEvent) {
        vh.openAdminAddGameView();
    }

    public void openLogInView(MouseEvent mouseEvent) {
        vh.openLoginView();
    }

    public void openGamesView(MouseEvent mouseEvent) {
        vh.openAdminMainShopView();
    }

    public void openAccountsView(MouseEvent mouseEvent) {
        vh.openAdminUserListView();
    }

    public void openTransactionView(MouseEvent mouseEvent) {
        vh.openAdminTransactionsHistoryView();
    }

    public void openAdminAccountView(MouseEvent mouseEvent) {
        vh.openAdminMyAccountView();
    }

    public void searchGames(MouseEvent mouseEvent) {
    //method -->


    resetField();
    }

    private void resetField() {
        searchField.setText("");
    }
}
