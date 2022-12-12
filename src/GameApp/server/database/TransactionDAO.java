package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TransactionDAO {

    Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException;

    ArrayList<Game> getGamesByEmail(String email) throws SQLException;

    ArrayList<Game> searchLikeTitleForEmail(String title, String email) throws SQLException;

    void delete(Transaction transaction) throws SQLException;
}
