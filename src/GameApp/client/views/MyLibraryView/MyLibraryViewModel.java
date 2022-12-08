package GameApp.client.views.MyLibraryView;

import GameApp.client.model.ClientModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


public class MyLibraryViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    private int countColumns;
    private int countRows;

    public MyLibraryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
        countColumns = 0;
        countRows = 0;
    }

    public void insertGame(GridPane gridPane) throws SQLException, RemoteException {

        ArrayList<Game> games = clientModelManagerFactory.getGamesByEmail(clientModelManagerFactory.getUser().getEmail());

        if (games != null) {

            for (Game game : games) {

                AnchorPane anchorPane = new AnchorPane();

                ImageView imageView = new ImageView();
                Image image = null;

                try {
                    image = new Image("@../../GameApp/client/views/images/" + game.getGameId() + ".jpg");
                } catch (RuntimeException e) {
                    image = new Image("@../../GameApp/client/views/images/image_not_found.jpg");
                }

                imageView.setImage(image);

                Label labelTitle = new Label(game.getGameTitle());
                Label labelDescription = new Label(game.getGameDescription());

                imageView.setFitWidth(128);
                imageView.setFitHeight(158);

                anchorPane.getChildren().add(imageView);
                anchorPane.getChildren().add(labelTitle);
                anchorPane.getChildren().add(labelDescription);

                labelTitle.layoutYProperty().setValue(1.0);
                labelTitle.layoutXProperty().setValue(150);
                labelTitle.setPrefHeight(60);
                labelTitle.setPrefWidth(270);
                labelTitle.setFont(new Font("Century Gothic", 18));
                labelTitle.setWrapText(true);

                labelDescription.layoutYProperty().setValue(50);
                labelDescription.layoutXProperty().setValue(150);
                labelDescription.setPrefHeight(90);
                labelDescription.setPrefWidth(270);
                labelDescription.setFont(new Font("Century Gothic", 12));
                labelDescription.setWrapText(true);

                gridPane.add(anchorPane, countColumns, countRows);
                gridPane.setVgap(10);

                countColumns = (countColumns + 1) % 2;

                if (countColumns % 2 == 0) {
                    countRows++;
                }
                System.out.println("Column " + countColumns);
                System.out.println("Row " + countRows);
            }
        } else {
            Label label = new Label("                                                                                                                 NO GAMES FOUND");
            label.setFont(new Font("Century Gothic", 12));

            gridPane.add(label, 0, 2);
        }
    }
}