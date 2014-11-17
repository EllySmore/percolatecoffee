package percolatechallenge.eileenyau.coffee;

public class Config {

    private static final String API_ENDPOINT = "https://coffeeapi.percolate.com/";

    private static final String API_KEY = "WuVbkuUsCXHPx3hsQzus4SE";

    public static String getBaseUrl() {
        return API_ENDPOINT;
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
