package percolatechallenge.eileenyau.coffee.commons;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import de.greenrobot.event.EventBus;

public class BaseActivity extends ActionBarActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "----------> OnCreate");
    }

    @Override
    protected void onStart() {
        try {
            // Throws exception if Fragment doesn't contain onEvent method
            EventBus.getDefault().register(this);
        } catch (Throwable t) {
            Log.v(TAG, "Unable to add EventBus");
        }
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
        try {
            // Throws exception if Fragment doesn't contain onEvent method
            EventBus.getDefault().unregister(this);
        } catch (Throwable t) {
            Log.v(TAG, "Unable to add EventBus");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "----------> onStop");
    }

    /**
     * Add fragment to backstack if backstackname is given.
     *
     * @param fragment      - Fragment to display
     * @param backStackName - Name required to put fragment in backstack
     */
    public void replaceFragment(Fragment fragment, String backStackName, int containerId) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        if (backStackName != null) {
            ft.addToBackStack(backStackName);
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}
