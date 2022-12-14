package GameApp.client.model;

import GameApp.shared.model.Game;
import GameApp.shared.model.Transaction;
import GameApp.shared.model.User;
import GameApp.shared.util.Subject;

import java.util.List;

public interface ClientModelManagerFactory extends Subject {
    void addUser(String email, String country, String address, String username, String password, boolean isAdmin);

    Game create(String title, String genre, String description, double price);

    Game readByID(int game_id);

    List<Game> getAllGames();

    void userEdit(User user);

    boolean checkEmail(String email);

    boolean login(String email, String password);

    User getLoggedUser(String email, String password);

    User getUser();

    List<User> getAllUsers();

    User findUserByEmail(String email);

    void deleteUser(User user);

    void setSelectedId(int id);

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games);

    List<Game> getGamesByEmail(String email);

    List<Game> searchLikeTitleForEmail(String title, String email);

    void delete(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByEmail(String email);

    List<Transaction> getAllTransactionsForThisClient();

    Transaction getTransactionByTransactionId(int transactionId);
    //TRANSACTION METHODS END

    int getSelectedPictureId();

    double getShoppingCartValue();

    void addGameToShoppingCart();

    void removeGameFromShoppingCart(int id);

    void removeGameFromShoppingCart(Game game);

    void removeAllGamesFromCart();

    List<Game> getAllGamesFromShoppingCart();

    List<Game> getGamesByGenre(String genre);

    List<Game> getGamesByTitle(String title);
}
