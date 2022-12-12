package GameApp.server.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.shared.util.Subject;

import java.sql.SQLException;
import java.util.List;

public interface GameServerModelManagerFactory extends Subject {
    Game create(String title, String genre, String description, double price) throws SQLException;

    List<Game> getGamesByGenre(String genre) throws SQLException;

    List<Game> getGamesByTitle(String title) throws SQLException;
    List<Game> getAllGames() throws SQLException;
    Game readByID(int game_id);
}
