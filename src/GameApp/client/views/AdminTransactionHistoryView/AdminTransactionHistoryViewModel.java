package GameApp.client.views.AdminTransactionHistoryView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Transaction;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class AdminTransactionHistoryViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;

    public AdminTransactionHistoryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }

    public void showAll() {

    }

    public void searchId(String id, Label errorLabel, TableView transactionTable) {
        try {
            Transaction transaction = clientModelManagerFactory.getTransactionByTransactionId(Integer.parseInt(id));

//To be continued

        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            errorLabel.setText("Incorrect id or id format!");
        }
    }
}
