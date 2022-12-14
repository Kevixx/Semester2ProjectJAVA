package GameApp.server.model;

import GameApp.shared.model.Game;
import GameApp.shared.util.Subject;

import java.util.List;

public interface GameServerModelManagerFactory extends Subject {
    Game create(String title, String genre, String description, double price);

    List<Game> getGamesByGenre(String genre);

    List<Game> getGamesByTitle(String title);

    List<Game> getAllGames();

    Game readByID(int game_id);
}
