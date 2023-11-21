package view;

import interface_adapter.ViewManagerModel;

import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * Manages different views within the application using a CardLayout.
 * It listens for property changes in the ViewManagerModel and switches views accordingly.
 */
public class ViewManager implements PropertyChangeListener {
	private final CardLayout cardLayout;
	private final JPanel views;
	private ViewManagerModel viewManagerModel;

	// ViewManager constructor, should be referred to when passing in created views.
	/**
	 * Constructs a ViewManager.
	 *
	 * @param views The panel containing different views.
	 * @param cardLayout The CardLayout managing the views.
	 * @param viewManagerModel The model that tracks the current view state.
	 */
	public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
		this.views = views;
		this.cardLayout = cardLayout;
		this.viewManagerModel = viewManagerModel;
		this.viewManagerModel.addPropertyChangeListener(this);
	}

	/**
	 * Listens for property change events.
	 * When the 'view' property changes, it switches to the corresponding view in the CardLayout.
	 *
	 * @param evt The property change event.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {  // Record change of views and display the new view.
		if (evt.getPropertyName().equals("view")) {
			String viewModelName = (String) evt.getNewValue();
			System.out.println("Switching to view: " + viewModelName);
			cardLayout.show(views, viewModelName);
		}
	}
}

