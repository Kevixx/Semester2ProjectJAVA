package GameApp.client.views.AdminAddGameView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.scene.control.Label;

public class AdminAddGameViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;

    public AdminAddGameViewModel(ClientModelManagerFactory clientModelManagerFactory) {

        this.clientModelManagerFactory = clientModelManagerFactory;
    }

    public void saveGame(Label errorLabel, String title, String description, String genre, String price) {
        try {
            if (clientModelManagerFactory.getGamesByTitle(title).size() == 0) {

                clientModelManagerFactory.create(title, genre, description, Double.parseDouble(price));
                errorLabel.setText("Game Saved!");

            } else errorLabel.setText("Game already exist in database!");

        } catch (RuntimeException e) {
            errorLabel.setText("Wrong price format!");
        }
    }
}
