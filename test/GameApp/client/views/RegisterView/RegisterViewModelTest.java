package GameApp.client.views.RegisterView;
import GameApp.client.model.ClientModelBaseTestClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import GameApp.client.model.Dummy;
import org.junit.jupiter.api.Test;

class RegisterViewModelTest {
    private RegisterViewModel registerViewModel;
    private Dummy dummy;
    @BeforeEach
    public void setup(){
        dummy.DummyUsers();
    }

    @Test
    public void createValidUser(){

    }
}