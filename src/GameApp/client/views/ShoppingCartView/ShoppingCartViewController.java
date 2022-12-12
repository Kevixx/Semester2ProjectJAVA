package GameApp.client.views.ShoppingCartView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import GameApp.server.model.modelClasses.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ShoppingCartViewController implements ViewController {

    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewHandler vh;

    @FXML
    private TableView<Game> shoppingCartTable;
    @FXML
    TableColumn<Game, String> title, description, price;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.vh = vh;
        this.shoppingCartViewModel = vmf.getShoppingCartViewModel();

        setTable();
        shoppingCartTable.itemsProperty().bind(shoppingCartViewModel.observableListProperty());
    }


    public void setTable()
    {

        title.setCellValueFactory(new PropertyValueFactory<>("GameTitle"));
        description.setCellValueFactory(new PropertyValueFactory<>("GameDescription"));
        price.setCellValueFactory(new PropertyValueFactory<>("GamePrice"));

    }

    public void removeGame()
    {
        shoppingCartTable.itemsProperty().unbind();
        shoppingCartViewModel.removeGame(shoppingCartTable.getSelectionModel().getSelectedItem());
        shoppingCartTable.itemsProperty().bind(shoppingCartViewModel.observableListProperty());
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