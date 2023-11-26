package use_case.self_profile;

/**
 * Encapsulates the input data for self profile use cases.
 * This class holds the necessary information required for processing self profile related operations.
 */
public class SelfProfileInputData {
	final private String username;

	/**
	 * Constructs a SelfProfileInputData instance with the specified username.
	 *
	 * @param username The username associated with the self profile operation.
	 */
	public SelfProfileInputData(String username) {
		this.username=username;
	}

	/**
	 * Retrieves the username associated with this input data.
	 *
	 * @return The username.
	 */
	public String getUsername() {
		return username;
	}
}
