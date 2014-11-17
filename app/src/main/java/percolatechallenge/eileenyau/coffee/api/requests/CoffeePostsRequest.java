package percolatechallenge.eileenyau.coffee.api.requests;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;

import org.apache.commons.io.IOUtils;

import android.net.Uri;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import percolatechallenge.eileenyau.coffee.Config;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;


public class CoffeePostsRequest extends OkHttpSpiceRequest<CoffeePost>
        implements RequestListener<CoffeePost> {

    private static final String TAG = CoffeePostsRequest.class.getSimpleName();

    private static final String ROUTE = "/coffee/";

    public CoffeePostsRequest() {
        super(CoffeePost.class);
    }

    @Override
    public CoffeePost loadDataFromNetwork() throws Exception {

        Uri.Builder uriBuilder = Uri.parse(Config.getBaseUrl() + ROUTE).buildUpon();
        uriBuilder.appendQueryParameter("api_key", Config.getApiKey());
        URI uri = new URI(uriBuilder.build().toString());
        HttpURLConnection connection = getOkHttpClient().open(uri.toURL());
        InputStream in = null;
        try {
            in = connection.getInputStream();
            Log.v(TAG, "Response: " + IOUtils.toString(in, "UTF-8"));
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return null;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Log.v(TAG, "onRequestFailure");
    }

    @Override
    public void onRequestSuccess(CoffeePost coffeePost) {
        Log.v(TAG, "onRequestSuccess");
    }


}
