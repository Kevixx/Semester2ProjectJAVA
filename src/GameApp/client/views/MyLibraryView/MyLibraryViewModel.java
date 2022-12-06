package GameApp.client.views.MyLibraryView;

import GameApp.client.model.ClientModelManagerFactory;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;


public class MyLibraryViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    private int countColumns;
    private int countRows;

    public MyLibraryViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
        countColumns = 0;
        countRows = 0;
    }

//    <AnchorPane prefHeight="200.0" prefWidth="200.0">
//    <children>
//       <ImageView fitHeight="150.0" fitWidth="150.0" pickOnBounds="true" preserveRatio="true" />
//       <Label layoutX="147.0" layoutY="1.0" prefHeight="60.0" prefWidth="150.0" text="GTAVjhsdkjsdkjksdjkjsdkjsdkjdskjskdj" wrapText="true">
//          <font>
//             <Font size="18.0" />
//          </font>
//       </Label>
//       <Label layoutX="150.0" layoutY="59.0" prefHeight="85.0" prefWidth="145.0" text="lkjsldjlkajdkljsalkdjlkasjdkljsalkdjlkasjdlkjasldkjlkasjdlkjsalkjdlkjalksjdlkjaslkdjlakjsdlkjsalkj" wrapText="true" />
//     </children>
//   </AnchorPane>

    public void insertGame(GridPane gridPane, String url) {

        AnchorPane anchorPane = new AnchorPane();

        ImageView imageView = new ImageView();
        Image image = new Image("@../../GameApp/client/views/images/" + url + ".jpg");
        imageView.setImage(image);

        Label labelTitle = new Label("GTAV");
        Label labelDescription = new Label("kjsdkjsdlkjlksdj sdkjklsdjkldsj lkjsdjklsjdl lkjdsjklsdj dslkjsdlkjlksdj jklashkjdhsa jkdshjjdsahk djhsdajkha dkjshajkdhsakj kjhsabjkdahks dkjsahjkdsh kjashdjk dsajkhkjasd kjsahdkjh hkjdash kjsdhkjasdhkjh shdhasdjkhsa d");

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
        gridPane.setHgap(30);
        gridPane.setVgap(30);

        countColumns = (countColumns + 1) % 2;

        if (countColumns % 2 == 0) {
            countRows++;
        }
        System.out.println("Column " + countColumns);
        System.out.println("Row " + countRows);
    }
}