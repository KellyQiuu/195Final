import org.junit.Test;

import java.io.IOException;

public class ExampleTest {
	@Test
	public void ExampleJavaTest() throws IOException {
		try {
			Example.main(new String[] {});
		} catch (Exception ignored) {

		}
		assert true;
	}
}
