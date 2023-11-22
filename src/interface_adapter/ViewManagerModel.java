package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class ViewManagerModel {
    // Current active view name of vm.
    private String activeViewName;
    // Keep track of the View Stack.
    private final Stack<String> viewHistory = new Stack<>();
    // Initiate property change support.
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // Getter for current active view name.
    public String getActiveView() {
        return activeViewName;
    }
    // Change to a new active view.
    public void setActiveView(String activeView) {
        if (activeViewName != null && !activeViewName.equals(activeView)){
            viewHistory.push(activeViewName);
        }
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
    public String getPreviousView() {
        return viewHistory.isEmpty() ? null : viewHistory.pop();
    }
}
