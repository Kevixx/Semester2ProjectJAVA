package GameApp.client.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ClientModelManagerFactory extends Subject
{
  void addUser(String email, String country, String address, String username, String password, boolean isAdmin) throws
      SQLException;
   Game readByID(int game_id) throws SQLException;
  List<Game> getAllGames()throws SQLException;
  void userEdit(User user) throws SQLException;
  boolean checkEmail(String email);
}
