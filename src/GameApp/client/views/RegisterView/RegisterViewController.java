package GameApp.client.views.RegisterView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterViewController implements ViewController
{
  private RegisterViewModel registerViewModel;
  private ViewHandler vh;
  @FXML
  private TextField emailField, confirmEmailField, countryField, usernameField, addressField, passwordField, confirmPasswordField;
  @FXML Label errorLabel;
  @FXML
  CheckBox notRobotCheckBox, yearsCheckBox;



  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.registerViewModel = vmf.getRegisterViewModel();

    emailField.textProperty().bindBidirectional(registerViewModel.emailProperty());
    confirmEmailField.textProperty().bindBidirectional(registerViewModel.confirmEmailProperty());
    countryField.textProperty().bindBidirectional(registerViewModel.countryProperty());
    addressField.textProperty().bindBidirectional(registerViewModel.addressProperty());
    usernameField.textProperty().bindBidirectional(registerViewModel.usernameProperty());
    passwordField.textProperty().bindBidirectional(registerViewModel.passwordProperty());
    confirmPasswordField.textProperty().bindBidirectional(registerViewModel.confirmPasswordProperty());
  }

  @FXML
  private void backToLogin() {
    vh.openLoginView();
    emailField.clear();
    confirmEmailField.clear();
    countryField.clear();
    addressField.clear();
    usernameField.clear();
    passwordField.clear();
    confirmPasswordField.clear();
    notRobotCheckBox.selectedProperty().setValue(false);
    yearsCheckBox.selectedProperty().setValue(false);
    errorLabel.textProperty().set("");
  }

  @FXML
  private void saveInfo() throws SQLException {
    if(notRobotCheckBox.isSelected() && yearsCheckBox.isSelected()) {
      errorLabel.textProperty().bindBidirectional(registerViewModel.errorProperty());
      registerViewModel.addUser();
    }
    else
    {errorLabel.textProperty().setValue(("CheckBoxes ERROR!"));}
  }


}