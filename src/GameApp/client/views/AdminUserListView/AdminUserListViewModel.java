package GameApp.client.views.AdminUserListView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.shared.model.User;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class AdminUserListViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;
    private ListProperty<String> usersList;
    private StringProperty username, email, address, country, searchUser;

    public AdminUserListViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        username = new SimpleStringProperty();
        email = new SimpleStringProperty();
        address = new SimpleStringProperty();
        country = new SimpleStringProperty();
        searchUser = new SimpleStringProperty();

    }
 public User findUserByEmail(String email)
 {
     if(clientModelManagerFactory.findUserByEmail(email)  != null)
     {
         User user = clientModelManagerFactory.findUserByEmail(email);
         username.set(user.getAddress());
         System.out.println(user);
         address.set(user.getAddress());
         country.set(user.getCountry());
       return user;
     }
     else return null;
 }




    public List<User> getAllUsers() {
        return clientModelManagerFactory.getAllUsers();
    }

    public void deleteUser(User user) {
        clientModelManagerFactory.deleteUser(user);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty addressProperty() {
        return address;
    }


    public StringProperty countryProperty() {
        return country;
    }
}
