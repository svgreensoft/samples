package org.sversh.superhero.utils;

import com.google.gson.Gson;

/**
 * @author Sergey Vershinin
 *
 */
public class JsonUtils {
    
    private JsonUtils() {
        
    }
    
    public static String serialize(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
    
    public static <T> T deSerialize(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }


}
