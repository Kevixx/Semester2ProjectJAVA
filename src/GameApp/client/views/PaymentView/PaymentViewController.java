package GameApp.client.views.PaymentView;

import GameApp.client.core.ViewFactory;
import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.MyAccountView.MyAccountViewModel;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PaymentViewController implements ViewController {

    private PaymentViewModel paymentViewModel;
    private ViewHandler vha;


    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.paymentViewModel = vmf.getPaymentViewModel();
    }

    public void openShoppingCart() {
        vha.openShopCartView();
    }

    public void updateLibrary(MouseEvent mouseEvent) {
    }
}
