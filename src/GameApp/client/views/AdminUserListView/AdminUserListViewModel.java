package GameApp.client.views.AdminUserListView;

import GameApp.client.model.ClientModelManagerFactory;

public class AdminUserListViewModel {
    private ClientModelManagerFactory clientModelManagerFactory;

    public AdminUserListViewModel(ClientModelManagerFactory clientModelManagerFactory)
    {
        this.clientModelManagerFactory = clientModelManagerFactory;
    }
}
