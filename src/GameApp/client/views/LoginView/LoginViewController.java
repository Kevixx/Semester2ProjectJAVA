package GameApp.client.views.LoginView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
//import com.sun.jdi.connect.spi.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController
{

  private LoginViewModel loginViewModel;
  private ViewHandler vh;

  @FXML private TextField passwordField, emailField;
  public Label errorLabel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.loginViewModel = vmf.getLoginViewModel();
     emailField.textProperty().bindBidirectional(loginViewModel.getEmail());
    passwordField.textProperty().bindBidirectional(loginViewModel.getPassword());
//    errorLabel.textProperty().bind(loginViewModel.errorProperty());
  }

  @FXML private void register()
  {
    vh.openRegisterView();
  }


  @FXML private void signIn(ActionEvent actionEvent)
  {

    if (emailField.getText().length() == 0 && passwordField.getText().length() != 0)
    {
      emailField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
    }
    else
      emailField.setStyle(null);
    errorLabel.textProperty().set("The username cannot be empty!");

    if (passwordField.getText().length() == 0 && emailField.getText().length() != 0)
    {
      passwordField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      errorLabel.textProperty().set("The password cannot be empty!");

    } else if(passwordField.getText().length() == 0 && emailField.getText().length() == 0)
    {
      emailField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      passwordField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      errorLabel.textProperty().set("The username and the password cannot be empty!");
    }
    else {
      errorLabel.textProperty().set("");
      emailField.setStyle(null);
      passwordField.setStyle(null);
      if(loginViewModel.login())vh.openMainShopView();
    }

  }

}
