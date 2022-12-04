package GameApp.server.model.modelClasses;

import GameApp.server.model.modelClasses.Account;
import GameApp.server.model.modelClasses.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;


    @BeforeEach
    void setupTest() {
        account = new Account("Mike",new User("sup@gmail.com","Canada","ABC","S","123",true),1);
    }

    @Test
    void getUserName() {
        assertEquals("Mike",account.getUserName());
    }

    @Test
    void setUserName() {
        account.setUserName("name");
        assertEquals("name",account.getUserName());
    }
}