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
        stage.show();
    }

    public void openRegisterView() {

        Scene registerViewScene = ViewFactory.getScene("RegisterView");
        stage.setScene(registerViewScene);
        stage.show();
    }

    public void openMainShopView() {

        Scene mainShopViewScene = ViewFactory.getScene("MainShopView");
        stage.setScene(mainShopViewScene);
        stage.show();
    }

    public void openMyAccountView() {
        Scene myAccountViewScene = ViewFactory.getScene("MyAccountView");
        stage.setScene(myAccountViewScene);
        stage.show();
    }

    public void openMyLibraryView() {
        Scene myLibraryViewScene = ViewFactory.getScene("MyLibraryView");
        stage.setScene(myLibraryViewScene);
        stage.show();

    }

    public void openGameView() {

        Scene gameViewScene = ViewFactory.getScene("GameView");
        stage.setScene(gameViewScene);
        stage.show();
    }

    public void openAdminMainShopView() {
        Scene adminMainShopViewScene = ViewFactory.getScene("AdminMainShopView");
        stage.setScene(adminMainShopViewScene);
        stage.show();
    }

    public void openAdminUserListView() {
        Scene adminUserListScene = ViewFactory.getScene("AdminUserListView");
        stage.setScene(adminUserListScene);
        stage.show();
    }
    public void openShopCartView() {
        Scene shoppingCartScene = ViewFactory.getScene("ShoppingCartView");
        stage.setScene(shoppingCartScene);
        stage.show();

        closeApplication();
    }

    public void openPaymentView() {
        Scene paymentScene = ViewFactory.getScene("PaymentView");
        stage.setScene(paymentScene);

        closeApplication();
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
