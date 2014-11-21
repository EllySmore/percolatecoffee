package percolatechallenge.eileenyau.coffee;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import percolatechallenge.eileenyau.coffee.commons.BaseActivity;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.CoffeeActivity;

public class EntryActivity extends BaseActivity {

    private static final String TAG = EntryActivity.class.getSimpleName();
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        final Intent launchIntent = new Intent();
        launchIntent.setClass(getApplicationContext(), CoffeeActivity.class);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(launchIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 1000);
    }

}
