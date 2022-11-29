package GameApp.client.views;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
