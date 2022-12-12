package GameApp.client.views.AdminMainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import GameApp.server.model.modelClasses.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class AdminMainShopViewController implements ViewController {

    private AdminMainShopViewModel adminMainShopViewModel;
    private ViewHandler vh;


    public TextField searchField;

    public TableView tableView;

    public TableColumn idColumn;
    public TableColumn titleColumn;
    public TableColumn priceColumn;
    public TableColumn genreColumn;
    public TableColumn descriptionColumn;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.adminMainShopViewModel = vmf.getAdminMainShopViewModel();

        setTable();

        tableView.itemsProperty().bind(adminMainShopViewModel.observableListProperty());
    }

    public void setTable()
    {
        idColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("GameId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("GameTitle"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Game, Double>("GamePrice"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("GameGenre"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("GameDescription"));
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
