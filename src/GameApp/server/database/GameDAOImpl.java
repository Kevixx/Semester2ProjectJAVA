package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImpl implements GamesDAO {
    public GameDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=gaming_application_database", "postgres", "andreea");
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

            statement.setString(1, game.getTitle());
            statement.setString(2, game.getGenre());
            statement.setString(3, game.getDescription());
            statement.setDouble(4, game.getPrice());
            statement.setInt(5, game.getGame_id());

            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Game game) throws SQLException {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM games WHERE game_id = ?");

            statement.setInt(1, game.getGame_id());
            statement.executeUpdate();
        }
    }

}
