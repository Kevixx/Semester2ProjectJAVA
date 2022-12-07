package GameApp.shared.networking;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIServer extends Remote {

    void registerCallback(ClientCallback ccb) throws RemoteException;

    void addUser(User user) throws SQLException, RemoteException;

    boolean checkEmail(String email) throws SQLException, RemoteException;

    Game readByID(int game_id) throws SQLException, RemoteException;

    ArrayList<Game> getAllGames() throws RemoteException, SQLException;

    User findUserByEmail(String email) throws RemoteException, SQLException;

    boolean login(String email, String password) throws RemoteException, SQLException;

    void editUser(User user) throws RemoteException, SQLException;

    User getLoggedUser(String email, String password) throws RemoteException, SQLException;

    //TRANSACTION METHODS
    Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException, RemoteException;

    ArrayList<Game> getGamesIdsByEmail(String email) throws SQLException, RemoteException;

    ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException, RemoteException;

    void delete(Transaction transaction) throws SQLException, RemoteException;
    //TRANSACTION METHODS END
}
