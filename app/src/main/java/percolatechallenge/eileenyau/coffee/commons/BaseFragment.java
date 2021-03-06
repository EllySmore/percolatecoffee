package percolatechallenge.eileenyau.coffee.commons;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.octo.android.robospice.SpiceManager;

import de.greenrobot.event.EventBus;
import percolatechallenge.eileenyau.coffee.api.SpiceService;

public class BaseFragment extends Fragment {

    private SpiceManager spiceManager = new SpiceManager(SpiceService.class);

    private String TAG = this.getClass().getSimpleName();

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

    @Override
    public void onStart() {
        super.onStart();
        spiceManager.start(getActivity());
        Log.v(TAG, "OnStart");
        try {
            // Throws exception if Fragment doesn't contain onEvent method
            EventBus.getDefault().register(this);
        } catch (Throwable t) {
            Log.v(TAG, "Unable to add EventBus");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        spiceManager.shouldStop();
        Log.v(TAG, "onStop");
        try {
            // Throws exception if Fragment doesn't contain onEvent method
            EventBus.getDefault().unregister(this);
        } catch (Throwable t) {
            Log.v(TAG, "Unable to add EventBus");
        }
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

    /**
     * Remove fragment fro activity
     */
    public void removeCurrentFragment() {
        getActivity().getFragmentManager().popBackStack();
    }

    public ActionBar getActionBar() {
        if (getActivity().getActionBar() == null) {
            return null;
        }
        return getActivity().getActionBar();

    }
}
