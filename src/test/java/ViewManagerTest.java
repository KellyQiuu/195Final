import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import view.ViewManager;

import java.awt.*;
import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import static org.junit.Assert.*;

public class ViewManagerTest {

	private ViewManager viewManager;
	private CardLayout cardLayout;
	private JPanel views;
	private StubViewManagerModel stubViewManagerModel;

	// A stub implementation of ViewManagerModel for the purpose of the test
	private static class StubViewManagerModel extends ViewManagerModel {
		private String currentView;
		private PropertyChangeListener listener;

		@Override
		public void addPropertyChangeListener(PropertyChangeListener newListener) {
			this.listener = newListener;
		}

		@Override
		public String getPreviousView() {
			return currentView;
		}

		public void setCurrentView(String viewName) {
			this.currentView = viewName;
			// Notify the listener about the change
			if (listener != null) {
				listener.propertyChange(new PropertyChangeEvent(this, "view", null, viewName));
			}
		}
	}

	@Before
	public void setUp() {
		cardLayout = new CardLayout();
		views = new JPanel(cardLayout);
		stubViewManagerModel = new StubViewManagerModel();

		viewManager = new ViewManager(views, cardLayout, stubViewManagerModel);

		views.add(new JPanel(), "View1");
		views.add(new JPanel(), "View2");
	}

	@Test
	public void testViewSwitching() {
		// Simulate property change to "View1"
		stubViewManagerModel.setCurrentView("View1");

		// Assert that the card layout shows "View1"
		assertTrue("Card layout should show View1", isCurrentCard("View1"));

		// Simulate the user going back to the previous view
		stubViewManagerModel.setCurrentView("View2");

		// Assert that the card layout shows "View2"
		assertTrue("Card layout should show View2", isCurrentCard("View2"));
	}

	// Helper method to check if the specified card is currently visible
	private boolean isCurrentCard(String cardName) {
		CardLayout layout = (CardLayout) views.getLayout();
		for (Component comp : views.getComponents()) {
			if (comp.isVisible()) {
				layout.show(views, cardName);
				return comp.isVisible();
			}
		}
		return false;
	}


}
