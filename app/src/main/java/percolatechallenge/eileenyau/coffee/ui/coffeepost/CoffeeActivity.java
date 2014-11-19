package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.app.Fragment;
import android.os.Bundle;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.commons.BaseActivity;

public class CoffeeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment_container);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(getContainerId(), CoffeeListingFragment.newInstance())
                    .commit();
        }
    }

    private int getContainerId() {
        return R.id.container;
    }

    public void replaceFragment(Fragment fragment, String backStackName) {
        replaceFragment(fragment, backStackName, getContainerId());
    }

}
