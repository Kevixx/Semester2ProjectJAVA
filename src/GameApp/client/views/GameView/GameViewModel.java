package GameApp.client.views.GameView;

import GameApp.client.model.ClientModelManagerFactory;

public class GameViewModel {

    private ClientModelManagerFactory clientModelManagerFactory;
    public GameViewModel(ClientModelManagerFactory clientModelManagerFactory) {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }
}
