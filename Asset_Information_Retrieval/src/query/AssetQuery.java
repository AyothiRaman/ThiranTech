package query;

import connection.MaximoConnection;

import java.io.IOException;

public class AssetQuery {

    private MaximoConnection maximoConnection;

    public AssetQuery(MaximoConnection maximoConnection) {
        this.maximoConnection = maximoConnection;
    }

    // Retrieve asset information using the specified object structure
    public String getAssetInformation(String objectStructure) throws IOException {
        return maximoConnection.sendGetRequest(objectStructure);
    }
}
