package GameApp.server.database;

import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    User create(User user) throws SQLException;

    ArrayList<User> readByUsername(String username) throws SQLException;

    User findUserByEmail(String email) throws SQLException;

    ArrayList<String> getAllUsernames() throws SQLException;

    void update(User user) throws SQLException;

    void delete(User user) throws SQLException;

    boolean loginCon(String email, String password) throws SQLException;

    ArrayList<User> getAllUsers();

}
