package GameApp.server.model;

import GameApp.server.database.UserDAO;
import GameApp.server.database.UserDAOImpl;
import GameApp.shared.model.User;

import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class UserServerModelManager implements UserServerModelManagerFactory {

    private UserDAO userDAO;
    private PropertyChangeSupport support;

    public UserServerModelManager() {
        userDAO = new UserDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addUser(User user) {
        try {
            this.userDAO.create(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getUsersToListView() {
        try {
            return userDAO.getAllUsernames();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean checkEmail(String email) {
        //email found in the system
        try {
            return userDAO.findUserByEmail(email) != null; //email not found in the system
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByEmail(String email) {
        try {
            return userDAO.findUserByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean login(String email, String password) {
        try {
            return userDAO.loginCon(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getLoggedUser(String email, String password) {
        try {
            return userDAO.getLoggedUser(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editUser(User user) {

        try {
            this.userDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(User user){
        try {
            this.userDAO.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
