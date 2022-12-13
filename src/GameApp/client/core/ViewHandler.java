package GameApp.client.core;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewHandler {
    private static ViewHandler instance = new ViewHandler();

    public static ViewHandler getInstance() {
        return instance;
    }

    private Stage stage;

    private ViewHandler() {
    }

    public void start() {
        stage = new Stage();
        ViewFactory.init(stage);

        openLoginView();

        stage.getIcons().add(new Image("@../../GameApp/client/views/images/Icon.png"));
        closeApplication();
    }

    public void openLoginView() {
        Scene loginViewScene = ViewFactory.getScene("LoginView");
        stage.setScene(loginViewScene);
        stage.setTitle("Login");
        stage.show();
    }

    public void openRegisterView() {
        Scene registerViewScene = ViewFactory.getScene("RegisterView");
        stage.setScene(registerViewScene);
        stage.setTitle("Register");
        stage.show();
    }

    public void openMainShopView() {
        Scene mainShopViewScene = ViewFactory.getScene("MainShopView");
        stage.setScene(mainShopViewScene);
        stage.setTitle("Main Shop");
        stage.show();
    }

    public void openMyAccountView() {
        Scene myAccountViewScene = ViewFactory.getScene("MyAccountView");
        stage.setScene(myAccountViewScene);
        stage.setTitle("My Account");
        stage.show();
    }

    public void openMyLibraryView() {
        Scene myLibraryViewScene = ViewFactory.getScene("MyLibraryView");
        stage.setScene(myLibraryViewScene);
        stage.setTitle("My Library");
        stage.show();
    }

    public void openGameView() {
        Scene gameViewScene = ViewFactory.getScene("GameView");
        stage.setScene(gameViewScene);
        stage.setTitle("Game View");
        stage.show();
    }

    public void openAdminMainShopView() {
        Scene adminMainShopViewScene = ViewFactory.getScene("AdminMainShopView");
        stage.setScene(adminMainShopViewScene);
        stage.setTitle("Admin Main Shop");
        stage.show();
    }

    public void openAdminTransactionsHistoryView() {
        Scene adminTransactionsHistoryView = ViewFactory.getScene("AdminTransactionsHistoryView");
        stage.setScene(adminTransactionsHistoryView);
        stage.setTitle("Admin Transaction History");
        stage.show();
    }

    public void openAdminAddGameView() {
        Scene adminTransactionsHistoryView = ViewFactory.getScene("AdminAddGameView");
        stage.setScene(adminTransactionsHistoryView);
        stage.setTitle("Admin Add Game");
        stage.show();
    }

    public void openAdminMyAccountView() {
        Scene adminTransactionsHistoryView = ViewFactory.getScene("AdminMyAccountView");
        stage.setScene(adminTransactionsHistoryView);
        stage.setTitle("Admin My Account");
        stage.show();
    }

    public void openAdminUserListView() {
        Scene adminUserListScene = ViewFactory.getScene("AdminUserListView");
        stage.setScene(adminUserListScene);
        stage.setTitle("Admin User List");
        stage.show();
    }

    public void openShopCartView() {
        Scene shoppingCartScene = ViewFactory.getScene("ShoppingCartView");
        stage.setScene(shoppingCartScene);
        stage.setTitle("Shopping Cart");
        stage.show();
    }

    public void openPaymentView() {
        Scene paymentScene = ViewFactory.getScene("PaymentView");
        stage.setScene(paymentScene);
        stage.setTitle("Payment View");
        stage.show();
    }

    public void openUserTransactionHistoryView() {
        Scene shoppingCartScene = ViewFactory.getScene("UserTransactionHistoryView");
        stage.setScene(shoppingCartScene);
        stage.setTitle("User Transaction History View");
        stage.show();
    }

    //CLOSE THE APPLICATION METHOD
    private void closeApplication() {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
}
