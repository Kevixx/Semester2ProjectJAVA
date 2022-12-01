package GameApp.client.views.GameView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.MainShopView.MainShopViewModel;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameViewController implements ViewController {
    private GameViewModel gameViewModel;
    private ViewHandler viewHandler;

    @FXML
    private TextField descriptionTextField;
    @FXML
    Label imageLabel, nameOfGameLabel;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.gameViewModel = vmf.getGameViewModel();
    }


    public void backToMainShopView(ActionEvent actionEvent) {
        viewHandler.openMainShopView();
    }
}
