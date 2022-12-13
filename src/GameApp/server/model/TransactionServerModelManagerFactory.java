package GameApp.server.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.util.List;

public interface TransactionServerModelManagerFactory {

    //TRANSACTION METHODS
    Transaction create(User usersEmail, List<Game> games);

    List<Game> getGamesByEmail(String email);

    List<Game> searchLikeTitleForEmail(String title, String email);

    void delete(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByEmail(String email);

    Transaction getTransactionByTransactionId(int transactionId);
}
