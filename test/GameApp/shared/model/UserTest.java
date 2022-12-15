package GameApp.shared.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class represents Junit test for UserClass.
 *
 * @author Saran Singh
 * @version 1.0
 */
public class UserTest {
    /**
     * Test method to get address of a user
     */
    @Test
    public void testGetAddress() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        String actual = user.getAddress();
        String expected = "oesjb";
        assertEquals(expected, actual);
    }

    /**
     * Test method to get country of a user
     */
    @Test
    public void testGetCountry() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        String actual = user.getCountry();
        String expected = "syiug";
        assertEquals(expected, actual);
    }

    /**
     * Test method to get User email
     */
    @Test
    public void testGetEmail() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        String actual = user.getEmail();
        String expected = "hlcoj";
        assertEquals(expected, actual);
    }

    /**
     * Test method to check if getting an admin return false
     */
    @Test
    public void testGetIsAdminReturnsFalse() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        boolean actual = user.getIsAdmin();
        assertFalse(actual);
    }

    /**
     * Test method to get password of a user
     */
    @Test
    public void testGetPassword() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        String actual = user.getPassword();
        String expected = "hlcoj";
        assertEquals(expected, actual);
    }

    /**
     * Test method to get username of a user
     */
    @Test
    public void testGetUsername() {
        User user = new User("hlcoj", "syiug", "oesjb", "syiug", "hlcoj", false);
        String actual = user.getUsername();
        String expected = "syiug";
        assertEquals(expected, actual);
    }

    /**
     * Test method to set address of a user with a blank string
     */
    @Test
    public void testSetAddressWithBlankString() {
        User user = new User("", "oxhrh", "", "oxhrh", "noimn", false);
        user.setAddress("   ");
    }

    /**
     * Test method to make a user admin
     */
    @Test
    public void testSetAdmin() {
        User user = new User("", "oxhrh", "", "oxhrh", "noimn", false);
        user.setAdmin(false);
    }

    /**
     * Test method to replace country of user with a blank string
     */
    @Test
    public void testSetCountryWithBlankString() {
        User user = new User("", "oxhrh", "", "oxhrh", "noimn", false);
        user.setCountry("   ");
    }

    /**
     * Test method to set email address of a user with a blank string
     */
    @Test
    public void testSetEmailWithBlankString() {
        User user = new User("", "oxhrh", "", "oxhrh", "noimn", false);
        user.setEmail("   ");
    }

    /**
     * Test method to set password of a user with a blank string
     */
    @Test
    public void testSetPasswordWithBlankString() {
        User user = new User(" ", "oxhrh", "", "oxhrh", "noimn", false);
        user.setPassword("");
    }
}