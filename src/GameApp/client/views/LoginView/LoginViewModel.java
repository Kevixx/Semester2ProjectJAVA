package GameApp.client.views.LoginView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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


//  public void addUser()
//  {
//    String input1 = username.get();
//    String input2 = password.get();
//
//    if (input1 != null && !"".equals(input1) && input2 != null && !"".equals(
//        input2))
//    {
//      //things to be made
//      error.set("Entering into the shop...");
//    }
//    else
//    {
//      error.set("ERROR: Username or password incorrect!");
//    }
//  }

  public StringProperty getEmail() {

    return email;
  }

  public StringProperty getPassword() {

    return password;
  }

  public StringProperty errorProperty() {
    return error;
  }

  public boolean login()
  {
    String input1 = email.get();
    String input2 = password.get();
    return clientModelManagerFactory.login(input1, input2);


  }
}
