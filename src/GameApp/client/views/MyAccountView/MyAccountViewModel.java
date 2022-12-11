package GameApp.client.views.MyAccountView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;


/**
 * @Author Saran Singh
 * @Version 1.0
 */
public class MyAccountViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private StringProperty userName;
    private StringProperty email;
    private StringProperty password;
    private StringProperty address;
    private StringProperty country;
    private SimpleBooleanProperty isAdmin;

    /**
     * Constructor
     * //     * @param clientModelManagerFactory
     */
    public MyAccountViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
       //clientModelManagerFactory.addListener("UpdateProfile", this::userAccountUpdateMethod);
        clientModelManagerFactory.addListener("UserLoggedIn", this::set);
        userName = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        address = new SimpleStringProperty("");
        country = new SimpleStringProperty("");
        isAdmin = new SimpleBooleanProperty(false);

    }

    public void set(PropertyChangeEvent event) {
        userName.set(clientModelManagerFactory.getUser().getUsername());
        email.set(clientModelManagerFactory.getUser().getEmail());
        password.set(clientModelManagerFactory.getUser().getPassword());
        address.set(clientModelManagerFactory.getUser().getAddress());
        country.set(clientModelManagerFactory.getUser().getCountry());
        isAdmin.set(clientModelManagerFactory.getUser().getIsAdmin());
    }

    public void updateUserAccount() {

        clientModelManagerFactory.userEdit(new User(email.getValue(), country.getValue(), address.getValue(), userName.getValue(), password.getValue(),isAdmin.getValue()));
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty countryProperty() {
        return country;
    }
}
