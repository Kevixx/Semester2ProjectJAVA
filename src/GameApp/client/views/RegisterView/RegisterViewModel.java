package GameApp.client.views.RegisterView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class RegisterViewModel
{
  private ClientModelManagerFactory clientModelManagerFactory;
  private StringProperty email, address, confirmAddress, username, password, confirmPassword, error;

  public RegisterViewModel(ClientModelManagerFactory clientModelManagerFactory)
  {
    this.clientModelManagerFactory = clientModelManagerFactory;
    email = new SimpleStringProperty();
    address = new SimpleStringProperty();
    confirmAddress = new SimpleStringProperty();
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    confirmPassword = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void addUser() throws SQLException {
    String input1 = email.get();
    String input2 = address.get();
    String input3 = confirmAddress.get();
    String input4 = username.get();
    String input5 = password.get();
    String input6 = confirmPassword.get();

    if(input1 != null && !"".equals(input1) && input2 != null && !"".equals(input2) && input3 != null && !"".equals(input3)
    && input4 != null && !"".equals(input4) && input5 != null && !"".equals(input5) && input6 != null && !"".equals(input6)) {
      clientModelManagerFactory.addUser(input1, input2, input4, input4, input5);
      error.set("Account saved!");
    } else {
      error.set("ERROR: Input cannot be empty");
    }
  }


  public StringProperty emailProperty() {
    return email;
  }
  public StringProperty addressProperty() {
    return address;
  }
  public StringProperty confirmAddressProperty() {
    return confirmAddress;
  }
  public StringProperty usernameProperty() {
    return username;
  }
  public StringProperty passwordProperty() {
    return password;
  }
  public StringProperty confirmPasswordProperty() {
    return confirmPassword;
  }
  public StringProperty errorProperty() {
    return error;
  }
}
