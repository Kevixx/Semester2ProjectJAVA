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
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=gaming_application_database", "postgres", "andreea");
    }
    @Override
    public User create(User user) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO profiles(email, country, address, profile_name, password) VALUES (?,?,?,?,? )");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getCountry());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());

            statement.executeUpdate();
                return user;
        }
    }

    @Override
    public List<User> readByUsername(String username) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profiles WHERE profile_name LIKE ?");
            statement.setString(1, "%" + username + "%");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<User> result = new ArrayList<>();
            while(resultSet.next()) {
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String address = resultSet.getString("address");
                String password = resultSet.getString("password");

                User user = new User(email, country, address, username, password);
                result.add(user);
            }
            return result;
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByEmail(String email) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profiles WHERE email LIKE ?");
            statement.setString(1, "%" + email + "%");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<User> result = new ArrayList<>();
            while(resultSet.next()) {
                String country = resultSet.getString("country");
                String address = resultSet.getString("address");
                String username = resultSet.getString("profile_name");
                String password = resultSet.getString("password");

                User user = new User(email, country, address, username, password);
                result.add(user);
            }
            return result;
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllUsernames() throws SQLException {
        List<String> usernames = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT profile_name from profiles");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String username = resultSet.getString("profile_name");
                usernames.add(username);
            }
            statement.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return usernames;
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE profiles SET email = ?, country = ?, address = ?, profile_name = ?, password = ? WHERE username = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getCountry());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE profiles WHERE username = ?");

            statement.setString(4, user.getUsername());
            statement.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}