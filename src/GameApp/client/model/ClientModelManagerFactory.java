package GameApp.client.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.util.Subject;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ClientModelManagerFactory extends Subject {
    void addUser(String email, String country, String address, String username, String password, boolean isAdmin) throws SQLException;

    Game create(String title, String genre, String description, double price) throws SQLException, RemoteException;

    Game readByID(int game_id) throws SQLException, RemoteException;

    List<Game> getAllGames() throws SQLException;

    void userEdit(User user);

    boolean checkEmail(String email);

    boolean login(String email, String password);

    User getLoggedUser(String email, String password);

    User getUser();

    List<User> getAllUsers() throws SQLException, RemoteException;

    User findUserByEmail(String email);

    void deleteUser(User user) throws SQLException, RemoteException;

    void setSelectedId(int id) throws SQLException, RemoteException;

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException;

    List<Game> getGamesByEmail(String email) throws SQLException, RemoteException;

    List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException;

    void delete(Transaction transaction) throws SQLException, RemoteException;

    List<Transaction> getAllTransactions() throws SQLException, RemoteException;

    List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException;

    Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException;
    //TRANSACTION METHODS END

    int getSelectedPictureId() throws SQLException, RemoteException;

    double getShoppingCartValue();

    void addGameToShoppingCart() throws SQLException, RemoteException;

    void removeGameFromShoppingCart(int id) throws SQLException, RemoteException;

    void removeGameFromShoppingCart(Game game) throws SQLException, RemoteException;

    void removeAllGamesFromCart() throws SQLException, RemoteException;

    List<Game> getAllGamesFromShoppingCart() throws SQLException, RemoteException;

    List<Game> getGamesByGenre(String genre) throws SQLException, RemoteException;

    List<Game> getGamesByTitle(String title) throws SQLException, RemoteException;

}
