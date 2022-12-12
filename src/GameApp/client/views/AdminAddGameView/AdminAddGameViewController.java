package GameApp.client.views.AdminAddGameView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.AdminMainShopView.AdminMainShopViewModel;
import GameApp.client.views.ViewController;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminAddGameViewController implements ViewController {
    public TextField titleField;
    public TextArea descriptionArea;
    public TextField genreField;
    public TextField priceField;

    public Label errorLabel;

    private ViewHandler viewHandler;
    private AdminAddGameViewModel adminAddGameViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
        adminAddGameViewModel = vmf.getAdminAddGameViewModel();
    }

    public void mainStoreView(MouseEvent mouseEvent) {
        viewHandler.openAdminMainShopView();
    }

    public void libraryView(MouseEvent mouseEvent) {
        viewHandler.openMyLibraryView();
    }

    public void AdminMyAccountView(MouseEvent mouseEvent) {
        viewHandler.openMyAccountView();
    }

    public void openLoginView(MouseEvent mouseEvent) {
        viewHandler.openLoginView();
    }

    public void save(MouseEvent mouseEvent) {
        errorLabel.setText("");

        if (titleField.getText().equals("") || descriptionArea.getText().equals("") || genreField.getText().equals("") || priceField.getText().equals("")) {
            errorLabel.setText("Field cannot be empty!");

        } else if (descriptionArea.getText().toCharArray().length > 1000) {
            errorLabel.setText("Max 1000 character in description exceeded!");
        } else if (
                titleField.getText().toCharArray().length > 50 || genreField.getText().toCharArray().length > 50) {
            errorLabel.setText("Max 50 character exceeded!");
        } else if (Double.parseDouble(priceField.getText()) > 9999.99) {
            errorLabel.setText("Price is too high!");
        } else {
            adminAddGameViewModel.saveGame(errorLabel, titleField.getText(), descriptionArea.getText(), genreField.getText(), priceField.getText());
        }
    }

    public void clearField(MouseEvent mouseEvent) {
        errorLabel.setText("");
    }
}
