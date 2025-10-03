package facade;

import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ApiClient {
    public String getJsonFromApi(String apiUrl) throws IOException {
        URL url = java.net.URI.create(apiUrl).toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(
        new java.io.InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }
}
