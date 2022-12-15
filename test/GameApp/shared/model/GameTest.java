package GameApp.shared.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public final class GameTest {

    /**
     * A class represents Junit test for GameClass.
     *
     * @author Saran Singh
     * @version 1.0
     */


    /**
     * Test Method to set game description
     */
    @Test
    public void testGetGameDescription() {
        Game game = new Game(-1454478562, "hlcoj", "oesjb", "", 0.0);
        String actual = game.getGameDescription();
        String expected = "";
        assertEquals(expected, actual);
    }

    /**
     * Test Method to get game genre
     */
    @Test
    public void testGetGameGenre() {
        Game game = new Game(-1454478562, "oesjb", "noimn", "noimn", 0.0);
        String actual = game.getGameGenre();
        String expected = "noimn";
        assertEquals(expected, actual);
    }

    /**
     * Test Method to get ID of a game
     */
    @Test
    public void testGetGameId() {
        Game game = new Game(-1454478562, "hlcoj", "oesjb", "", 0.0);
        int actual = game.getGameId();
        assertEquals(-1454478562, actual);
    }

    /**
     * Test Method to get the game title
     */
    @Test
    public void testGetGameTitle() {
        Game game = new Game(-1454478562, "hlcoj", "oesjb", "", 0.0);
        String actual = game.getGameTitle();
        String expected = "hlcoj";
        assertEquals(expected, actual);
    }

    /**
     * Test Method for getting an image location of a Game object.
     */
    @Test
    public void testGetPictureURL() {
        Game game = new Game(-649160781, ".jpg", "@../../GameApp/client/views/images/", "", 0.0);
        String actual = game.getPictureURL();
        String expected = "@../../GameApp/client/views/images/-649160781.jpg";
        assertEquals(expected, actual);
    }

}
