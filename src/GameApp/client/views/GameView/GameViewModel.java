package GameApp.client.views.GameView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import javafx.beans.property.*;

import javafx.scene.image.ImageView;
import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class GameViewModel
{

    private StringProperty descriptionTextField;
    private StringProperty titleLabel;
    private StringProperty priceLabel;
    private String pictureURL;


    private ObjectProperty pictureProperty;

    private ClientModelManagerFactory clientModelManagerFactory;

    public GameViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
        clientModelManagerFactory.addListener("NewPictureSelected", this::onNewImageClicked);

        descriptionTextField = new SimpleStringProperty("TestDescription");
        titleLabel = new SimpleStringProperty("TestTitle");
        priceLabel = new SimpleStringProperty("0");
        pictureURL = ("@../../GameApp/client/views/images/1.jpg");

        pictureProperty = new SimpleObjectProperty(new ImageView(pictureURL).imageProperty().getValue());

//        image_not_found

    }

    public void onNewImageClicked(PropertyChangeEvent evt)
    {
        Game selectedGame;
        try
        {
            selectedGame = clientModelManagerFactory.readByID((int) evt.getNewValue());
        }
        catch (RemoteException | SQLException e)
        {
            System.out.println("Cannot fetch selected item's data");
            throw new RuntimeException(e);
        }
        if (selectedGame != null)
        {
            titleLabel.setValue(selectedGame.getGameTitle());
            descriptionTextField.setValue(selectedGame.getGameDescription());
            priceLabel.setValue(Double.toString(selectedGame.getGamePrice()));
            pictureURL = selectedGame.getPictureURL();
            pictureProperty.setValue(new ImageView(pictureURL).imageProperty().getValue());

        }
    }
    public StringProperty titleLabelProperty()
    {
        return titleLabel;
    }
    public StringProperty descriptionTextFieldProperty()
    {
        return descriptionTextField;
    }

    public StringProperty priceLabelProperty()
    {
        return priceLabel;
    }

    public ObjectProperty pictureProperty()
    {

        return pictureProperty;
    }


}

