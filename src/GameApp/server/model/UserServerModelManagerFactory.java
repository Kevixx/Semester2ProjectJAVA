package GameApp.server.model;

import GameApp.server.model.modelClasses.User;

import java.util.List;

public interface UserServerModelManagerFactory {
    void addUser(User user);

    List<String> getUsersToListView();

    Boolean checkEmail(String email);

    User findUserByEmail(String email);

    boolean login(String email, String password);

    User getLoggedUser(String email, String password);

    void editUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);
}
