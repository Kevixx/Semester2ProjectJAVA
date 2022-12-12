package GameApp.server.model;

import GameApp.server.database.UserDAO;
import GameApp.server.database.UserDAOImpl;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class UserServerModelManager implements UserServerModelManagerFactory {

    private UserDAO user;
    private PropertyChangeSupport support;

    public UserServerModelManager() throws SQLException {
        user = new UserDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addUser(User user) throws SQLException {
        this.user.create(user);
    }

    @Override
    public List<String> getUsersToListView() throws SQLException {
        return user.getAllUsernames();
    }

    @Override
    public Boolean checkEmail(String email) throws SQLException {
        //email found in the system
        return user.findUserByEmail(email) != null; //email not found in the system
    }

    @Override
    public User findUserByEmail(String email) throws SQLException {
        return user.findUserByEmail(email);
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
        return user.loginCon(email, password);
    }

    @Override
    public User getLoggedUser(String email, String password) throws SQLException {
        return user.getLoggedUser(email, password);
    }

    @Override
    public void editUser(User user) throws SQLException {

        this.user.update(user);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return user.getAllUsers();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        this.user.delete(user);
    }
}
