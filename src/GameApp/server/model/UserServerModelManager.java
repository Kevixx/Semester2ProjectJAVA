package GameApp.server.model;

import GameApp.server.database.UserDAO;
import GameApp.server.database.UserDAOImpl;
import GameApp.server.model.ServerModelManagerFactory;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

public class UserServerModelManager implements ServerModelManagerFactory {


    public UserServerModelManager() {
    }


    public void addUser(User user) throws SQLException {
        UserDAOImpl.getInstance().create(user);
    }


    public List<String> getUsersToListView() throws SQLException {
        return UserDAOImpl.getInstance().getAllUsernames();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
