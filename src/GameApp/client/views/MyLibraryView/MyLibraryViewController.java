package GameApp.client.views.MyLibraryView;

import GameApp.client.core.ViewHandler;
import GameApp.client.core.ViewModelFactory;
import GameApp.client.views.ViewController;

public class MyLibraryViewController implements ViewController{
    private MyLibraryViewModel myLibraryViewModel;
    private ViewHandler vha;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vha = vh;
        this.myLibraryViewModel = vmf.getMyLibraryViewModel();
    }
}
