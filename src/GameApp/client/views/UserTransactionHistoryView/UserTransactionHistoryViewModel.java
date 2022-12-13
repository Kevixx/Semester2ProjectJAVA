package GameApp.client.views.UserTransactionHistoryView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Transaction;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

public class UserTransactionHistoryViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;
    private Property<ObservableList<Transaction>> observableListProperty;
    private ObservableList<Transaction> observableList;

    public UserTransactionHistoryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;

        observableListProperty = new SimpleObjectProperty();

        List<Transaction> dummyList = new ArrayList<>();
        observableList = FXCollections.observableList(dummyList);
        observableListProperty.setValue(observableList);

        clientModelManagerFactory.addListener("UserLoggedIn", this::updateObservableList);
        clientModelManagerFactory.addListener("TransactionMade", this::updateObservableList);
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
            List<Transaction> transactions = clientModelManagerFactory.getAllTransactionsForThisClient();
            if (transactions!=null)
            {
                observableList = FXCollections.observableList(
                    clientModelManagerFactory.getAllTransactionsForThisClient());
                observableListProperty.setValue(observableList);
            }
        } catch (SQLException | RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void showAll()
    {
        try
        {
            observableList = FXCollections.observableList(clientModelManagerFactory.getAllTransactionsForThisClient());
            observableListProperty.setValue(observableList);
        } catch (SQLException | RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void searchId(String id, Label errorLabel) {
        try {
            List<Transaction> transactions = clientModelManagerFactory.getAllTransactionsForThisClient();
            List<Transaction> filteredTransactions = new ArrayList<>();
            for (int i = 0; i < transactions.size(); i++)
            {
                if (transactions.get(i).getTransactionId() == parseInt(id))
                {
                    filteredTransactions.add(transactions.get(i));
                }
            }
            observableList = FXCollections.observableList(filteredTransactions);
            observableListProperty.setValue(observableList);

        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            errorLabel.setText("Incorrect id or id format!");
        }
    }
}
