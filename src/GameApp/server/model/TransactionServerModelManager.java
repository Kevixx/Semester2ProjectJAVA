package GameApp.server.model;

import GameApp.server.database.TransactionDAO;
import GameApp.server.database.TransactionDAOImpl;
import GameApp.shared.model.Game;
import GameApp.shared.model.Transaction;
import GameApp.shared.model.User;

import java.sql.SQLException;
import java.util.List;

public class TransactionServerModelManager implements TransactionServerModelManagerFactory {

    private TransactionDAO transaction;

    public TransactionServerModelManager(){
        transaction = new TransactionDAOImpl();
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) {
        try {
            return transaction.create(usersEmail, games);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> getGamesByEmail(String email) {
        try {
            return transaction.getGamesByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) {
        try {
            return transaction.searchLikeTitleForEmail(title, email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Transaction transaction) {
        try {
            this.transaction.delete(transaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        try {
            return transaction.getAllTransactions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) {
        try {
            return transaction.getAllTransactionsByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) {
        try {
            return transaction.getTransactionByTransactionId(transactionId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //TRANSACTION METHODS END
}
