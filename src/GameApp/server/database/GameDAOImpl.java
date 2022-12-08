package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImpl implements GameDAO {
    private static GameDAOImpl instance;
    public GameDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=gaming_application_database", "postgres", "andreea");
    }

    public static synchronized GameDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new GameDAOImpl();
        }
        return instance;
    }

    public ArrayList<Game> getAllGames(){

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "(SELECT game_id, title, genre, description, price, image FROM game)");
            ArrayList<Game> games = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int game_id = resultSet.getInt("game_id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");

                Game game = new Game(game_id, title, genre, description, price);
                games.add(game);
            }
            return games;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Game create(String title,String genre, String description, double price) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO games(title, description, price) VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setString(3, description);
            statement.setDouble(4, price);
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {

                return new Game(keys.getInt(1), title, genre, description, price);
            } else {
                throw new SQLException("No key has been generated");
            }
        }
    }

    @Override
    public Game readByID(int game_id) throws SQLException {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE game_id = ?");

            statement.setInt(1, game_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String genre = resultSet.getString("genre");
                String name = resultSet.getString("title");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                return new Game(id, name,genre, description, price);
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Game> readByTitle(String searchString) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM games WHERE title LIKE ?");

            statement.setString(1, "%" + searchString + "%");

            ResultSet resultSet = statement.executeQuery();
            List<Game> games = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Game game = new Game(id, title,genre, description, price);
                games.add(game);
            }
            return games;
        }
    }

    @Override
    public void update(Game game) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE games SET title = ?, genre =?,description = ?, price = ? WHERE game_id= ?");

            statement.setString(1, game.getGameTitle());
            statement.setString(2, game.getGameGenre());
            statement.setString(3, game.getGameDescription());
            statement.setDouble(4, game.getGamePrice());
            statement.setInt(5, game.getGameId());

            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Game game) throws SQLException {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM games WHERE game_id = ?");

            statement.setInt(1, game.getGameId());
            statement.executeUpdate();
        }
    }
}
