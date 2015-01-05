package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.commons.BaseActivity;

public class CoffeeActivity extends BaseActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment_container);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setLogo(R.drawable.drip_white);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(getContainerId(), CoffeeListingFragment.newInstance())
                    .commit();
        }
    }

    private int getContainerId() {
        return R.id.container;
    }

}
