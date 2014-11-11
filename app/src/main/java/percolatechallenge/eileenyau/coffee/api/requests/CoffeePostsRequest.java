package percolatechallenge.eileenyau.coffee.api.requests;

import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;

public class CoffeePostsRequest extends GoogleHttpClientSpiceRequest {
    public CoffeePostsRequest(Class clazz) {
        super(clazz);
    }

    @Override
    public Object loadDataFromNetwork() throws Exception {
        return null;
    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }
}
