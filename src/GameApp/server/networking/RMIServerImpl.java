package GameApp.server.networking;

import GameApp.server.model.*;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.networking.ClientCallback;
import GameApp.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class RMIServerImpl implements RMIServer {
    private GameServerModelManagerFactory gameServerModelManagerFactory;
    private UserServerModelManagerFactory userServerModelManagerFactory;
    private TransactionServerModelManagerFactory transactionServerModelManagerFactory;

    public RMIServerImpl(GameServerModelManagerFactory gameServerModelManagerFactory, UserServerModelManagerFactory userServerModelManagerFactory, TransactionServerModelManagerFactory transactionServerModelManagerFactory)
            throws RemoteException {
        UnicastRemoteObject.exportObject(this, 2910);

        this.gameServerModelManagerFactory = gameServerModelManagerFactory;
        this.userServerModelManagerFactory = userServerModelManagerFactory;
        this.transactionServerModelManagerFactory = transactionServerModelManagerFactory;
    }

    public void startServer() {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(2910);
            registry.bind("ShopServer", this);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerCallback(ClientCallback ccb)
            throws RemoteException {
        gameServerModelManagerFactory.addListener("NewGameAdded", evt -> {
            try {
                ccb.update();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }
    @Override
    public void addUser(User user) {
        try {
            userServerModelManagerFactory.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean checkEmail(String email) {

        try {
            return userServerModelManagerFactory.checkEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Game readByID(int game_id) {
        return gameServerModelManagerFactory.readByID(game_id);
    }
    @Override
    public List<Game> getAllGames() throws SQLException {
        return gameServerModelManagerFactory.getAllGames();
    }
    @Override
    public User findUserByEmail(String email) {
        try {
            return userServerModelManagerFactory.findUserByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        try {
            return userServerModelManagerFactory.login(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public User getLoggedUser(String email, String password) throws RemoteException {
        try {
            return userServerModelManagerFactory.getLoggedUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void editUser(User user) throws RemoteException {
        try {
            userServerModelManagerFactory.editUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers()
    {
        try {
            return userServerModelManagerFactory.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteUser(User user) throws SQLException {
        userServerModelManagerFactory.deleteUser(user);
    }

    @Override
    public Game create(String title, String genre, String description, double price) throws SQLException {
        return gameServerModelManagerFactory.create(title,genre,description,price);
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.create(usersEmail, games);
    }

    @Override
    public List<Game> getGamesByEmail(String email) throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.getGamesByEmail(email);
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException, RemoteException {
        transactionServerModelManagerFactory.delete(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.getAllTransactions();
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.getAllTransactionsByEmail(email);
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException {
        return transactionServerModelManagerFactory.getTransactionByTransactionId(transactionId);
    }

    @Override
    public List<Game> getGamesByGenre(String genre) throws SQLException,RemoteException {
        return gameServerModelManagerFactory.getGamesByGenre(genre);
    }

    @Override
    public List<Game> getGamesByTitle(String title) throws SQLException, RemoteException {
        return gameServerModelManagerFactory.getGamesByTitle(title);
    }
    //TRANSACTION METHODS END
}