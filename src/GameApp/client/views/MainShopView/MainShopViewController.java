package GameApp.client.views.MainShopView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainShopViewController implements ViewController {

    private MainShopViewModel mainShopViewModel;
    private ViewHandler viewHandler;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.mainShopViewModel = vmf.getMainShopViewModel();

        scrollPane.setFitToHeight(true);

        try
        {
            mainShopViewModel.insertGames(gridPane);
        }
        catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void imageClick(MouseEvent mouseEvent)
    {
        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();

        if (clickedNode instanceof ImageView)
        {
            ImageView image = (ImageView) clickedNode;

            String s = image.getImage().impl_getUrl();
            String fileName = "";
            String id = "";

            for (int i = 0; i < s.length(); i++)
            {
                fileName += s.charAt(i);
                if (s.charAt(i) == '/')
                {
                    fileName = "";
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
            catch (RemoteException | SQLException e)
            {
                throw new RuntimeException(e);
            }
            viewHandler.openGameView();
        }
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

    public void openShoppingCart()
    {
        viewHandler.openShopCartView();
    }

    public void logout(){
        viewHandler.openLoginView();
    }


    public void freeToPlay(MouseEvent mouseEvent) {
        showGenre("Free to Play");
    }

    public void earlyAccess(MouseEvent mouseEvent) {
        showGenre("Early Access");
    }

    public void action(MouseEvent mouseEvent) {
        showGenre("Action");
    }

    public void adventure(MouseEvent mouseEvent) {
        showGenre("Adventure");
    }

    public void casual(MouseEvent mouseEvent) {
        showGenre("Casual");
    }

    public void indie(MouseEvent mouseEvent) {
        showGenre("Indie");
    }

    public void massivelyMultiplayer(MouseEvent mouseEvent) {
        showGenre("MMO");
    }

    public void racing(MouseEvent mouseEvent) {
        showGenre("Racing");
    }

    public void vr(MouseEvent mouseEvent) {
        showGenre("VR");
    }

    public void rpg(MouseEvent mouseEvent) {
        showGenre("RPG");
    }

    public void simulation(MouseEvent mouseEvent) {
        showGenre("Simulation");
    }

    public void sports(MouseEvent mouseEvent) {
        showGenre("Sports");
    }

    public void strategy(MouseEvent mouseEvent) {
        showGenre("Strategy");
    }

    public void showGenre(String genre){
        try {
            mainShopViewModel.showGenre(gridPane,genre);
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
