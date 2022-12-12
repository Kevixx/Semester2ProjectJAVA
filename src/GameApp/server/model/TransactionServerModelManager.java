package GameApp.server.model;

import GameApp.server.database.TransactionDAO;
import GameApp.server.database.TransactionDAOImpl;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.List;

public class TransactionServerModelManager implements TransactionServerModelManagerFactory {

    private TransactionDAO transaction;

    public TransactionServerModelManager() throws SQLException {
        transaction = new TransactionDAOImpl();
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) throws SQLException {
        return transaction.create(usersEmail, games);
    }

    @Override
    public List<Game> getGamesByEmail(String email) throws SQLException {
        return transaction.getGamesByEmail(email);
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) throws SQLException {
        return transaction.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException {
        this.transaction.delete(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() throws SQLException {
        return transaction.getAllTransactions();
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) throws SQLException {
        return transaction.getAllTransactionsByEmail(email);
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) throws SQLException {
        return transaction.getTransactionByTransactionId(transactionId);
    }
    //TRANSACTION METHODS END
}
