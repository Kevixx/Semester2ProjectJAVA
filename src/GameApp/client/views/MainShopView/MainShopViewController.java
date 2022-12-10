package GameApp.client.views.MainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.rmi.RemoteException;
import java.sql.SQLException;

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

    public void backToMainShopView(ActionEvent actionEvent) {
        viewHandler.openMainShopView();
    }

    public void imageClick(MouseEvent mouseEvent)
    {

    String s = ((ImageView)mouseEvent.getSource()).getImage().impl_getUrl();
    String fileName="";
    String id="";

        for (int i = 0; i < s.length(); i++)
        {
            fileName += s.charAt(i);
            if (s.charAt(i) == '/')
            {
                fileName ="";
            }
        }
        for (int i = 0; i < fileName.length(); i++)
        {
            if (fileName.charAt(i) == '.')
            {
                break;
            }
            id += fileName.charAt(i);
        }

        int gameId = Integer.parseInt(id);

        try
        {
            mainShopViewModel.setSelectedId(gameId);
        }
        catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
        viewHandler.openGameView();
    }

    public void openShoppingCart()
    {
        viewHandler.openShopCartView();
    }

    public void logout(){
        viewHandler.openLoginView();
    }

}
