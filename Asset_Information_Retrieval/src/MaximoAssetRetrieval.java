
import connection.MaximoConnection;
import query.AssetQuery;

import java.io.IOException;

public class MaximoAssetRetrieval {

    public static void main(String[] args) {
        // Maximo server URL
        String maximoUrl = "https://bportaluri.com/wp-content/MaximoJavaDocs76/";

        // Maximo credentials
        String username = "username";
        String password = "password";

        // Maximo object structure to query
        String objectStructure = "ASSET";

        try {
            // Establish connection to Maximo server
            MaximoConnection maximoConnection = new MaximoConnection(maximoUrl, username, password);

            // Create instance of AssetQuery to perform asset-related queries
            AssetQuery assetQuery = new AssetQuery(maximoConnection);

            // Retrieve asset information using the specified object structure
            String assetInfo = assetQuery.getAssetInformation(objectStructure);

            // Print asset information to the console
            System.out.println("Asset Information:");
            System.out.println(assetInfo);
        } catch (IOException e) {
            // Handle IO exceptions, typically connection or data retrieval issues
            e.printStackTrace();
        }
    }
}
