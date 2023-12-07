package data_access;

import entity.GeneralUser;
import entity.User;
import entity.UserFactory;
import use_case.connect.ConnectDataAccessInterface;
import use_case.login.LoginUserAccessInterface;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.signup.SignupUserAccessInterface;
import use_case.user_list.UserListDataAccessInterface;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PSQLDataAccessObject implements SignupUserAccessInterface, UserListDataAccessInterface,
		SelfProfileDataAccessInterface, LoginUserAccessInterface, OtherProfileDataAccessInterface, ConnectDataAccessInterface {

	// Database credentials
	String host = "csc207.postgres.database.azure.com";
	String database = "csc207";
	String user = "csc207";
	String password = "Password@0";
	int port = 5432;

	String url = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);

	public PSQLDataAccessObject() throws IOException {

		// Establish a connection
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			System.out.println("Attempting to create table 'users'");
			// Create table
			String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
									"Username VARCHAR(50), " +
									"Password VARCHAR(50), " +
									"ID SERIAL PRIMARY KEY, " +
									"Email VARCHAR(100), " +
									"Courses VARCHAR(255));";

			try (Statement statement = connection.createStatement()) {
				statement.execute(createTableSQL);
				System.out.println("Table 'users' created successfully");
			}

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}

	@Override
	public boolean existsByName(String username) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			String checkStr = String.format("SELECT Username FROM users WHERE Username='%s'", username);
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(checkStr);

				if (resultSet.next()) {
					// User exists
					return true;
				} else {
					// User does not exist
					return false;
				}

			}
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public String getPass(String username) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			String checkStr = String.format("SELECT Password FROM users WHERE Username='%s'", username);
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(checkStr);

				if (resultSet.next()) {
					// User exists
					return resultSet.getString(1);
				} else {
					// User does not exist
					// This will not happen
					return "";
				}

			}
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public User get2(String username) throws IOException {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			String fetchAllStr = String.format("SELECT * FROM users WHERE Username='%s'", username);
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(fetchAllStr);

				if (resultSet.next()) {
					// Assuming the format is: username,password,email,id,courses
					ArrayList<String> courses = new ArrayList<>(
							Arrays.asList(resultSet.getString(5).split("\\+")));
					return UserFactory.createUser(resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							courses);
				}
			}

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public GeneralUser getUser(String username) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			String fetchAllStr = String.format("SELECT * FROM users WHERE Username='%s'", username);
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(fetchAllStr);

				if (resultSet.next()) {
					// Assuming the format is: username,password,email,id,courses
					ArrayList<String> courses = new ArrayList<>(
							Arrays.asList(resultSet.getString(5).split("\\+")));
					return UserFactory.createUser(resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							courses);
				}
			}

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean checkValidEmail(String email) {
		return EmailVerificationService.verifyEmail3(email);
	}

	@Override
	public boolean checkValidUsername(String username) {
		return !existsByName(username);
	}


	@Override
	public void save(GeneralUser user) {
		System.out.println("User received by save(), it is"+ user);
		String insertSQL = "INSERT INTO users (Username, Password, Email, Courses) VALUES (?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, this.user, password);
		     PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCoursesString());

			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("User inserted successfully.");
			}
		} catch (SQLException e) {
			System.out.println("Error inserting user.");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<GeneralUser> getAllUsers() {
		ArrayList<GeneralUser> users = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connected to PostgreSQL database!");

			String fetchAllStr = String.format("SELECT * FROM users");
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(fetchAllStr);

				while (resultSet.next()) {
					String username = resultSet.getString("Username");
					String password = resultSet.getString("Password");
					int id = resultSet.getInt("ID");
					String email = resultSet.getString("Email");

					ArrayList<String> courses = new ArrayList<>(
							Arrays.asList(resultSet.getString("Courses").split("\\+")));

					GeneralUser user = new User(username, password, Integer.toString(id), email, courses);
					users.add(user);
				}
			}

			return users;

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public GeneralUser get(String currentUserName) throws IOException {
		return getUser(currentUserName);
	}
}
