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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO profiles(email, country, address, profile_name, password, isAdmin) VALUES (?,?,?,?,?,? )");
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
                boolean isAdmin = resultSet.getBoolean("isAdmin");

                User user = new User(email, country, address, username, password, isAdmin);
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
                boolean isAdmin = resultSet.getBoolean("isadmin");

                User user = new User(email, country, address, username, password, isAdmin);
                result.add(user);
            }
            return result;
        } catch (SQLException e)
        {
        throw new RuntimeException(e);
        }
    }

    public User findUserByEmail(String email) throws SQLException {
        User user = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profiles WHERE email LIKE ?");
            statement.setString(1, "%" + email + "%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String country = resultSet.getString("country");
                String address = resultSet.getString("address");
                String username = resultSet.getString("profile_name");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isadmin");

                 user = new User(email, country, address, username, password, isAdmin);

            }
            return user;
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
            statement.executeUpdate();//idk if works
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return usernames;
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("UPDATE profiles SET country = ?, address = ?, profile_name = ?, password = ?, isAdmin = ? WHERE email = ?");
            statement.setString(1, user.getCountry());
            statement.setString(2,user.getAddress());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5,user.getIsAdmin());
            statement.setString(6,user.getEmail());

            statement.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE profiles WHERE email = ?");

            statement.setString(4, user.getUsername());
            statement.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public boolean loginCon(String email, String password)
            throws SQLException
    {
        User user;
        try (Connection connection = getConnection())
        {
            String SQL = "SELECT * FROM profiles WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(SQL);

            pstmt.setString(1, email);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next())
            {
                if (password.equals(resultSet.getString("password"))){
                    return true;
                }
            }

        }
        catch (Exception e)
        {
        }  return false;
    }

    public User getLoggedUser(String email, String password) throws SQLException
    {
        User loggedUser = null;
        if (loginCon(email, password))
        {
            loggedUser = findUserByEmail(email);
        }
        return loggedUser;
    }
}
