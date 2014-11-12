package percolatechallenge.eileenyau.coffee.commons;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "----------> OnCreate");
    }

    @Override
    protected void onStart() {
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
        super.onStop();
        Log.v(TAG, "----------> onStop");
    }
}
