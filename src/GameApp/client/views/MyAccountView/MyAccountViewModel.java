package GameApp.client.views.MyAccountView;

import GameApp.client.model.ClientModelManager;
import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.User;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.beans.PropertyChangeEvent;


/**
 *
 * @Author Saran Singh
 * @Version 1.0
 */
public class MyAccountViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private StringProperty name;
    private StringProperty email;
    private StringProperty dateOfBirth;
    private StringProperty password;
    private StringProperty address;
    private StringProperty phoneNumber, country;
    private SimpleBooleanProperty isAdmin;
    private ClientModelManager clientModelManager;

    /**
     *Constructor
//     * @param clientModelManagerFactory
     */
    public MyAccountViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        clientModelManagerFactory.addListener("UpdateProfile", this::userAccountUpdateMethod);
        name = new SimpleStringProperty();
        email= new SimpleStringProperty();
        password= new SimpleStringProperty();
        address = new SimpleStringProperty();
        country = new SimpleStringProperty();
        isAdmin = new SimpleBooleanProperty();
    }

    /**
     * Method setting the info to update
     * @param event
     */
    private void userAccountUpdateMethod(PropertyChangeEvent event) {
        User user;
        if (event.getNewValue() == null) {
            user = new User("","","","","",false);
        } else {
            user = (User) event.getNewValue();
        }

        Platform.runLater(() -> {
            name.set(user.getUsername());
            email.set(user.getEmail());
            password.set(user.getPassword());
            address.set(user.getAddress());
            country.set(user.getCountry());
            isAdmin.set(user.getIsAdmin());


        });
    }
    public void updateUserAccount(){
        clientModelManager.userEdit(new User(name.get(),country.get(), email.get(), name.getName(), password.get(), false));
    }

    public StringProperty nameProperty() {
        return name;
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
    public StringProperty countryProperty() {return country; }
}
