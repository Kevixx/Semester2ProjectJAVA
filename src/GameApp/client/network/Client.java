package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Client extends Subject {
    void startClient();

    void addUser(User user);

    boolean checkEmail(String email);
    Game create(String title, String genre, String description, double price) throws SQLException, RemoteException;

    Game readByID(int game_id) throws SQLException, RemoteException;

    User findUserByEmail(String email);

    User getUser();

    void editUser(User user) throws SQLException, RemoteException;

    List<Game> getAllGames();

    boolean login(String email, String password);

    User getLoggedUser(String email, String password) throws SQLException, RemoteException;

    List<User> getAllUsers() throws SQLException, RemoteException;

    void deleteUser(User user) throws SQLException, RemoteException;


    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException;

    List<Game> getGamesByEmail(String email) throws SQLException, RemoteException;

    List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException;

    void delete(Transaction transaction) throws SQLException, RemoteException;

    List<Transaction> getAllTransactions() throws SQLException, RemoteException;

    List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException;

    Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException;
    //TRANSACTION METHODS END

    //SHOPPING CART METHODS START
    void addGameToShoppingCart(int game_id) throws SQLException, RemoteException;
    void removeGameFromShoppingCart(int game_id) throws SQLException, RemoteException;
    void removeGameFromShoppingCart(Game game) throws SQLException, RemoteException;
    void removeAllGamesFromCart();
    double getShoppingCartValue();
    //SHOPPING CART METHODS END



    List<Game> getGamesByTitle(String title) throws SQLException, RemoteException;
    ArrayList<Game> getAllGamesFromShoppingCart() throws SQLException, RemoteException;
    List<Game> getGamesByGenre(String genre) throws SQLException, RemoteException;



}
