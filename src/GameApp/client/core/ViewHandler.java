package GameApp.client.core;

import javafx.scene.Scene;
import javafx.stage.Stage;

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
        //openMyLibraryView();
        openLoginView();
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
}
