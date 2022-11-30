package GameApp.client.views.RegisterView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.SplitMenuButton;

import java.awt.*;
import java.sql.SQLException;

public class RegisterViewModel
{
  private ClientModelManagerFactory clientModelManagerFactory;
  private StringProperty email, confirmEmail, country, address,username, password, confirmPassword, error;



  public RegisterViewModel(ClientModelManagerFactory clientModelManagerFactory)
  {
    this.clientModelManagerFactory = clientModelManagerFactory;
    email = new SimpleStringProperty();
    confirmEmail = new SimpleStringProperty();
    country = new SimpleStringProperty();
    address = new SimpleStringProperty();
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    confirmPassword = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void addUser() throws SQLException {
    error.set("");
    String input1 = email.get();
    String input2 = confirmEmail.get();
    String input3 = country.get();
    String input4 = address.get();
    String input5 = username.get();
    String input6 = password.get();
    String input7 = confirmPassword.get();

    if (input1 != null && !"".equals(input1) && input2 != null && !"".equals(input2) && input3 != null && !"".equals(input3)
            && input4 != null && !"".equals(input4) && input5 != null && !"".equals(input5) && input6 != null && !"".equals(input6)
            && !"".equals(input5) && input6 != null && !"".equals(input6) && input7 != null && !"".equals(input7)) {
      if (!input1.equals(input2)) {
        error.set("The emails are not matching!");
      } else {
        if (checkEmail(input1)) {
          error.set("Email already used in the system! Please introduce another email");
        } else {
          if (input6.equals(input7)) {
            clientModelManagerFactory.addUser(input1, input2, input4, input4, input5);
            error.set("Account saved!");

        } else
        error.set("The passwords are not matching!");
      }
    }
      }
       else
        error.set("ERROR: Input cannot be empty");
  }


  public StringProperty emailProperty() {
    return email;
  }
  public StringProperty confirmEmailProperty()
  {
    return confirmEmail;
  }
  public StringProperty countryProperty()
  {
    return country;
  }
  public StringProperty addressProperty() {
    return address;
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
  public boolean checkEmail(String email)
  {
    return clientModelManagerFactory.checkEmail(email);
  }
}
