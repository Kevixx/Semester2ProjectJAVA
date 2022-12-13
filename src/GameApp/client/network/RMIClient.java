package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.ShoppingCart;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;
import GameApp.shared.networking.ClientCallback;
import GameApp.shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback {

    private RMIServer server;
    public PropertyChangeSupport support;
    private User user;

    private ShoppingCart shoppingCart;

    public RMIClient() {
        support = new PropertyChangeSupport(this);
        shoppingCart = new ShoppingCart();

    }

    @Override
    public void startClient() {
        Registry registry = null;
        try {
            UnicastRemoteObject.exportObject(this, 0);
            registry = LocateRegistry.getRegistry("localhost", 2910);
            server = (RMIServer) registry.lookup("ShopServer");
            server.registerCallback(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void addGameToShoppingCart(int game_id) {
        Game addedGame = readByID(game_id);
        if (addedGame != null) {

            if (!shoppingCart.contains(addedGame)) {
                shoppingCart.addGame(addedGame);
            }
        }
    }

    public void removeGameFromShoppingCart(int game_id) {
        if (readByID(game_id) != null) shoppingCart.removeGame(readByID(game_id));
    }

    public void removeGameFromShoppingCart(Game game) {
        shoppingCart.removeGame(game);
    }

    public void removeAllGamesFromCart() {
        shoppingCart.clearCart();
    }


    public double getShoppingCartValue() {
        return shoppingCart.getShoppingCartValue();
    }
    //SHOPPING CART METHODS END

    @Override
    public List<Game> getGamesByTitle(String title) {
        try {
            return server.getGamesByTitle(title);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getAllGamesFromShoppingCart() {
        return shoppingCart.getGames();
    }

    @Override
    public List<Game> getGamesByGenre(String genre) {
        try {
            return server.getGamesByGenre(genre);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        support.firePropertyChange("NewGameAdded", null, 1);
    }

    @Override
    public void addListener(String eventName,
                            PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName,
                               PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public void addUser(User user) {
        try {
            server.addUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("RMI Client");
    }

    public boolean checkEmail(String email) {
        try {
            return server.checkEmail(email);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Game create(String title, String genre, String description, double price) {
        try {
            return server.create(title, genre, description, price);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getAllGames() {
        try {
            return server.getAllGames();
        } catch (RemoteException e) {
            throw new RuntimeException();
        }
    }

    public Game readByID(int game_id) {
        try {
            return server.readByID(game_id);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUser(String email, String password) {
        try {
            if (server.login(email, password))
                user = server.findUserByEmail(email);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserByEmail(String email) {
        try {
            return server.findUserByEmail(email);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean login(String email, String password) {

        user = getLoggedUser(email, password);
        try {
            return server.login(email, password);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getLoggedUser(String email, String password) {

        try {
            return server.getLoggedUser(email, password);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser() {
        return user;
    }

    public void editUser(User user) {
        try {
            server.editUser(user);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            return server.getAllUsers();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(User user) {
        try {
            server.deleteUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) {
        try {
            return server.create(usersEmail, games);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> getGamesByEmail(String email) {
        try {
            return server.getGamesByEmail(email);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) {
        try {
            return server.searchLikeTitleForEmail(title, email);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Transaction transaction) {
        try {
            server.delete(transaction);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        try {
            return server.getAllTransactions();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) {
        try {
            return server.getAllTransactionsByEmail(email);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) {
        try {
            return server.getTransactionByTransactionId(transactionId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    //TRANSACTION METHODS ENDS
}
