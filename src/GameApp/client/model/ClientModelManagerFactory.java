package GameApp.client.model;

import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.sql.SQLException;

public interface ClientModelManagerFactory extends Subject
{
  void addUser(String email, String country, String address, String username, String password) throws
      SQLException;
  void userEdit(User user) throws SQLException;
}
