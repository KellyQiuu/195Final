import app.Main;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;

public class MainTest {

	private JFrame testFrame;
	private JPanel testPanel;

	@Before
	public void setUp() {
		// Initialize the components that you are going to use in your tests
		testFrame = Main.createApplicationFrame();
		CardLayout cardLayout = new CardLayout();
		testPanel = Main.createCardLayoutPanel(cardLayout);
	}

	@After
	public void tearDown() {
		// Clean up after your tests
		testFrame.dispose();
	}

	@Test
	public void testApplicationFrameCreation() {
		assertNotNull("Frame should be initialized", testFrame);
		assertEquals("Default close operation should be EXIT_ON_CLOSE", WindowConstants.EXIT_ON_CLOSE, testFrame.getDefaultCloseOperation());
		assertEquals("Frame title should be set", "CourseMate Connect", testFrame.getTitle());
	}

	@Test
	public void testCardLayoutPanelCreation() {
		assertNotNull("Card layout panel should be initialized", testPanel);
		assertTrue("Card layout panel should use CardLayout", testPanel.getLayout() instanceof CardLayout);
	}

	// Add more tests for each of the refactored initialization methods
}
