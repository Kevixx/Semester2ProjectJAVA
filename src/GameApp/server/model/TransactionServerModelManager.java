package GameApp.server.model;

import GameApp.server.database.TransactionDAO;
import GameApp.server.database.TransactionDAOImpl;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionServerModelManager implements TransactionServerModel {

    private TransactionDAO transaction;

    public TransactionServerModelManager() throws SQLException {
        transaction = new TransactionDAOImpl();
    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException {
        return transaction.create(usersEmail, games);
    }

    @Override
    public ArrayList<Game> getGamesByEmail(String email) throws SQLException {
        return transaction.getGamesByEmail(email);
    }

    @Override
    public ArrayList<Game> searchLikeTitleForEmail(String title, String email) throws SQLException {
        return transaction.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) throws SQLException {
        this.transaction.delete(transaction);
    }
    //TRANSACTION METHODS END
}
