package GameApp.server.model;

import GameApp.server.database.GameDAO;
import GameApp.server.database.GameDAOImpl;
import GameApp.server.model.modelClasses.Game;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class GameServerModelManager implements GameServerModelManagerFactory {
    private PropertyChangeSupport support;
    private GameDAO game;

    //Constructor
    public GameServerModelManager() throws SQLException {
        game = new GameDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public List<Game> getAllGames() throws SQLException {
        return game.getAllGames();
    }
    @Override
    public Game readByID(int game_id) {
        try {
            return game.readByID(game_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }


    @Override
    public Game create(String title, String genre, String description, double price) throws SQLException {
        return game.create(title, genre, description, price);
    }

    @Override
    public List<Game> getGamesByGenre(String genre) throws SQLException {
        return game.getGamesByGenre(genre);
    }

    @Override
    public List<Game> getGamesByTitle(String title) throws SQLException {
        return game.getGamesByTitle(title);
    }
}
