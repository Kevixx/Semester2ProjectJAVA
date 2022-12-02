package GameApp.client.views.MyAccountView;
import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;


public class MyAccountViewController implements ViewController{
    private MyAccountViewModel myAccountViewModel;
    private ViewHandler vha;
    public TextField nameField;
    public TextField emailField;
    public TextField passwordField;
    public TextField addressField;
    public TextField phoneField;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.myAccountViewModel = vmf.getMyAccountViewModel();

        nameField.textProperty().bindBidirectional(myAccountViewModel.nameProperty());
        emailField.textProperty().bindBidirectional(myAccountViewModel.emailProperty());
        passwordField.textProperty().bindBidirectional(myAccountViewModel.passwordProperty());
        addressField.textProperty().bindBidirectional(myAccountViewModel.addressProperty());
        phoneField.textProperty().bindBidirectional(myAccountViewModel.phoneNumberProperty());
    }


    public void storeClicked(MouseEvent mouseEvent) {vha.openMainShopView();
    }

    public void saveChanges() {
        myAccountViewModel.updateUserAccount();
        vha.openMyAccountView();
    }
}
