package GameApp.client.views.MainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


import java.awt.event.MouseEvent;


public class MainShopViewController implements ViewController {

    private MainShopViewModel mainShopViewModel;
    private ViewHandler viewHandler;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.mainShopViewModel = vmf.getMainShopViewModel();
    }


    @FXML
    private void myAccount() {viewHandler.openMyAccountView();
    }
    @FXML
    private void myLibrary() {viewHandler.openMyLibraryView();
    }

    public void openGame() {

        viewHandler.openGameView();
    }

    public void backToMainShopView(ActionEvent actionEvent) {
        viewHandler.openMainShopView();
    }



    public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getSource());
      System.out.println(((ImageView)mouseEvent.getSource()).getImage().impl_getUrl());
        openGame();
    }

}
