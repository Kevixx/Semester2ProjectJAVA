package GameApp.server.model.modelClasses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setupTest() {
        game = new Game(12,"Game","Action","Cool",12.1);
    }

    @Test
    void getGame_id() {
    }

    @Test
    void testGetGame_id() {
    }

    @Test
    void getGenre() {
    }

    @Test
    void setGame_id() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }
}