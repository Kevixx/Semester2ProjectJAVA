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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RMIClient implements Client, ClientCallback {

    private RMIServer server;
    public PropertyChangeSupport support;
    private User user;

    private ArrayList<Game> shoppingCartArrayList;


    private String email, password;

    public RMIClient() {
        support = new PropertyChangeSupport(this);
        shoppingCartArrayList = new ArrayList<>();

    }

    @Override
    public void startClient() {
        Registry registry = null;
        try {
            UnicastRemoteObject.exportObject(this, 0);
            registry = LocateRegistry.getRegistry("localhost", 2910);
            server = (RMIServer) registry.lookup("ShopServer");
            //Not sure if we need callback functionality
            server.registerCallback(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    //SHOPPING CART METHODS START
    public void addGameToShoppingCart(int game_id)
    {
        Game addedGame = readByID(game_id);
        if (addedGame!=null)
        {
            if (!shoppingCartArrayList.contains(addedGame))
            shoppingCartArrayList.add(addedGame);
        }
    }

    public void removeGameFromShoppingCart(int game_id)
    {
        if (readByID(game_id)!=null)shoppingCartArrayList.remove(readByID(game_id));
    }

    public void removeGameFromShoppingCart(Game game)
    {
        shoppingCartArrayList.remove(game);
    }

    public void removeAllGamesFromCart()
    {
        shoppingCartArrayList.clear();
    }

    public ArrayList<Game> getShoppingCart()
    {
        return shoppingCartArrayList;
    }

    public double getShoppingCartValue()
    {
        double value = 0;
        for (int i = 0; i < shoppingCartArrayList.size(); i++)
        {
            value+=shoppingCartArrayList.get(i).getGamePrice();
        }
        return value;
    }
    //SHOPPING CART METHODS END

    @Override
    public List<Game> getGamesByTitle(String title) throws SQLException, RemoteException {
        return server.getGamesByTitle(title);
    }

    public ArrayList<Game> getAllGamesFromShoppingCart()
    {
        return shoppingCartArrayList;
    }

    @Override
    public List<Game> getGamesByGenre(String genre) throws SQLException, RemoteException {
        return server.getGamesByGenre(genre);
    }

    @Override
    public void update(String entry) throws RemoteException {
        //in case we need to fire events, change name

        support.firePropertyChange("NewChatEntry", null, entry);
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
        } catch (RemoteException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("RMI Client");
    }

    public boolean checkEmail(String email) {
        try {
            return server.checkEmail(email);
        } catch (RemoteException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Game> getAllGames() {
        try {
            return server.getAllGames();
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException();
        }
    }

    public Game readByID(int game_id)
    {
        try
        {
            return server.readByID(game_id);
        }
        catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUser(String email, String password)
    {
        try {
            if (server.login(email, password))
                user = server.findUserByEmail(email);

        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserByEmail(String email)
    {
        try {
            user = server.findUserByEmail(email);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    public boolean login(String email, String password)
    {
        this.email = email;
        this.password = password;
        user = getLoggedUser(email, password);
        try {
            return server.login(email, password);
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getLoggedUser(String email, String password) {
//    user = getLoggedUser(email, password);


        try {
            return server.getLoggedUser(email, password);
        } catch (RemoteException | SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public User getUser() {
        return user;
    }

    public void editUser(User user) {
        try {
            server.editUser(user);


        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers()
    {
        try {
            return server.getAllUsers();
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(User user)
    {
        try {
            server.deleteUser(user);
        } catch (RemoteException | SQLException e) {
            e.printStackTrace();
        }
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) throws SQLException, RemoteException {
        return server.create(usersEmail, games);
    }

    @Override
    public List<Game> getGamesByEmail(String email) throws SQLException, RemoteException {
        return server.getGamesByEmail(email);
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException, RemoteException {
        return server.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException, RemoteException {
        server.delete(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() throws SQLException, RemoteException {
        return server.getAllTransactions();
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) throws SQLException, RemoteException {
        return server.getAllTransactionsByEmail(email);
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) throws SQLException, RemoteException {
        return server.getTransactionByTransactionId(transactionId);
    }
    //TRANSACTION METHODS ENDS
}
