package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class MaximoConnection {

    // Variables to store Maximo server information
    private String baseUrl; // Base URL of Maximo server
    private String username; // Username for authentication
    private String password; // Password for authentication

    // Constructor to initialize MaximoConnection object with server details
    public MaximoConnection(String baseUrl, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }

    // Method to send GET request to Maximo API and retrieve response
    public String sendGetRequest(String objectStructure) throws IOException {
        // Construct URL for the specific object structure endpoint
        URL url = new URL(baseUrl + "/os/" + objectStructure);

        // Open HTTP connection to the URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Set request method as GET

        // Set Basic Authentication header for the request
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

        // Check if connection is successful (HTTP status code 200)
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // If successful, read response from input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString(); // Return response as String
        } else {
            // If unsuccessful, throw an IOException with the response code
            throw new IOException("Failed to connect to Maximo API. Response code: " + responseCode);
        }
    }
}
