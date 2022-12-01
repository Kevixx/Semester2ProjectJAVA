package GameApp.client.views.MyLibraryView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class MyLibraryViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    private int countColumns;
    private int countRows;

    public MyLibraryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
        countColumns = 0;
        countRows = 0;
    }

    public void insertGame(GridPane gridPane, String url) {

        ImageView imageView = new ImageView();
        Image image = new Image("@../../GameApp/client/views/images/gtav.jpg");
        imageView.setImage(image);

        imageView.setFitWidth(128);
        imageView.setFitHeight(158);

        gridPane.add(imageView, countColumns, countRows);

        gridPane.setHgap(30);
        gridPane.setVgap(30);

        countColumns = (countColumns + 1) % 3;

        if (countColumns % 3 == 0) {
            countRows++;

        }
        System.out.println("Column " + countColumns);
        System.out.println("Row " + countRows);
    }
}