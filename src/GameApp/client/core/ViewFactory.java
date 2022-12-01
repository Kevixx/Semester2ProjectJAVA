package GameApp.client.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import GameApp.client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory
{
  private static Map<String, Scene> scenes;
  private static Stage stage;

  static {
    scenes = new HashMap<>();
  }

  public static void init(Stage theStage) {
    stage = theStage;
    createScene("LoginView");
    createScene("RegisterView");
    createScene("MainShopView");
    createScene("MyAccountView");
    createScene("MyLibraryView");
  }

  //edit the paths and add extra views
  private static void createScene(String sceneName) {
    Scene scene = null;
    //change name here
    switch (sceneName) {
      case "LoginView":
        try {
          //change path here
          Parent root = loadFXML("../views/LoginView/LoginView.fxml");

          //change title
          stage.setTitle("Login");
          scene = new Scene(root);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "RegisterView":
        try {
          Parent root = loadFXML("../views/RegisterView/RegisterView.fxml");

          scene = new Scene(root);
          stage.setTitle("Register");

        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "MainShopView":
        try {
          Parent root = loadFXML("../views/MainShopView/MainShopView.fxml");

          scene = new Scene(root);
          stage.setTitle("Main Shop");

        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "MyAccountView":
        try {
          Parent root = loadFXML("../views/MyAccountView/MyAccountView.fxml");

          scene = new Scene(root);
          stage.setTitle("My Account");

        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "MyLibraryView":
        try {
          Parent root = loadFXML("../views/MyLibraryView/MyLibraryView.fxml");

          scene = new Scene(root);
          stage.setTitle("My Library");

        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
    }
    scenes.put(sceneName, scene);
  }

  private static Parent loadFXML(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewFactory.class.getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
    return root;
  }

  public static Scene getScene(String sceneName) {
    return scenes.get(sceneName);
  }
}
