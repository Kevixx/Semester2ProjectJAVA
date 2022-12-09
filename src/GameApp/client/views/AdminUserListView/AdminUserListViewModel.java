package GameApp.client.views.AdminUserListView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.sql.SQLException;
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
        try {
            return clientModelManagerFactory.getAllUsers();
        } catch (SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
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
