package entity;
import java.io.*;
import java.net.*;
public class SimpleServer {
    public static void main(String[] args) throws IOException {
        // Create a server socket that listens on port 8080.
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            // The server runs in an infinite loop waiting for client connections.
            while (true) {
                try {
                    // Wait for a client to connect, then create a new socket to handle the connection.
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected");

                    // Create output stream to send data to the client.
                    OutputStream output = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    // Send a response to the client.
                    writer.println("Hello, client! You are connected to the server.");

                    // Close the client socket.
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port 8080 or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        }
    }}
