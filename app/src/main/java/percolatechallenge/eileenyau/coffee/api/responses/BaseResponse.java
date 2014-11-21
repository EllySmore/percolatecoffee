package percolatechallenge.eileenyau.coffee.api.responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BaseResponse {

    public static <T extends BaseResponse> T buildFromJson(JSONObject json, Class<T> tClass) {
        return buildFromJson(json, tClass, false);
    }

    public static <T extends BaseResponse> T buildFromJsonForExposedObjects(JSONObject json,
                                                                         Class<T> tClass) {
        return buildFromJson(json, tClass, true);
    }

    public static <T extends BaseResponse> T buildFromJson(JSONObject json, Class<T> tClass,
                                                        boolean shouldUseExposeAnnotations) {
        GsonBuilder builder = new GsonBuilder();
        if (shouldUseExposeAnnotations) {
            builder.excludeFieldsWithoutExposeAnnotation();
        }
        Gson gson = builder.create();
        String jsonString = "";
        jsonString = json.toString();
        return gson.fromJson(jsonString, tClass);
    }

    public static <T extends BaseResponse> ArrayList<T> buildFromJson(JSONArray jsonArray,
                                                                      Class<T> tClass, Type type) {
        ArrayList<T> results = new ArrayList<T>();
        if (jsonArray != null) {
            results = new Gson().fromJson(jsonArray.toString(), type);
        }
        return results;
    }
}
