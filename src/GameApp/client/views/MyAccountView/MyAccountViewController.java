package GameApp.client.views.MyAccountView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MyAccountViewController implements ViewController {
    private MyAccountViewModel myAccountViewModel;
    private ViewHandler vha;

    @FXML
    private TextField userNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField countryField;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.myAccountViewModel = vmf.getMyAccountViewModel();

        userNameField.textProperty().bindBidirectional(myAccountViewModel.userNameProperty());
        emailField.textProperty().bindBidirectional(myAccountViewModel.emailProperty());
        passwordField.textProperty().bindBidirectional(myAccountViewModel.passwordProperty());
        addressField.textProperty().bindBidirectional(myAccountViewModel.addressProperty());
        countryField.textProperty().bindBidirectional(myAccountViewModel.countryProperty());
    }


    public void storeClicked(MouseEvent mouseEvent) {
        vha.openMainShopView();
    }


    public void saveChanges(MouseEvent mouseEvent) {
        myAccountViewModel.updateUserAccount();
    }


    public void cancelChanges(MouseEvent mouseEvent) {
        vha.openMainShopView();
    }

    public void openShoppingCart(MouseEvent mouseEvent) {
        vha.openShopCartView();
    }


}