package GameApp.client.views.AdminTransactionHistoryView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Transaction;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminTransactionHistoryViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Transaction>> observableListProperty;
    private ObservableList<Transaction> observableList;

    public AdminTransactionHistoryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;

        observableListProperty = new SimpleObjectProperty();
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllTransactions());
            observableListProperty.setValue(observableList);
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Transaction> observableList()
    {
        return observableList;
    }

    public Property<ObservableList<Transaction>> observableListProperty()
    {
        return observableListProperty;
    }

    public void updateObservableList(PropertyChangeEvent propertyChangeEvent)
    {
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllTransactions());
            observableListProperty.setValue(observableList);
        } catch (SQLException | RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void showAll()
    {
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllTransactions());
            observableListProperty.setValue(observableList);
        } catch (SQLException | RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void searchId(String id, Label errorLabel) {
        try {
            List<Transaction> transaction = new ArrayList<>();
            transaction.add(clientModelManagerFactory.getTransactionByTransactionId(Integer.parseInt(id)));
            observableList = FXCollections.observableList(transaction);
            observableListProperty.setValue(observableList);

        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            errorLabel.setText("Incorrect id or id format!");
        }
    }
}
