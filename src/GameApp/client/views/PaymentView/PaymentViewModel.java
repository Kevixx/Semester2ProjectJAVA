package GameApp.client.views.PaymentView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PaymentViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    /**
     *Constructor
     //     * @param clientModelManagerFactory
     */
    public PaymentViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;


    }
}
