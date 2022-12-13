package GameApp.client.core;

import GameApp.client.views.AdminAddGameView.AdminAddGameViewModel;
import GameApp.client.views.AdminMainShopView.AdminMainShopViewModel;
import GameApp.client.views.AdminMyAccountView.AdminMyAccountViewModel;
import GameApp.client.views.AdminTransactionHistoryView.AdminTransactionHistoryViewModel;
import GameApp.client.views.AdminUserListView.AdminUserListViewModel;
import GameApp.client.views.GameView.GameViewModel;
import GameApp.client.views.LoginView.LoginViewModel;
import GameApp.client.views.MainShopView.MainShopViewModel;
import GameApp.client.views.MyAccountView.MyAccountViewModel;
import GameApp.client.views.MyLibraryView.MyLibraryViewModel;
import GameApp.client.views.PaymentView.PaymentViewModel;
import GameApp.client.views.RegisterView.RegisterViewModel;
import GameApp.client.views.ShoppingCartView.ShoppingCartViewModel;
import GameApp.client.views.UserTransactionHistoryView.UserTransactionHistoryViewModel;

public class ViewModelFactory {
    private static ViewModelFactory instance = new ViewModelFactory();

    private LoginViewModel loginViewModel;
    private RegisterViewModel registerViewModel;
    private MainShopViewModel mainShopViewModel;
    private MyAccountViewModel myAccountViewModel;
    private MyLibraryViewModel myLibraryViewModel;
    private GameViewModel gameViewModel;
    private AdminMainShopViewModel adminMainShopViewModel;
    private AdminUserListViewModel adminUserListViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private PaymentViewModel paymentViewModel;
    private AdminTransactionHistoryViewModel adminTransactionHistoryViewModel;
    private AdminMyAccountViewModel adminMyAccountViewModel;
    private AdminAddGameViewModel adminAddGameViewModel;
    private UserTransactionHistoryViewModel userTransactionHistoryViewModel;


    public static ViewModelFactory getInstance() {
        return instance;
    }

    public ViewModelFactory() {

    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null)
            loginViewModel = new LoginViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return loginViewModel;
    }

    public RegisterViewModel getRegisterViewModel() {
        if (registerViewModel == null)
            registerViewModel = new RegisterViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return registerViewModel;
    }

    public MainShopViewModel getMainShopViewModel() {
        if (mainShopViewModel == null)
            mainShopViewModel = new MainShopViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return mainShopViewModel;
    }

    public MyAccountViewModel getMyAccountViewModel() {
        if (myAccountViewModel == null)
            myAccountViewModel = new MyAccountViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return myAccountViewModel;
    }

    public MyLibraryViewModel getMyLibraryViewModel() {
        if (myLibraryViewModel == null)
            myLibraryViewModel = new MyLibraryViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return myLibraryViewModel;
    }

    public GameViewModel getGameViewModel() {
        if (gameViewModel == null)
            gameViewModel = new GameViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return gameViewModel;
    }

    public AdminMainShopViewModel getAdminMainShopViewModel() {
        if (adminMainShopViewModel == null)
            adminMainShopViewModel = new AdminMainShopViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return adminMainShopViewModel;
    }

    public AdminUserListViewModel getAdminUserListViewModel() {
        if (adminUserListViewModel == null)
            adminUserListViewModel = new AdminUserListViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return adminUserListViewModel;
    }

    public ShoppingCartViewModel getShoppingCartViewModel() {
        if (shoppingCartViewModel == null)
            shoppingCartViewModel = new ShoppingCartViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return shoppingCartViewModel;
    }

    public PaymentViewModel getPaymentViewModel() {
        if (paymentViewModel == null)
            paymentViewModel = new PaymentViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return paymentViewModel;
    }

    public AdminTransactionHistoryViewModel getAdminTransactionHistoryViewModel() {
        if (adminTransactionHistoryViewModel == null)
            adminTransactionHistoryViewModel = new AdminTransactionHistoryViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return adminTransactionHistoryViewModel;
    }

    public AdminAddGameViewModel getAdminAddGameViewModel() {
        if (adminAddGameViewModel == null)
            adminAddGameViewModel = new AdminAddGameViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return adminAddGameViewModel;
    }

    public AdminMyAccountViewModel getAdminMyAccountViewModel() {
        if (adminMyAccountViewModel == null)
            adminMyAccountViewModel = new AdminMyAccountViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return adminMyAccountViewModel;
    }

    public UserTransactionHistoryViewModel getUserTransactionHistoryViewModel() {
        if (userTransactionHistoryViewModel == null)
            userTransactionHistoryViewModel = new UserTransactionHistoryViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
        return userTransactionHistoryViewModel;
    }
}
