package GameApp.client;

import GameApp.client.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    ViewHandler.getInstance().start();
  }
}
