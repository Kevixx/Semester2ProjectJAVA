package GameApp.client.views.ShoppingCartView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;

public class ShoppingCartViewController implements ViewController {

    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.shoppingCartViewModel = vmf.getShoppingCartViewModel();
    }
}