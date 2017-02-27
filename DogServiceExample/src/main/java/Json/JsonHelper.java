package Json;

import app.Dog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class JsonHelper {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//    private static final Type TT_mapStringString = new TypeToken<Map<String,String>>(){}.getType();

//    public static Map<String, Dog> jsonToMapStringString(String json) {
//        Map<String, Dog> ret = new HashMap<String, Dog>();
//        if (json == null || json.isEmpty())
//            return ret;
//        return gson.fromJson(json, TT_mapStringString);
//    }

    public static String mapStringStringToJson(Map<Integer, Dog> map) {
        if (map == null)
            map = new HashMap<Integer, Dog>();
        return gson.toJson(map);
    }
}