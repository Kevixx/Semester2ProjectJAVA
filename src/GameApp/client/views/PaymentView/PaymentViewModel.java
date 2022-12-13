package GameApp.client.views.PaymentView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

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
        clientModelManagerFactory.create(
            clientModelManagerFactory.getUser(),
            clientModelManagerFactory.getAllGamesFromShoppingCart());
    }

    public void clearShoppingCart()
    {
        clientModelManagerFactory.removeAllGamesFromCart();
    }
}
