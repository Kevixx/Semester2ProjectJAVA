package GameApp.server.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.shared.util.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ServerModelManagerFactory extends Subject
{
    List<Game> getGamesByGenre(String genre) throws SQLException;

}
