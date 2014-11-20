package percolatechallenge.eileenyau.coffee.util;

import java.net.URI;
import java.net.URISyntaxException;

import android.net.Uri;
import android.util.Log;

import percolatechallenge.eileenyau.coffee.Config;

public class RequestHelperUtil {

    public static URI buildURI(String route) throws URISyntaxException {
        Uri.Builder uriBuilder = Uri.parse(Config.getBaseUrl() + route).buildUpon();
        Log.d("RequestHelperUtil", "Url: " + uriBuilder.toString());
        URI uri = new URI(uriBuilder.build().toString());
        return uri;
    }

    public static boolean isJsonArray(String obj) {
        boolean isJsonArray = false;

        if (obj.length() > 0 && obj.charAt(0) == '[') {
            isJsonArray = true;
        }
        return isJsonArray;
    }
}
