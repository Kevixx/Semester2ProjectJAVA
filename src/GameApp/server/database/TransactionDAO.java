package GameApp.server.database;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TransactionDAO {

    Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException;

    ArrayList<Integer> getGamesIdsByEmail(String email) throws SQLException;

    ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException;

    void delete(Transaction transaction) throws SQLException;
}
