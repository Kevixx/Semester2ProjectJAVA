package GameApp.client.views.MyLibraryView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class MyLibraryViewController implements ViewController {

    private MyLibraryViewModel myLibraryViewModel;
    private ViewHandler vha;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

        this.vha = vh;
        this.myLibraryViewModel = vmf.getMyLibraryViewModel();

        scrollPane.setFitToHeight(true);

        myLibraryViewModel.addListener("Refresh", event -> {
            try {
                needUpdate(event);
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void needUpdate(PropertyChangeEvent event) throws SQLException, RemoteException {
        update();
    }

    public void update() throws SQLException, RemoteException {
        myLibraryViewModel.insertGame(gridPane);
    }

    public void updateLibrary(MouseEvent actionEvent) throws SQLException, RemoteException {
        update();
    }

    public void openShoppingCart(MouseEvent mouseEvent) {
        vha.openShopCartView();
    }

    public void openMyAccountView(MouseEvent mouseEvent) {
        vha.openMyAccountView();
    }

    public void openStoreView(MouseEvent mouseEvent) {
        vha.openMainShopView();
    }
}
