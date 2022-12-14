package GameApp.server.model;

import GameApp.shared.model.Game;
import GameApp.shared.model.Transaction;
import GameApp.shared.model.User;

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
