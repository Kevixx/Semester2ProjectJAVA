package GameApp.client.views.AdminTransactionHistoryView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminTransactionHistoryViewController implements ViewController {

    @FXML
    private Label errorLabel;
    @FXML
    private TextField searchField;
    @FXML
    private TableView transactionTable;
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

    public void searchTransactionId(MouseEvent mouseEvent) {
            adminTransactionHistoryViewModel.searchId(searchField.getText(), errorLabel, transactionTable);
    }

    public void showAll(MouseEvent mouseEvent) {
        errorLabel.setText("");
        adminTransactionHistoryViewModel.showAll();
    }

    public void logOut(MouseEvent mouseEvent) {
        viewHandler.openLoginView();
    }

    public void resetLabel(MouseEvent mouseEvent) {
        errorLabel.setText("");
    }
}
