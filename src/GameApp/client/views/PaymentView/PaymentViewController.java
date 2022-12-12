package GameApp.client.views.PaymentView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PaymentViewController implements ViewController {

    private PaymentViewModel paymentViewModel;
    private ViewHandler vh;

    public TextField totalPrice;


    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.paymentViewModel = vmf.getPaymentViewModel();

        totalPrice.textProperty().bind(paymentViewModel.getTotalPrice());
    }

    public void openShoppingCart() {
        vh.openShopCartView();
    }

    public void openMyAccountView(MouseEvent mouseEvent) {
        vh.openMyAccountView();
    }

    public void openStoreView(MouseEvent mouseEvent) {
        vh.openMainShopView();
    }

    public void openLibraryView(MouseEvent mouseEvent) {
        vh.openMyLibraryView();
    }

    public void logout() {
        vh.openLoginView();
    }

    public void createTransaction()
    {
        paymentViewModel.createTransaction();
        paymentViewModel.clearShoppingCart();
        vh.openMyLibraryView();

    }
}
