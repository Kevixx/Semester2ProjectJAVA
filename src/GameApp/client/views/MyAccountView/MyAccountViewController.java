package GameApp.client.views.MyAccountView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

public class MyAccountViewController implements ViewController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField countryField;
    private MyAccountViewModel myAccountViewModel;
    private ViewHandler vha;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.myAccountViewModel = vmf.getMyAccountViewModel();

        nameField.textProperty().bindBidirectional(myAccountViewModel.userNameProperty());
        emailField.textProperty().bindBidirectional(myAccountViewModel.emailProperty());
        passwordField.textProperty().bindBidirectional(myAccountViewModel.passwordProperty());
        addressField.textProperty().bindBidirectional(myAccountViewModel.addressProperty());
        countryField.textProperty().bindBidirectional(myAccountViewModel.countryProperty());
    }


    public void storeClicked(MouseEvent mouseEvent) {
        vha.openMainShopView();
    }

    public void saveChanges() {
        myAccountViewModel.updateUserAccount();

    }

    public void cancelChanges() {
        vha.openMainShopView();
    }

    public void openShoppingCart() {
        vha.openShopCartView();
    }
}