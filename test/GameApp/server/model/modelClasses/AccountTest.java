package GameApp.shared.model;

import GameApp.shared.model.Account;
import GameApp.shared.model.User;
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