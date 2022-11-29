package GameApp.client.views.MyLibraryView;
import GameApp.client.model.ClientModelManagerFactory;


public class MyLibraryViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    public MyLibraryViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }
}