package GameApp.shared.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * A class represents Junit test for ShoppingCart class.
 *
 * @author Saran Singh
 * @version 1.0
 */
public final class ShoppingCartTest {

    /**
     * Method to test adding games to the shopping cart
     */
    @Test
    public void testAddGame() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Game game = new Game(-6491888, "", "", "Action", 0.0);
        shoppingCart.addGame(game);
    }

    /**
     * Method to test if an obj is an array list
     */
    @Test
    public void testContains() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Object obj = new Object();
        boolean actual = shoppingCart.contains(obj);
        assertFalse(actual);
    }


    /**
     * Method to test removing games from the shopping cart
     */
    @Test
    public void testRemoveGame() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Game game = new Game(-649160781, "", "", "noimn", 0.0);
        shoppingCart.removeGame(game);
    }


}
