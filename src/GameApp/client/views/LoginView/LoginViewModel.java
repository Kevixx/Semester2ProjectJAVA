package GameApp.client.views.LoginView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginViewModel
{
  private ClientModelManagerFactory clientModelManagerFactory;
  private StringProperty email;
  private StringProperty password;
  private StringProperty error;

  public LoginViewModel(ClientModelManagerFactory clientModelManagerFactory)
  {
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

  public boolean personFound(boolean input)
  {
    return input;
  }
  public boolean login()
  {
    String input1 = email.get();
    String input2 = password.get();
    return clientModelManagerFactory.login(input1, input2);
  }

  public void setLoggedUser() {
    if (login())
    {
      clientModelManagerFactory.getLoggedUser(email.get(), password.get());
    }
  }
}
