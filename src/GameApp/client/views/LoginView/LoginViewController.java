package GameApp.client.views.LoginView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import com.sun.jdi.connect.spi.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController
{

  private LoginViewModel loginViewModel;
  private ViewHandler vh;

  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  public Label errorLabel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.loginViewModel = vmf.getLoginViewModel();
//    usernameField.textProperty().bindBidirectional(loginViewModel.getUsername());
//    passwordField.textProperty().bindBidirectional(loginViewModel.getPassword());
//    errorLabel.textProperty().bind(loginViewModel.errorProperty());
  }

  @FXML private void register()
  {
    vh.openRegisterView();
  }


  @FXML private void signIn(ActionEvent actionEvent)
  {

    if (usernameField.getText().length() == 0)
    {
      usernameField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
    }
    else
      usernameField.setStyle(null);

    if (passwordField.getText().length() == 0)
    {
      passwordField.setStyle("-fx-border-color: red; -fx-border-width:2px;");

    }
    else
      usernameField.setStyle(null);
  }

}
