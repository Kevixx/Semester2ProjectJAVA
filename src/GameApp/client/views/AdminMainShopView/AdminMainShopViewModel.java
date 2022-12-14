package GameApp.client.views.AdminMainShopView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.shared.model.Game;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class AdminMainShopViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Game>> observableListProperty;
    private ObservableList<Game> observableList;


    public AdminMainShopViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        clientModelManagerFactory.addListener("NewGameAdded", this::updateObservableList);
        observableListProperty = new SimpleObjectProperty();
        observableList = FXCollections.observableList(clientModelManagerFactory.getAllGames());
        observableListProperty.setValue(observableList);
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
        observableList = FXCollections.observableList(clientModelManagerFactory.getAllGames());
        observableListProperty.setValue(observableList);
    }

    public void updateObservableList()
    {
        observableList = FXCollections.observableList(clientModelManagerFactory.getAllGames());
        observableListProperty.setValue(observableList);
    }

    public void searchForGame(String title)
    {
        observableList = FXCollections.observableList(clientModelManagerFactory.getGamesByTitle(title));
        observableListProperty.setValue(observableList);
    }
}
