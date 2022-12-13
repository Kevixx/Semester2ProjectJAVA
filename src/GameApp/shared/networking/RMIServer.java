package GameApp.shared.networking;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {

    void registerCallback(ClientCallback ccb) throws RemoteException;

    void addUser(User user) throws RemoteException;

    boolean checkEmail(String email) throws RemoteException;

    Game readByID(int game_id) throws RemoteException;

    List<Game> getAllGames() throws RemoteException;

    User findUserByEmail(String email) throws RemoteException;

    boolean login(String email, String password) throws RemoteException;

    void editUser(User user) throws RemoteException;

    User getLoggedUser(String email, String password) throws RemoteException;

    List<User> getAllUsers() throws RemoteException;

    void deleteUser(User user) throws RemoteException;

    Game create(String title, String genre, String description, double price) throws RemoteException;

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games) throws RemoteException;

    List<Game> getGamesByEmail(String email) throws RemoteException;

    List<Game> searchLikeTitleForEmail(String title, String email) throws RemoteException;

    void delete(Transaction transaction) throws RemoteException;

    List<Transaction> getAllTransactions() throws RemoteException;

    List<Transaction> getAllTransactionsByEmail(String email) throws RemoteException;

    Transaction getTransactionByTransactionId(int transactionId) throws RemoteException;
    //TRANSACTION METHODS END

    List<Game> getGamesByGenre(String genre) throws RemoteException;

    List<Game> getGamesByTitle(String title) throws RemoteException;
}
