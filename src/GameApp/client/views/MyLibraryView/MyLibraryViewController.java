package GameApp.client.views.MyLibraryView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MyLibraryViewController implements ViewController {

    private MyLibraryViewModel myLibraryViewModel;
    private ViewHandler vh;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.myLibraryViewModel = vmf.getMyLibraryViewModel();

        scrollPane.setFitToHeight(true);
    }

    public void updateLibrary(MouseEvent actionEvent) throws SQLException, RemoteException {

        myLibraryViewModel.insertGame(gridPane);
    }

    public void openMyAccountView(MouseEvent mouseEvent) {
        vh.openMyAccountView();
    }

    public void openStoreView(MouseEvent mouseEvent) {
        vh.openMainShopView();
    }
}
