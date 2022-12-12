package GameApp.server.model.modelClasses;

import java.io.Serializable;

public class GameInTransaction implements Serializable {

    private int gameId;
    private int transactionId;
    private double purchasedPrice;

    public GameInTransaction(int gameId, int transactionId, double purchasedPrice) {
        this.gameId = gameId;
        this.transactionId = transactionId;
        this.purchasedPrice = purchasedPrice;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }
}
