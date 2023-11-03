package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ViewManagerModel {
    // Current active view name of vm.
    private String activeViewName;
    // Initiate property change support.
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // Getter for current active view name.
    public String getActiveView() {
        return activeViewName;
    }
    // Change to a new active view.
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }
    // Record for property change.
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }
    // Add listener.
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
