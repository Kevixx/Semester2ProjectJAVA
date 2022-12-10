package GameApp.server.model.modelClasses;

import java.sql.Date;
import java.util.ArrayList;

public class Transaction {

    private ArrayList<GameInTransaction> games;

    private int transactionId;
    private String usersEmail;
    private Date dateOfPurchase;

    public Transaction(int transactionId, String usersEmail, ArrayList<GameInTransaction> games, Date dateOfPurchase) {
        this.games = games;
        this.transactionId = transactionId;
        this.usersEmail = usersEmail;
        this.dateOfPurchase = dateOfPurchase;
    }

    public ArrayList<GameInTransaction> getGames() {
        return games;
    }

    public void setGames(ArrayList<GameInTransaction> games) {
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
}
