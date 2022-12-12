package GameApp.server.model.modelClasses;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Transaction implements Serializable {

    private List<GameInTransaction> games;

    private int transactionId;
    private String usersEmail;
    private Date dateOfPurchase;

    public Transaction(int transactionId, String usersEmail, List<GameInTransaction> games, Date dateOfPurchase) {
        this.games = games;
        this.transactionId = transactionId;
        this.usersEmail = usersEmail;
        this.dateOfPurchase = dateOfPurchase;
    }

    public List<GameInTransaction> getGames() {
        return games;
    }

    public void setGames(List<GameInTransaction> games) {
        this.games = games;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getTotalTransactionPrice()
    {
        double total = 0;
        for (int i = 0; i < games.size(); i++)
        {
            total+= games.get(i).getPurchasedPrice();
        }
        return total;
    }

    public String getTransactionDetails()
    {
        String details ="";
        for (int i = 0; i < games.size(); i++)
        {
            details+="GameID: " + games.get(i).getGameId() +"; ";
        }
        return details;
    }
}
