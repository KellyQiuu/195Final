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
        String oldViewName = this.activeViewName;
        this.activeViewName = activeView;
        // Notify listeners about the change
        support.firePropertyChange("view", oldViewName, activeViewName);
    }

    // Record for property change.
    public void firePropertyChanged() {
        // It's important to pass the old and new value when firing the property change.
        // If the old and new are the same, the listeners may not be notified, so you can pass null as the old value.
        support.firePropertyChange("view", null, this.activeViewName);
    }

    // Add listener.
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    // Get the previous view from the history stack
    public String getPreviousView() {
        return viewHistory.isEmpty() ? null : viewHistory.pop();
    }

    // Additional methods or logic could be added here if needed for managing views...
}
