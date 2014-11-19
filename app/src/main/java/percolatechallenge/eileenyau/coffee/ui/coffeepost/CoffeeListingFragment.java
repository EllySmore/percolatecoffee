package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.events.CoffeePostListingEvent;
import percolatechallenge.eileenyau.coffee.api.requests.CoffeePostsRequest;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePostListing;
import percolatechallenge.eileenyau.coffee.commons.BaseFragment;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.adapters.CoffeePostAdapter;

public class CoffeeListingFragment extends BaseFragment {

    private static final String TAG = CoffeeListingFragment.class.getSimpleName();

    @InjectView(R.id.coffee_post_list)
    protected ListView mList;

    private View mRootView;

    private CoffeePostListing mCoffeeListing;

    private CoffeePostAdapter mAdapter;

    public static CoffeeListingFragment newInstance() {
        CoffeeListingFragment coffeeListingFragment = new CoffeeListingFragment();
        return coffeeListingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_coffee_listing, container, false);
        ButterKnife.inject(this, mRootView);
        setAdapter();
        getCoffeePostListing();
        return mRootView;
    }

    private void setAdapter() {
        mAdapter = new CoffeePostAdapter();
        mList.setAdapter(mAdapter);
    }

    private void getCoffeePostListing() {
        CoffeePostsRequest request = new CoffeePostsRequest();
        getSpiceManager().execute(request, request);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(CoffeePostListingEvent event) {
        Log.v(TAG, "Recieved event:" + event.getResult());
        if (event.isSuccess()) {
            mCoffeeListing = event.getResult();
            mAdapter.setCoffeePostListing(mCoffeeListing);
            mAdapter.notifyDataSetChanged();
        }
    }

}
