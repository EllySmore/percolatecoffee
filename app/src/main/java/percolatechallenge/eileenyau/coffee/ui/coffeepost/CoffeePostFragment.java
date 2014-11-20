package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.events.CoffeeExpandedPostEvent;
import percolatechallenge.eileenyau.coffee.api.requests.CoffeeExpandedPostRequest;
import percolatechallenge.eileenyau.coffee.commons.BaseFragment;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.models.CoffeeExpandedPostData;

public class CoffeePostFragment extends BaseFragment {

    private static final String TAG = CoffeePostFragment.class.getSimpleName();

    private static String PARAM_COFFEE_ID = "PARAM_COFFEE_ID";

    @InjectView(R.id.entry_name)
    protected TextView mEntryName;

    @InjectView(R.id.entry_description)
    protected TextView mEntryDescription;

    @InjectView(R.id.entry_img)
    protected ImageView mEntryImage;

    private View mRootView;

    private String mCoffeeId;

    private CoffeeExpandedPostData mCoffeeData;

    public static CoffeePostFragment newInstance(String coffeeId) {
        CoffeePostFragment coffeePostFragment = new CoffeePostFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_COFFEE_ID, coffeeId);
        coffeePostFragment.setArguments(bundle);
        return coffeePostFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle extras = getArguments();
        if (extras != null) {
            mCoffeeId = extras.getString(PARAM_COFFEE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_coffee_post, container, false);
        ButterKnife.inject(this, mRootView);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        fetchCoffeePost();
        return mRootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                removeCurrentFragment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchCoffeePost() {
        CoffeeExpandedPostRequest request = new CoffeeExpandedPostRequest(mCoffeeId);
        getSpiceManager().execute(request, request);
    }

    private void updateUI() {
        mEntryName.setText(mCoffeeData.getEntryName());
        mEntryDescription.setText(mCoffeeData.getEntryDescription());
        Picasso.with(getActivity()).load(mCoffeeData.getEntryImageUrl()).into(mEntryImage);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(CoffeeExpandedPostEvent event) {
        Log.v(TAG, "Recieved event:" + event.getResult());
        if (event.isSuccess()) {
            mCoffeeData = new CoffeeExpandedPostData(event.getResult());
            updateUI();
        }
    }

}
