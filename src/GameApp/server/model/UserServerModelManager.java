package GameApp.server.model;

import GameApp.server.database.UserDAO;
import GameApp.server.database.UserDAOImpl;
import GameApp.server.model.ServerModelManagerFactory;
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
        List<User> allUsersWithThisEmail = UserDAOImpl.getInstance().findByEmail(email);
        if (allUsersWithThisEmail.size() == 0) {
            return false; //email not found in the system

        }
        else return true;//email found in the system


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
}
