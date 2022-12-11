package GameApp.server.model;

import GameApp.server.database.UserDAO;
import GameApp.server.database.UserDAOImpl;
import GameApp.server.model.ServerModelManagerFactory;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServerModelManager implements ServerModelManagerFactory {


    private PropertyChangeSupport support;
    public UserServerModelManager() {
    }


    public void addUser(User user) throws SQLException {
        UserDAOImpl.getInstance().create(user);
    }


    public List<String> getUsersToListView() throws SQLException {
        return UserDAOImpl.getInstance().getAllUsernames();
    }

    public Boolean checkEmail(String email) throws SQLException {
        //email found in the system
        return UserDAOImpl.getInstance().findUserByEmail(email) != null; //email not found in the system
    }

    public User findUserByEmail(String email) throws SQLException
    {
        return UserDAOImpl.getInstance().findUserByEmail(email);
    }
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public boolean login(String email, String password) throws SQLException
    {
        return UserDAOImpl.getInstance().loginCon(email, password);
    }

    public User getLoggedUser(String email, String password) throws SQLException
    {
        return UserDAOImpl.getInstance().getLoggedUser(email, password);
    }

    public void editUser(User user) throws SQLException {

        UserDAOImpl.getInstance().update(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return UserDAOImpl.getInstance().getAllUsers();
    }

    public void deleteUser(User user) throws SQLException {

            UserDAOImpl.getInstance().delete(user);


    }
//Not needed here.
    @Override
    public List<Game> getGamesByGenre(String genre) throws SQLException {
        return null;
    }
}
