package GameApp.server.database;

import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    User create(User user) throws SQLException;
    List<User> readByUsername(String username) throws SQLException;
    List<User> findByEmail(String email) throws SQLException;
    List<String> getAllUsernames() throws SQLException;
    void update(User user) throws SQLException;
    void delete(User user) throws SQLException;

}
