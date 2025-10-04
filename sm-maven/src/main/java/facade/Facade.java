package facade;

import java.io.IOException;

public class Facade {
    private ApiClient apiClient;
    private JsonParser jsonParser;
    
    public Facade(ApiClient apiClient, JsonParser jsonParser) {
        this.apiClient = apiClient;
        this.jsonParser = jsonParser;
    }

    synchronized String getAttributeValueFromJson(String urlString, String attributeName)
    throws IllegalArgumentException, IOException {
        return "\n" + jsonParser.extractFromJson(
            apiClient.getJsonFromApi(urlString), attributeName
        );
    }
}
