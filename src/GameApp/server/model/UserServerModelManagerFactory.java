package GameApp.server.model;

import GameApp.server.model.modelClasses.User;
import java.sql.SQLException;
import java.util.List;

public interface UserServerModelManagerFactory {
    void addUser(User user) throws SQLException;

    List<String> getUsersToListView() throws SQLException;

    Boolean checkEmail(String email) throws SQLException;

    User findUserByEmail(String email) throws SQLException;

    boolean login(String email, String password) throws SQLException;

    User getLoggedUser(String email, String password) throws SQLException;

    void editUser(User user) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void deleteUser(User user) throws SQLException;
}
