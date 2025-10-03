package facade;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        ApiClient apiClient = new ApiClient();
        JsonParser jsonParser = new JsonParser();
        Facade f = new Facade(apiClient, jsonParser);

        System.out.println(
            f.getAttributeValueFromJson(
                "https://api.chucknorris.io/jokes/random",
                "value"
            ) + "\n"
        );

        System.out.println(
            f.getAttributeValueFromJson(
                "https://api.fxratesapi.com/latest",
                "rates"
            ) + "\n"
        );
    }
}
