package GameApp.client.views.ShoppingCartView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.AdminUserListView.AdminUserListViewModel;
import GameApp.client.views.ViewController;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartViewController implements ViewController {

    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewHandler vh;

    @FXML
    private TableView<Game> shoppingCartTable;
    @FXML
    TableColumn<Game, String> title, description, price;
    private ObservableList<Game> data;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.shoppingCartViewModel = vmf.getShoppingCartViewModel();
        title.cellFactoryProperty().bindBidirectional((Property)shoppingCartViewModel.returnTitle());
        description.cellFactoryProperty().bindBidirectional((Property)shoppingCartViewModel.returnDescription());
        price.cellFactoryProperty().bindBidirectional((Property)shoppingCartViewModel.returnPrice());
      setTable();
    }


    public void setTable()
    {
        ArrayList<Game> gameList  = shoppingCartViewModel.getAllGamesFromShoppingCart();
        data = FXCollections.observableArrayList(gameList);

        title = new TableColumn<>("Title of Game");
        title.setCellValueFactory(new PropertyValueFactory<>("title"));

        description= new TableColumn<>("Description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        price= new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));


        shoppingCartTable.getColumns().setAll(title, description, price);
        shoppingCartTable.setItems(data);
    }

    public void removeGame()
    {
        shoppingCartViewModel.removeGame(shoppingCartTable.getSelectionModel().getSelectedItem().getGameId());
    }

    public void openPayment()
    {
        vh.openPaymentView();
    }

    public void openMainShopView()
    {
        vh.openMainShopView();
    }
}