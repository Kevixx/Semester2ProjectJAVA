package GameApp.server.database;

import GameApp.server.model.modelClasses.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl instance;

    private UserDAOImpl() throws SQLException {

        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return ConnectDatabase.getConnection();
    }

    @Override
    public User create(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"user\"(email, country, address, user_name, \"password\", isadmin) VALUES (?,?,?,?,?,?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getCountry());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.setBoolean(6, user.getIsAdmin());

            statement.executeUpdate();
            return user;
        }
    }

    @Override
    public List<User> readByUsername(String username) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\" WHERE user_name LIKE ?");
            statement.setString(1, "%" + username + "%");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<User> result = new ArrayList<>();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String name = resultSet.getString("user_name");
                String address = resultSet.getString("address");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");

                User user = new User(email, country, address, name, password, isAdmin);
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByEmail(String email) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\" WHERE email = ?");

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String country = resultSet.getString("country");
                String address = resultSet.getString("address");
                String username = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isadmin");

                return new User(email, country, address, username, password, isAdmin);
            }
        }
        return null;
    }

    @Override
    public List<String> getAllUsernames() throws SQLException {

        List<String> usernames = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT user_name from \"user\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("user_name");
                usernames.add(username);
            }
            statement.executeUpdate();//idk if works
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usernames;
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("UPDATE \"user\" SET country = ?, address = ?, user_name = ?, \"password\" = ?, isadmin = ? WHERE email = ?");

            statement.setString(1, user.getCountry());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5, user.getIsAdmin());
            statement.setString(6, user.getEmail());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"user\" SET country = 'USER_BANNED', address = 'USER_BANNED', user_name = 'USER_BANNED', \"password\" = 'USER_BANNED', isadmin = false WHERE email = ?");

            statement.setString(1, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean loginCon(String email, String password) throws SQLException {

        try (Connection connection = getConnection()) {
            String SQL = "SELECT * FROM \"user\" WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (password.equals(resultSet.getString("password"))) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getLoggedUser(String email, String password) throws SQLException {
        User loggedUser = null;
        if (loginCon(email, password)) {
            loggedUser = findUserByEmail(email);
        }
        return loggedUser;
    }
      public List<User> getAllUsers() {
          {
              try (Connection connection = getConnection()) {
                  PreparedStatement statement = connection.prepareStatement(
                          "SELECT email, user_name, address, country FROM  \"user\" WHERE isadmin = false AND user_name != 'USER_BANNED'");
                  List<User> users = new ArrayList<>();
                  ResultSet resultSet = statement.executeQuery();

                  while (resultSet.next()) {
                      String email = resultSet.getString("email");
                      String username = resultSet.getString("user_name");
                      String address = resultSet.getString("address");
                      String country = resultSet.getString("country");

                      User user = new User(email, country, address, username, "", false);
                      users.add(user);
                  }
                  return users;
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
          }
      }
}
