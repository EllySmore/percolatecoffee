package percolatechallenge.eileenyau.coffee.commons;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.okhttp.OkHttpSpiceService;

import percolatechallenge.eileenyau.coffee.api.SpiceService;

public class BaseActivity extends Activity {

    private final String TAG = this.getClass().getSimpleName();

    private SpiceManager spiceManager = new SpiceManager(SpiceService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "----------> OnCreate");
    }

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
        Log.v(TAG, "----------> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "----------> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "----------> onPause");
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
        Log.v(TAG, "----------> onStop");
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

}
