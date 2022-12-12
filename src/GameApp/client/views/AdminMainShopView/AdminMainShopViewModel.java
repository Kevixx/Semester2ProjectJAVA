package GameApp.client.views.AdminMainShopView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

public class AdminMainShopViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Game>> observableListProperty;
    private ObservableList<Game> observableList;


    public AdminMainShopViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        clientModelManagerFactory.addListener("NewGameAdded", this::updateObservableList);
        observableListProperty = new SimpleObjectProperty();
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllGames());
            observableListProperty.setValue(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Game> observableList()
    {
        return observableList;
    }

    public Property<ObservableList<Game>> observableListProperty()
    {
        return observableListProperty;
    }

    public void updateObservableList(PropertyChangeEvent propertyChangeEvent)
    {
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllGames());
            observableListProperty.setValue(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
