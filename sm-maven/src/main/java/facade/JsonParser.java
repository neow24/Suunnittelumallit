package facade;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class JsonParser {
    public String extractFromJson(String json, String attributeName)
    throws IllegalArgumentException  {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            Object value = jsonObject.get(attributeName);
            if (value instanceof JSONObject)
                // Nested object.
                return ((JSONObject) value).toJSONString();
            else if (value instanceof org.json.simple.JSONArray)
                // Nested array.
                return ((org.json.simple.JSONArray) value).toJSONString();
            else
                // Primitive value.
                return value.toString();
        } catch (org.json.simple.parser.ParseException e) {
            throw new IllegalArgumentException("Invalid JSON format");
        }
    }
}
