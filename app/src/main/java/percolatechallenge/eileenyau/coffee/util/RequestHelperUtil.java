package percolatechallenge.eileenyau.coffee.util;

public class RequestHelperUtil {

    public static String buildUrlWithParams() {
        return null;
    }

    public static boolean isJsonArray(String obj) {
        boolean isJsonArray = false;

        if (obj.length() > 0 && obj.charAt(0) == '[') {
            isJsonArray = true;
        }
        return isJsonArray;
    }
}
