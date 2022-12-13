package GameApp.client.model;

import GameApp.client.network.Client;
import GameApp.server.model.modelClasses.Game;
import GameApp.server.model.modelClasses.Transaction;
import GameApp.server.model.modelClasses.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ClientModelManager implements ClientModelManagerFactory {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    private int selectedPictureId;

    public ClientModelManager(Client client) {
        this.client = client;
        client.startClient();

        client.addListener("NewGameAdded", this::update);
    }

    public void update(PropertyChangeEvent event)
    {
        support.firePropertyChange("NewGameAdded", null, 1);
    }

    @Override
    public void addUser(String email, String country, String address, String username, String password, boolean isAdmin) {
        client.addUser(new User(email, country, address, username, password, isAdmin));
    }

    @Override
    public Game create(String title, String genre, String description, double price) {
        return client.create(title, genre, description, price);
    }

    @Override
    public List<Game> getAllGames() {
        return client.getAllGames();
    }

    @Override
    public Game readByID(int game_id) {
        return client.readByID(game_id);
    }


    @Override
    public void userEdit(User user) {
        client.editUser(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return client.checkEmail(email);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void setSelectedId(int id) {
        this.selectedPictureId = id;
        support.firePropertyChange("NewPictureSelected", null, selectedPictureId);
    }

    @Override
    public int getSelectedPictureId() {
        return selectedPictureId;
    }

    @Override
    public void addGameToShoppingCart() {
        client.addGameToShoppingCart(selectedPictureId);
        support.firePropertyChange("NewItemInShoppingCart", null, 1);
    }

    @Override
    public void removeGameFromShoppingCart(int id) {
        client.removeGameFromShoppingCart(id);
    }

    @Override
    public void removeGameFromShoppingCart(Game game) {
        client.removeGameFromShoppingCart(game);
        support.firePropertyChange("ItemDeletedFromShoppingCart", null, 1);
    }

    @Override
    public void removeAllGamesFromCart() {
        client.removeAllGamesFromCart();
    }

    @Override
    public double getShoppingCartValue() {
        return client.getShoppingCartValue();
    }

    @Override
    public List<Game> getAllGamesFromShoppingCart() {
        return client.getAllGamesFromShoppingCart();
    }

    @Override
    public List<Game> getGamesByGenre(String genre) {
        return client.getGamesByGenre(genre);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return client.getGamesByTitle(title);
    }

    @Override
    public boolean login(String email, String password) {
        return client.login(email, password);
    }

    @Override
    public User getLoggedUser(String email, String password) {
        support.firePropertyChange("UserLoggedIn", null, 1);
        return client.getLoggedUser(email, password);
    }

    @Override
    public User getUser() {
        return client.getUser();
    }

    @Override
    public List<User> getAllUsers() {
        return client.getAllUsers();
    }

    @Override
    public User findUserByEmail(String email) {
        return client.findUserByEmail(email);
    }

    public void deleteUser(User user) {

        client.deleteUser(user);

    }

    //TRANSACTION METHODS
    @Override
    public Transaction create(User usersEmail, List<Game> games) {

        Transaction transaction = client.create(usersEmail, games);
        support.firePropertyChange("TransactionMade", null, 1);

        return transaction;
    }

    @Override
    public List<Game> getGamesByEmail(String email) {
        return client.getGamesByEmail(email);
    }

    @Override
    public List<Game> searchLikeTitleForEmail(String title, String email) {
        return client.searchLikeTitleForEmail(title, email);
    }

    @Override
    public void delete(Transaction transaction) {
        client.delete(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return client.getAllTransactions();
    }

    @Override
    public List<Transaction> getAllTransactionsByEmail(String email) {
        return client.getAllTransactionsByEmail(email);
    }
    @Override
    public List<Transaction> getAllTransactionsForThisClient() {
        if (getUser().getEmail()!= null)
        {
            return client.getAllTransactionsByEmail(getUser().getEmail());
        }
        return new ArrayList<Transaction>();
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) {
        return client.getTransactionByTransactionId(transactionId);
    }
    //TRANSACTION METHODS END
}
