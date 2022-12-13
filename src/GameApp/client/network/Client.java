package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {
    void startClient();

    void addUser(User user);

    boolean checkEmail(String email);

    Game create(String title, String genre, String description, double price);

    Game readByID(int game_id);

    User findUserByEmail(String email);

    User getUser();

    void editUser(User user);

    List<Game> getAllGames();

    boolean login(String email, String password);

    User getLoggedUser(String email, String password);

    List<User> getAllUsers();

    void deleteUser(User user);


    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games);

    List<Game> getGamesByEmail(String email);

    List<Game> searchLikeTitleForEmail(String title, String email);

    void delete(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByEmail(String email);

    Transaction getTransactionByTransactionId(int transactionId);
    //TRANSACTION METHODS END

    //SHOPPING CART METHODS START
    void addGameToShoppingCart(int game_id);

    void removeGameFromShoppingCart(int game_id);

    void removeGameFromShoppingCart(Game game);

    void removeAllGamesFromCart();

    double getShoppingCartValue();
    //SHOPPING CART METHODS END


    List<Game> getGamesByTitle(String title);

    List<Game> getAllGamesFromShoppingCart();

    List<Game> getGamesByGenre(String genre);
}
