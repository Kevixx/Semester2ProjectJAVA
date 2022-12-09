package GameApp.client.network;

import GameApp.server.model.modelClasses.Game;
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
    private String email, password;

    public RMIClient() {
        support = new PropertyChangeSupport(this);

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

    public ArrayList<Game> getAllGames() {
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

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException, RemoteException {
        return server.create(usersEmail, games);
    }

    @Override
    public ArrayList<Game> getGamesIdsByEmail(String email) throws SQLException, RemoteException {
        return server.getGamesIdsByEmail(email);
    }

    @Override
    public ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException, RemoteException {
        return server.searchLikeTitleGetIds(title);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException, RemoteException {
        server.delete(transaction);
    }
    //TRANSACTION METHODS ENDS
}
