package percolatechallenge.eileenyau.coffee;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import percolatechallenge.eileenyau.coffee.api.requests.CoffeePostsRequest;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;
import percolatechallenge.eileenyau.coffee.commons.BaseActivity;

public class EntryActivity extends BaseActivity {

    private static final String TAG = EntryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        CoffeePostsRequest request = new CoffeePostsRequest();
        getSpiceManager().execute(request, new RequestListener<CoffeePost>() {
            @Override
            public void onRequestFailure(SpiceException spiceException) {
                Log.e(TAG, "Onrequest failure", spiceException);
            }

            @Override
            public void onRequestSuccess(CoffeePost coffeePost) {
                Log.v(TAG, "Onrequest onRequestSuccess: " + coffeePost);
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
