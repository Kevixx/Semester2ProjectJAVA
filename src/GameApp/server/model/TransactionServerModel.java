package GameApp.server.model;

import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TransactionServerModel {

    //TRANSACTION METHODS
    Transaction create(User usersEmail, ArrayList<Game> games) throws SQLException;

    ArrayList<Game> getGamesIdsByEmail(String email) throws SQLException;

    ArrayList<Integer> searchLikeTitleGetIds(String title) throws SQLException;

    void delete(Transaction transaction) throws SQLException;
}
