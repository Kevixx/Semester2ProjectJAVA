package GameApp.client.views.RegisterView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.LoginView.LoginViewModel;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class RegisterViewController implements ViewController
{
  private RegisterViewModel registerViewModel;
  private ViewHandler vh;
  @FXML
  private TextField emailField, addressField, confirmAddressField, passwordField, confirmPasswordField, usernameField;
  @FXML Label errorLabel;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.registerViewModel = vmf.getRegisterViewModel();

    emailField.textProperty().bindBidirectional(registerViewModel.emailProperty());
    addressField.textProperty().bindBidirectional(registerViewModel.addressProperty());
    confirmAddressField.textProperty().bindBidirectional(registerViewModel.confirmAddressProperty());
    passwordField.textProperty().bindBidirectional(registerViewModel.passwordProperty());
    confirmPasswordField.textProperty().bindBidirectional(registerViewModel.confirmPasswordProperty());
    usernameField.textProperty().bindBidirectional(registerViewModel.usernameProperty());
    errorLabel.textProperty().bind(registerViewModel.errorProperty());
  }

  @FXML
  private void backToLogin() {
    vh.openLoginView();
  }

  @FXML
  private void saveInfo() throws SQLException {
    registerViewModel.addUser();
  }


}
