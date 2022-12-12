package GameApp.client.views.AdminMyAccountView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.beans.PropertyChangeEvent;

public class AdminMyAccountViewController implements ViewController {
    @FXML
    private TextField userNameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField countryField;
    @FXML
    private Label errorLabel;

    private ViewHandler viewHandler;
    private AdminMyAccountViewModel adminMyAccountViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
        adminMyAccountViewModel = vmf.getAdminMyAccountViewModel();
        adminMyAccountViewModel.addListener("setFields", this::setFields);
    }

    private void setFields(PropertyChangeEvent event) {
        adminMyAccountViewModel.setFields(emailField, userNameField, addressField, countryField);
    }


    public void openLoginView(MouseEvent mouseEvent) {
        viewHandler.openLoginView();
    }

    public void saveChanges(MouseEvent mouseEvent) {
        resetLabel();
        adminMyAccountViewModel.changeDetail(userNameField, passwordField,
                confirmPasswordField, addressField, countryField, errorLabel);
    }

    public void openStoreView(MouseEvent mouseEvent) {
        resetLabel();
        viewHandler.openAdminMainShopView();
    }

    public void resetLabel() {
        errorLabel.setText("");
    }
}

