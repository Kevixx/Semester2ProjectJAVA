package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.GameInTransaction;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    public TransactionDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    //CREATE A TRANSACTION BY SPECIFYING  WHO BOUGHT IT AND WHICH GAMES
    @Override
    public Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException {
        try (Connection connection = getConnection()) {

            long millis = System.currentTimeMillis();
            Date today = new Date(millis);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO transaction(email, date_of_purchase) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, usersEmail.getEmail());
            statement.setDate(2, today);
            statement.executeUpdate();


            ResultSet keys = statement.getGeneratedKeys();

            ArrayList<GameInTransaction> gamesInTransaction = new ArrayList<>();


            if (keys.next()) {

                Transaction transaction = new Transaction(keys.getInt(1), usersEmail.getEmail(), gamesInTransaction, today);

                for (Game game : games) {

                    statement = connection.prepareStatement("INSERT INTO game_in_transaction(game_id, transaction_id, purchased_price) VALUES (?,?,?)");

                    statement.setInt(1, game.getGameId());
                    statement.setInt(2, transaction.getTransactionId());
                    statement.setDouble(3, game.getGamePrice());
                    statement.executeUpdate();

                    gamesInTransaction.add(new GameInTransaction(game.getGameId(), transaction.getTransactionId(), game.getGamePrice()));
                }

                transaction.setGames(gamesInTransaction);

                return transaction;

            } else {
                throw new SQLException("No key has been generated");
            }
        }
    }


    @Override
    public List<Game> getGamesByEmail(String email) throws SQLException {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT gt.game_id, g.title, d.description, genre, gt.purchased_price \n" +
                    "FROM game_in_transaction gt\n" +
                    "         join transaction t on t.transaction_id = gt.transaction_id\n" +
                    "         join game g on gt.game_id = g.game_id\n" +
                    "         join description d on g.game_id = d.game_id\n" +
                    "join genre g2 on g.game_id = g2.game_id\n" +
                    "WHERE email = ?\n" +
                    "GROUP BY gt.game_id, g.title, d.description, genre, gt.purchased_price;");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            List<Game> games = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String genre = resultSet.getString("genre");
                String name = resultSet.getString("title");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("purchased_price");

                games.add(new Game(id, name, genre, description, price));
            }
            if (games.size() == 0) {
                return null;
            }
            return games;
        }
    }


//    @Override
//    public ArrayList<Game> getAllTransactionsForUser(String email) throws SQLException {
//
//        try (Connection connection = getConnection()) {
//
//            PreparedStatement statement = connection.prepareStatement("SELECT gt.game_id, g.title, d.description, genre, gt.purchased_price \n" +
//                    "FROM transaction gt\n" +
//                    "         join transaction t on t.transaction_id = gt.transaction_id\n" +
//                    "         join game g on gt.game_id = g.game_id\n" +
//                    "         join description d on g.game_id = d.game_id\n" +
//                    "join genre g2 on g.game_id = g2.game_id\n" +
//                    "WHERE email = ?\n;");
//
//            statement.setString(1, email);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            ArrayList<Game> games = new ArrayList<>();
//
//            while (resultSet.next()) {
//
//                int id = resultSet.getInt("game_id");
//                String genre = resultSet.getString("genre");
//                String name = resultSet.getString("title");
//                String description = resultSet.getString("description");
//                double price = resultSet.getDouble("purchased_price");
//
//                games.add(new Game(id, name, genre, description, price));
//            }
//            if (games.size() == 0) {
//                return null;
//            }
//            return games;
//        }
//    }

    @Override
    public ArrayList<Game> searchLikeTitleForEmail(String title, String email) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT game_in_transaction.game_id, g.title, g2.genre, d.description\n" +
                    "FROM game_in_transaction\n" +
                    "         inner join game g on g.game_id = game_in_transaction.game_id\n" +
                    "         inner join description d on g.game_id = d.game_id\n" +
                    "         inner join genre g2 on g.game_id = g2.game_id\n" +
                    "         inner join transaction t on game_in_transaction.transaction_id = t.transaction_id\n" +
                    "where g.title like ?\n" +
                    "  and t.email = ?\n" +
                    "GROUP BY game_in_transaction.game_id, g.title, g2.genre, d.description");

            statement.setString(1, "%" + title + "%");
            statement.setString(2, email);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Game> games = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("game_id");
                String genre = resultSet.getString("genre");
                String name = resultSet.getString("title");
                String description = resultSet.getString("description");

                games.add(new Game(id, name, genre, description, 0));
            }
            if (games.size() == 0) {
                return null;
            }
            return games;
        }
    }


    @Override
    public void delete(Transaction transaction) throws SQLException {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM transaction WHERE transaction_id = ?");

            statement.setInt(1, transaction.getTransactionId());
            statement.executeUpdate();
        }
    }

    private static Connection getConnection() throws SQLException {

        return ConnectDatabase.getConnection();
    }
}

