package GameApp.client.network;

import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

public interface Client extends Subject
{
  void startClient();
  void addUser(User user);
  boolean checkEmail(String email);
}
