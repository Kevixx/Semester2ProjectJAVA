package GameApp.client.views.ShoppingCartView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
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
    private ListProperty<String> usersList;
    private StringProperty title, description, price;




    public ShoppingCartViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
        title = new SimpleStringProperty();
        description = new SimpleStringProperty();
        price = new SimpleStringProperty();
    }


    public ArrayList<Game> getAllGamesFromShoppingCart() {
        try {
            return clientModelManagerFactory.getAllGamesFromShoppingCart();
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public StringProperty returnTitle()
    {
        return title;
    }

    public StringProperty returnDescription()
    {
        return description;
    }
    public StringProperty returnPrice()
    {
        return price;
    }

    public void removeGame(int id)
    {
        try {
            clientModelManagerFactory.removeGameFromShoppingCart(id);
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}