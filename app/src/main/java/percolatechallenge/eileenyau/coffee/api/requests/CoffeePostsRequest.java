package percolatechallenge.eileenyau.coffee.api.requests;

import com.google.gson.reflect.TypeToken;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import android.net.Uri;
import android.util.Log;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import percolatechallenge.eileenyau.coffee.Config;
import percolatechallenge.eileenyau.coffee.api.events.CoffeePostListingEvent;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePostListing;
import percolatechallenge.eileenyau.coffee.util.RequestHelperUtil;

public class CoffeePostsRequest extends OkHttpSpiceRequest<CoffeePostListing>
        implements RequestListener<CoffeePostListing> {

    private static final String TAG = CoffeePostsRequest.class.getSimpleName();

    private static final String ROUTE = "/coffee/";

    public CoffeePostsRequest() {
        super(CoffeePostListing.class);
    }

    @Override
    public CoffeePostListing loadDataFromNetwork() throws Exception {
        Uri.Builder uriBuilder = Uri.parse(Config.getBaseUrl() + ROUTE).buildUpon();
        Log.d(TAG, "Url: " + uriBuilder.toString());
        URI uri = new URI(uriBuilder.build().toString());
        HttpURLConnection connection = getOkHttpClient().open(uri.toURL());
        connection.addRequestProperty("Authorization", Config.getApiKey());
        InputStream in = null;
        try {
            in = connection.getInputStream();
            String response = IOUtils.toString(in);
            if (RequestHelperUtil.isJsonArray(response)) {
                JSONArray jsonArray = new JSONArray(response);
                Type listType = new TypeToken<List<CoffeePost>>() {
                }.getType();
                ArrayList<CoffeePost> coffeePosts = CoffeePost.buildFromJson(jsonArray, CoffeePost.class, listType);
                CoffeePostListing coffeePostListing = new CoffeePostListing();
                coffeePostListing.setCoffeeData(coffeePosts);
                return coffeePostListing;
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return null;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Log.d(TAG, "onRequestFailure");
    }

    @Override
    public void onRequestSuccess(CoffeePostListing coffeePostListing) {
        Log.d(TAG, "onRequestSuccess: " + coffeePostListing.getCoffeeData().toString());
        EventBus.getDefault().post(new CoffeePostListingEvent(coffeePostListing));
    }

}