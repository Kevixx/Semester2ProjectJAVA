package GameApp.server.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.List;

public interface TransactionServerModelManagerFactory {

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games) throws SQLException;

    List<Game> getGamesByEmail(String email) throws SQLException;

    List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException;

    void delete(Transaction transaction) throws SQLException;

    List<Transaction> getAllTransactions() throws SQLException;

    List<Transaction> getAllTransactionsByEmail(String email) throws SQLException;

    Transaction getTransactionByTransactionId(int transactionId) throws SQLException;
}
