package GameApp.shared.networking;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RMIServer extends Remote {

    void registerCallback(ClientCallback ccb) throws RemoteException;

    void addUser(User user) throws SQLException, RemoteException;

    boolean checkEmail(String email) throws SQLException, RemoteException;

    Game readByID(int game_id) throws SQLException, RemoteException;

    List<Game> getAllGames() throws RemoteException, SQLException;

    User findUserByEmail(String email) throws RemoteException, SQLException;

    boolean login(String email, String password) throws RemoteException, SQLException;

    void editUser(User user) throws RemoteException, SQLException;

    User getLoggedUser(String email, String password) throws RemoteException, SQLException;

    List<User> getAllUsers() throws RemoteException, SQLException;

    void deleteUser(User user) throws RemoteException, SQLException;

    Game create(String title, String genre, String description, double price) throws SQLException, RemoteException;

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException;

    List<Game> getGamesByEmail(String email) throws SQLException, RemoteException;

    List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException;

    void delete(Transaction transaction) throws SQLException, RemoteException;

    List<Transaction> getAllTransactions() throws SQLException, RemoteException;

    List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException;

    Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException;
    //TRANSACTION METHODS END

    List<Game> getGamesByGenre(String genre) throws SQLException, RemoteException;

    List<Game> getGamesByTitle(String title) throws SQLException, RemoteException;
}
