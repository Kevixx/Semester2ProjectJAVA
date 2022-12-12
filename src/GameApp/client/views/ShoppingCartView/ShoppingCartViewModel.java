package GameApp.client.views.ShoppingCartView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Game>> observableListProperty;
    private ObservableList<Game> observableList;


    public ShoppingCartViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;

        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllGamesFromShoppingCart());
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
        observableListProperty = new SimpleObjectProperty();


        clientModelManagerFactory.addListener("NewItemInShoppingCart", this::updateObservableList);
        clientModelManagerFactory.addListener("ItemDeletedFromShoppingCart", this::updateObservableList);
    }

    public ObservableList<Game> observableList()
    {
        return observableList;
    }

    public Property<ObservableList<Game>> observableListProperty()
    {
        return observableListProperty;
    }

    public void updateObservableList(PropertyChangeEvent propertyChangeEvent) {
        observableList = FXCollections.observableList(getAllGamesFromShoppingCart());
        observableListProperty.setValue(observableList);
    }

    public ArrayList<Game> getAllGamesFromShoppingCart() {
        try {
            return clientModelManagerFactory.getAllGamesFromShoppingCart();
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeGame(Game game)
    {
        try {
            clientModelManagerFactory.removeGameFromShoppingCart(game);
            if (getAllGamesFromShoppingCart().size()== 0)
            {
                observableListProperty = new SimpleObjectProperty();
            }
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}