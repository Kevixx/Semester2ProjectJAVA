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
    @FXML
    private ScrollPane scrollPane;
    private MyLibraryViewModel myLibraryViewModel;
    private ViewHandler vha;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField urlField;

    private int countColumns;
    private int countRows;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.myLibraryViewModel = vmf.getMyLibraryViewModel();

        scrollPane.setFitToHeight(true);

        countColumns = 0;
        countRows = 0;
    }

    public void updateLibrary(MouseEvent actionEvent) throws SQLException, RemoteException {

        myLibraryViewModel.insertGame(gridPane);
    }

    public void openShoppingCart() {
        vha.openShopCartView();
    }
}
