package GameApp.client.network;

import GameApp.shared.model.Game;
import GameApp.shared.model.Transaction;
import GameApp.shared.model.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 * An interface to provide method signatures for RMIClient Class.
 *
 * @author Adrian Bugiel, Andreea Asimine, Kevin Kluka, Saran Singh
 * @version 1.0
 */
public interface Client extends Subject {

    /**
     * Starts the client and accesses remote server.
     */
    void startClient();

    /**
     * Adds user to a database.
     *
     * @param user added to the database
     */
    void addUser(User user);

    /**
     * True if email is present in the database.
     *
     * @param email user's email
     * @return Boolean representation of an email presence in a database
     * @throws RemoteException if a connection between RMI serve and client fails
     */
    boolean checkEmail(String email);

    /**
     * Inserts game into the database.
     *
     * @param title       game's title
     * @param genre       game's genre
     * @param description game's description
     * @param price       game's price
     * @return a Game object
     * @throws RemoteException if a connection between RMI serve and client fails
     */
    Game create(String title, String genre, String description, double price);

    /**
     * Searches for a matching game id and gets the matching object from a database.
     *
     * @param game_id an id of a game
     * @return Game object
     * @throws SQLException if a connection to a database fails or query statement fails
     */
    Game readByID(int game_id);

    /**
     * Gets user from database by an email.
     *
     * @param email user's email
     * @return User object
     * @throws RemoteException if a connection between RMI serve and client fails
     */
    User findUserByEmail(String email);

    /**
     * Gets the user.
     * @return User object
     */
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
