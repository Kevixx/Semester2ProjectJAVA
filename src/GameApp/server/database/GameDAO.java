package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GameDAO {
    Game create(String title, String genre, String description, double price) throws SQLException;

    ArrayList<Game> getAllGames() throws SQLException;

    Game readByID(int game_id) throws SQLException;

    ArrayList<Game> readByTitle(String searchString) throws SQLException;

    void update(Game game) throws SQLException;

    void delete(Game game) throws SQLException;

    ArrayList<Game> getGamesByGenre(String genre) throws SQLException;

    ArrayList<Game> getGamesByTitle(String title) throws SQLException;
}
