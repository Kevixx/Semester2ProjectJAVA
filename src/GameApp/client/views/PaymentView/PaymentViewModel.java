package GameApp.client.views.PaymentView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class PaymentViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    private StringProperty totalPrice;
    /**
     *Constructor
     //     * @param clientModelManagerFactory
     */
    public PaymentViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        totalPrice = new SimpleStringProperty("0");

        clientModelManagerFactory.addListener("NewItemInShoppingCart", this:: setTotalPrice);
        clientModelManagerFactory.addListener("ItemDeletedFromShoppingCart", this:: setTotalPrice);
    }

    public void setTotalPrice(PropertyChangeEvent evt)
    {
        totalPrice.setValue(Double.toString(clientModelManagerFactory.getShoppingCartValue()));
    }

    public StringProperty getTotalPrice()
    {
        return totalPrice;
    }

    public void createTransaction()
    {
            try
            {
                clientModelManagerFactory.create(
                    clientModelManagerFactory.getUser(),
                    clientModelManagerFactory.getAllGamesFromShoppingCart());
            }
            catch (SQLException | RemoteException e)
            {
                e.printStackTrace();
            }
    }

    public void clearShoppingCart()
    {
        try
        {
            clientModelManagerFactory.removeAllGamesFromCart();
        }
        catch (SQLException | RemoteException e)
        {
            e.printStackTrace();
        }
    }


}
