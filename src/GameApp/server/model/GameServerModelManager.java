package GameApp.server.model;

import GameApp.server.database.GameDAO;
import GameApp.server.database.GameDAOImpl;
import GameApp.shared.model.Game;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class GameServerModelManager implements GameServerModelManagerFactory {
    private PropertyChangeSupport support;
    private GameDAO game;

    //Constructor
    public GameServerModelManager() {
        game = new GameDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public List<Game> getAllGames()  {
        try {
            return game.getAllGames();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public Game create(String title, String genre, String description, double price) {
        Game gameCreated = null;
        try {
            gameCreated = game.create(title, genre, description, price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        support.firePropertyChange("NewGameAdded", null, gameCreated);
        return gameCreated;
    }

    @Override
    public List<Game> getGamesByGenre(String genre) {
        try {
            return game.getGamesByGenre(genre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        try {
            return game.getGamesByTitle(title);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
