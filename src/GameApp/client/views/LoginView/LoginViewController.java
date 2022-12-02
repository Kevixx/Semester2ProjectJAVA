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


import java.rmi.RemoteException;
import java.sql.SQLException;

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


  @FXML private void signIn(ActionEvent actionEvent) throws SQLException, RemoteException {

    if (emailField.getText()==null && passwordField.getText()==null) {
      emailField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      passwordField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      errorLabel.textProperty().set("The username and the password cannot be empty!");
    } else

    if (passwordField.getText()==null && emailField.getText()!=null) {
      passwordField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      errorLabel.textProperty().set("The password cannot be empty!");
      emailField.setStyle(null);

    } else if (passwordField.getText()!=null && emailField.getText()==null) {
      emailField.setStyle("-fx-border-color: red; -fx-border-width:2px;");
      errorLabel.textProperty().set("The username cannot be empty!");
      passwordField.setStyle(null);

    } else {
      errorLabel.textProperty().set("");
      emailField.setStyle(null);
      passwordField.setStyle(null);
      if (loginViewModel.login()) {
        loginViewModel.setLoggedUser();
        vh.openMainShopView();
      }
    }
  }}


