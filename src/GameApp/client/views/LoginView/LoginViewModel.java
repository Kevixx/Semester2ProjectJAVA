package GameApp.client.views.LoginView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.shared.model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;

    public LoginViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
        email = new SimpleStringProperty();
        error = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public StringProperty getEmail() {

        return email;
    }

    public StringProperty getPassword() {

        return password;
    }

    public StringProperty errorProperty() {
        return error;
    }

    public boolean personFound(boolean input) {
        return input;
    }

    public boolean login() {
        String email = this.email.get();
        String password = this.password.get();
        return clientModelManagerFactory.login(email, password);
    }

    public User setLoggedUser() {
        if (login()) {

            return clientModelManagerFactory.getLoggedUser(email.get(), password.get());
        }
        return null;
    }
}
