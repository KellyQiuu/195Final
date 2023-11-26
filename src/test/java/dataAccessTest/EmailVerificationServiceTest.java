package dataAccessTest;

import data_access.EmailVerificationService;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailVerificationServiceTest {

	@Test
	public void testVerifyEmailWithValidEmail() {
		String validEmail = "cyguchi@gmail.com";

		// WARNING: This will make an actual HTTP request, which is not recommended.
		boolean result = EmailVerificationService.verifyEmail3(validEmail);

		assertTrue(result);
	}

	@Test
	public void testVerifyEmailWithInvalidEmail() {
		String invalidEmail = "cygucccccc@gmail.com";

		// WARNING: This will make an actual HTTP request, which is not recommended.
		boolean result = EmailVerificationService.verifyEmail3(invalidEmail);

		assertFalse(result);
	}



//	@Test
//	public void testVerifyEmailWithValidEmail() {
//		// Assume this is a valid email format
//		String validEmail = "test@example.com";
//
//		// WARNING: This will make an actual HTTP request, which is not recommended.
//		boolean result = EmailVerificationService.verifyEmail(validEmail);
//
//		// Assuming that the API returns 200 for valid email formats
//		assertTrue(result);
//	}

	@Test
	public void testVerifyEmailWithInvalidFormat() {
		String invalidEmail = "invalid-email";

		// WARNING: This will make an actual HTTP request, which is not recommended.
		boolean result = EmailVerificationService.verifyEmail3(invalidEmail);

		assertFalse(result);
	}
}

//	@Test
//	public void testVerifyEmail2WithValidResponse() {
//		// Assume this is some valid email
//		String email = "valid@example.com";
//
//		// WARNING: This will make an actual HTTP request, which is not recommended.
//		boolean result = EmailVerificationService.verifyEmail2(email);
//
//		// The expected result should be based on the actual response from the external service
//		// Assuming the service returns "200" for a successful verification
//		assertTrue(result);
//	}
//
//	@Test
//	public void testVerifyEmail2WithInvalidResponse() {
//		// Assume this is some valid email
//		String email = "invalid@example.com";
//
//		// WARNING: This will make an actual HTTP request, which is not recommended.
//		boolean result = EmailVerificationService.verifyEmail2(email);
//
//		// The expected result should be based on the actual response from the external service
//		// Assuming the service does not return "200" for an unsuccessful verification
//		assertFalse(result);
//	}
//
//	// ... Additional tests could be written to handle cases like timeouts, server errors, etc.
//
//}
