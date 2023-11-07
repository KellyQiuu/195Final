package view;

import interface_adapter.ViewManagerModel;

import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ViewManager implements PropertyChangeListener {
	private final CardLayout cardLayout;
	private final JPanel views;
	private ViewManagerModel viewManagerModel;

	// ViewManager constructor, should be referred to when passing in created views.
	public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
		this.views = views;
		this.cardLayout = cardLayout;
		this.viewManagerModel = viewManagerModel;
		this.viewManagerModel.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {  // Record change of views and display the new view.
		if (evt.getPropertyName().equals("view")) {
			String viewModelName = (String) evt.getNewValue();
			cardLayout.show(views, viewModelName);
		}
	}
}

