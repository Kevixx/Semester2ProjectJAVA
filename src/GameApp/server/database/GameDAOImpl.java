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
        return ConnectDatabase.getConnection();
    }

    public static synchronized GameDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new GameDAOImpl();
        }
        return instance;
    }

    public ArrayList<Game> getAllGames() {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "(SELECT g.game_id, g.title, d.description, g2.genre, g.price\n" +
                            "FROM game g\n" +
                            "         join description d on g.game_id = d.game_id\n" +
                            "         join genre g2 on g.game_id = g2.game_id\n" +
                            "GROUP BY g.game_id, g.title, d.description, g2.genre, g.price)");
            ArrayList<Game> games = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int game_id = resultSet.getInt("game_id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");


                Game game = new Game(game_id, title, genre, description, price);
                games.add(game);
            }
            return games;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Game create(String title, String genre, String description, double price) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO game(title, price) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, title);
            statement.setDouble(2, price);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {

                int id = statement.getGeneratedKeys().getInt(1);

                statement = connection.prepareStatement("INSERT INTO description(game_id, description) VALUES (?,?)");

                statement.getGeneratedKeys().next();
                statement.setInt(1, id);
                statement.setString(2, description);
                statement.executeUpdate();

                statement = connection.prepareStatement("INSERT INTO genre(game_id, genre) VALUES (?,?)");

                statement.getGeneratedKeys().next();
                statement.setInt(1, id);
                statement.setString(2, genre);
                statement.executeUpdate();

                return new Game(id, title, genre, description, price);

            } else {
                throw new SQLException("Keys has not been generated!");
            }
        }
    }

    @Override
    public Game readByID(int game_id) throws SQLException {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT g.game_id, g.title, d.description, g2.genre, g.price\n" +
                    "FROM game g\n" +
                    "         join description d on g.game_id = d.game_id\n" +
                    "         join genre g2 on g.game_id = g2.game_id\n" +
                    "WHERE g.game_id = ?\n" +
                    "GROUP BY g.game_id, g.title, d.description, g2.genre, g.price");

            statement.setInt(1, game_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String genre = resultSet.getString("genre");
                String name = resultSet.getString("title");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                return new Game(id, name, genre, description, price);
            } else {
                return null;
            }
        }
    }

    @Override
    public ArrayList<Game> readByTitle(String searchString) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT g.game_id, g.title, d.description, g2.genre, g.price\n" +
                    "FROM game g\n" +
                    "         join description d on g.game_id = d.game_id\n" +
                    "         join genre g2 on g.game_id = g2.game_id\n" +
                    "WHERE g.title LIKE ?\n" +
                    "GROUP BY g.game_id, g.title, d.description, g2.genre, g.price");

            statement.setString(1, "%" + searchString + "%");

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Game> games = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Game game = new Game(id, title, genre, description, price);
                games.add(game);
            }
            return games;
        }
    }


    @Override
    public void update(Game game) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE game SET title = ?, genre =?,description = ?, price = ? WHERE game_id= ?");

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM game WHERE game_id = ?");

            statement.setInt(1, game.getGameId());
            statement.executeUpdate();
        }
    }

    @Override
    public ArrayList<Game> getGamesByGenre(String genre) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT g.game_id, g.title, d.description, g2.genre, g.price\n" +
                    "FROM game g\n" +
                    "         join description d on g.game_id = d.game_id\n" +
                    "         join genre g2 on g.game_id = g2.game_id\n" +
                    "WHERE g2.genre = ?\n" +
                    "GROUP BY g.game_id, g.title, d.description, g2.genre, g.price");

            statement.setString(1, genre);

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Game> getGamesByGenre = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Game game = new Game(id, title, genre, description, price);
                getGamesByGenre.add(game);
            }
            return getGamesByGenre;
        }
    }

    @Override
    public ArrayList<Game> getGamesByTitle(String title) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT g.game_id, g.title, d.description, g2.genre, g.price\n" +
                    "FROM game g\n" +
                    "         join description d on g.game_id = d.game_id\n" +
                    "         join genre g2 on g.game_id = g2.game_id\n" +
                    "WHERE g.title like ?\n" +
                    "GROUP BY g.game_id, g.title, d.description, g2.genre, g.price");

            statement.setString(1, "%"+title+"%");

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Game> getGamesByGenre = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String realTitle = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Game game = new Game(id, realTitle, genre, description, price);
                getGamesByGenre.add(game);
            }
            return getGamesByGenre;
        }
    }
}
