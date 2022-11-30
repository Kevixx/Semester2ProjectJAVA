package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;

import java.sql.SQLException;
import java.util.List;

public interface GamesDAO {
    Game create(String title,String genre, String description, double price) throws SQLException;

    Game readByID(int game_id) throws SQLException;

    List<Game> readByTitle(String searchString) throws SQLException;

    void update(Game game) throws SQLException;

    void delete(Game game) throws SQLException;
}
