package GameApp.client.views.GameView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameViewController implements ViewController
{

    private GameViewModel gameViewModel;
    private ViewHandler viewHandler;

    public Button libraryButton;
    public Button accountButton;
    public Button backButton;
    public ImageView listingImage;
    public Image listingImage2;

    public TextField descriptionTextField;
    public Label nameOfGameLabel;
    public Label priceOfGameLabel;

    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        this.gameViewModel = vmf.getGameViewModel();

        descriptionTextField.textProperty().bind(gameViewModel.descriptionTextFieldProperty());
        nameOfGameLabel.textProperty().bind(gameViewModel.titleLabelProperty());
        priceOfGameLabel.textProperty().bind(gameViewModel.priceLabelProperty());
        listingImage.imageProperty().bind(gameViewModel.pictureProperty());

    }

    public void backToMainShopView(ActionEvent actionEvent)
    {
        viewHandler.openMainShopView();
    }

    public void myLibrary(ActionEvent actionEvent)
    {

    }

    public void myAccount(ActionEvent event)
    {

    }
}