package percolatechallenge.eileenyau.coffee.commons;

import android.app.Fragment;
import android.util.Log;

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
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        spiceManager.shouldStop();
        Log.v(TAG, "onPause");
        try {
            // Throws exception if Fragment doesn't contain onEvent method
            EventBus.getDefault().unregister(this);
        } catch (Throwable t) {
        }
    }
}
