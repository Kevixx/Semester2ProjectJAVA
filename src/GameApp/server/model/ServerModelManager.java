package GameApp.server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ServerModelManager implements ServerModelManagerFactory
{
  private PropertyChangeSupport support;

  //Constructor
  public ServerModelManager() {
    support = new PropertyChangeSupport(this);
  }




  //Methods to implement Subject interface
  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
}
