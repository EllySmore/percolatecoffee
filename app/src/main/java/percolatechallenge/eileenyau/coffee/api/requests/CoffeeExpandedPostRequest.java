package percolatechallenge.eileenyau.coffee.api.requests;

import android.util.Log;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import de.greenrobot.event.EventBus;
import percolatechallenge.eileenyau.coffee.Config;
import percolatechallenge.eileenyau.coffee.api.events.CoffeeExpandedPostEvent;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeeExpandedPost;
import percolatechallenge.eileenyau.coffee.util.RequestHelperUtil;

public class CoffeeExpandedPostRequest extends OkHttpSpiceRequest<CoffeeExpandedPost> implements RequestListener<CoffeeExpandedPost> {

    private static final String TAG = CoffeeExpandedPostRequest.class.getSimpleName();

    private static final String ROUTE = "/coffee/";

    private String mCoffeeId;

    public CoffeeExpandedPostRequest(String coffeId) {
        super(CoffeeExpandedPost.class);
        mCoffeeId = coffeId;
    }


    @Override
    public CoffeeExpandedPost loadDataFromNetwork() throws Exception {
        URI uri = RequestHelperUtil.buildURI(ROUTE + mCoffeeId);
        HttpURLConnection connection = getOkHttpClient().open(uri.toURL());
        connection.addRequestProperty("Authorization", Config.getApiKey());
        InputStream in = null;
        try {
            in = connection.getInputStream();
            String response = IOUtils.toString(in);
            JSONObject jsonObject = new JSONObject(response);
            CoffeeExpandedPost coffeeExpandedPost = CoffeeExpandedPost.buildFromJson(jsonObject, CoffeeExpandedPost.class);
            return coffeeExpandedPost;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Log.d(TAG, "onRequestFailure");
    }

    @Override
    public void onRequestSuccess(CoffeeExpandedPost coffeeExpandedPost) {
        Log.d(TAG, "onRequestSuccess: " + coffeeExpandedPost.toString());
        EventBus.getDefault().post(new CoffeeExpandedPostEvent(coffeeExpandedPost));
    }
}
