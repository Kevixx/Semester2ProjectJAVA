package GameApp.client.core;

import GameApp.client.views.LoginView.LoginViewModel;
import GameApp.client.views.MainShopView.MainShopViewModel;
import GameApp.client.views.MyAccountView.MyAccountViewModel;
import GameApp.client.views.MyLibraryView.MyLibraryViewModel;
import GameApp.client.views.RegisterView.RegisterViewModel;

public class ViewModelFactory
{
  private static ViewModelFactory instance=new ViewModelFactory();

  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;
  private MainShopViewModel mainShopViewModel;
  private MyAccountViewModel myAccountViewModel;
  private MyLibraryViewModel myLibraryViewModel;


  public static ViewModelFactory getInstance(){
    return instance;
  }
//  private MainViewModel mainViewModel;
//  private ChatViewModel chatViewModel;
public ViewModelFactory() {

}

  public LoginViewModel getLoginViewModel() {
    if (loginViewModel == null)
      loginViewModel = new LoginViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
    return loginViewModel;
  }

  public RegisterViewModel getRegisterViewModel() {
    if (registerViewModel == null)
      registerViewModel = new RegisterViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
    return registerViewModel;
  }

  public MainShopViewModel getMainShopViewModel(){
    if (mainShopViewModel== null)
      mainShopViewModel = new MainShopViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
    return mainShopViewModel;
  }

  public MyAccountViewModel getMyAccountViewModel(){
    if (myAccountViewModel== null)
      myAccountViewModel = new MyAccountViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
    return myAccountViewModel;
  }

  public MyLibraryViewModel getMyLibraryViewModel(){
    if (myLibraryViewModel== null)
      myLibraryViewModel = new MyLibraryViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
    return myLibraryViewModel;
  }

//  public MainViewModel getMainViewModel() {
//    if (mainViewModel == null)
//      mainViewModel = new MainViewModel(ModelFactory.getInstance().getClientModelManagerFactory());
//    return mainViewModel;
//  }
//
////  public ChatViewModel getChatViewModel() {
////    return (chatViewModel = chatViewModel == null ?
////        new ChatViewModel(ModelFactory.getInstance().getClientModelManagerFactory()) :
////        chatViewModel);
//  }
}
