package percolatechallenge.eileenyau.coffee.api.requests;

import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;

import percolatechallenge.eileenyau.coffee.api.models.CoffeePosts;

public class CoffeePostsRequest extends OkHttpSpiceRequest<CoffeePosts> {

    public CoffeePostsRequest(Class<CoffeePosts> clazz) {
        super(clazz);
    }

    @Override
    public CoffeePosts loadDataFromNetwork() throws Exception {
        return null;
    }
}
