package Json;

import app.Dog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class JsonHelper {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String mapToJson(Map<Integer, Dog> map) {
        if (map == null)
            map = new HashMap<Integer, Dog>();
        return gson.toJson(map);
    }
}