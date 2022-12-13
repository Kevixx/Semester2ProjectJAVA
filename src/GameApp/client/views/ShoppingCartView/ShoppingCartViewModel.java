package GameApp.client.views.ShoppingCartView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ShoppingCartViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Game>> observableListProperty;
    private ObservableList<Game> observableList;


    public ShoppingCartViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;

        observableList = FXCollections.observableList(clientModelManagerFactory.getAllGamesFromShoppingCart());
        observableListProperty = new SimpleObjectProperty<>();


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

    public List<Game> getAllGamesFromShoppingCart() {
        return clientModelManagerFactory.getAllGamesFromShoppingCart();
    }

    public void removeGame(Game game)
    {
        clientModelManagerFactory.removeGameFromShoppingCart(game);
        if (getAllGamesFromShoppingCart().size()== 0)
        {
            observableListProperty = new SimpleObjectProperty<>();
        }
    }


}