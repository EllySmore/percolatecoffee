package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.events.CoffeePostListingEvent;
import percolatechallenge.eileenyau.coffee.api.requests.CoffeePostsRequest;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePostListing;
import percolatechallenge.eileenyau.coffee.commons.BaseFragment;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.adapters.CoffeePostAdapter;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.models.CoffeeDisplayData;

public class CoffeeListingFragment extends BaseFragment {

    private static final String TAG = CoffeeListingFragment.class.getSimpleName();

    @InjectView(R.id.coffee_post_list)
    protected ListView mList;

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private View mRootView;

    private ArrayList<CoffeeDisplayData> mCoffeeData = new ArrayList<CoffeeDisplayData>();

    private CoffeePostAdapter mAdapter;

    public static CoffeeListingFragment newInstance() {
        CoffeeListingFragment coffeeListingFragment = new CoffeeListingFragment();
        return coffeeListingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_coffee_listing, container, false);
        ButterKnife.inject(this, mRootView);
        setAdapter();
        getCoffeePostListing();
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ActionBarActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(R.string.app_name);
    }

    private void setAdapter() {
        mAdapter = new CoffeePostAdapter();
        mList.setAdapter(mAdapter);
    }

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            mProgressBar.setVisibility(View.VISIBLE);
            mList.setVisibility(View.INVISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
            mList.setVisibility(View.VISIBLE);
        }
    }

    private void getCoffeePostListing() {
        showLoading(true);
        CoffeePostsRequest request = new CoffeePostsRequest();
        getSpiceManager().execute(request, request);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(CoffeePostListingEvent event) {
        showLoading(false);
        if (event.isSuccess()) {
            mCoffeeData.clear();
            CoffeePostListing mCoffeeListing = event.getResult();
            for (CoffeePost coffeePost : mCoffeeListing.getCoffeeData()) {
                mCoffeeData.add(new CoffeeDisplayData(coffeePost));
            }
            mAdapter.setData(mCoffeeData);
            mAdapter.notifyDataSetChanged();
        }
    }

    @OnItemClick(R.id.coffee_post_list)
    protected void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CoffeeDisplayData coffeeData = mAdapter.getItem(position);
        launchCoffeePostScreen(coffeeData.getEntryId());
    }

    private void launchCoffeePostScreen(String coffeeId) {
        CoffeePostFragment coffeePostFragment = CoffeePostFragment.newInstance(coffeeId);
        replaceFragment(coffeePostFragment, TAG, getContainerId());
    }

    private int getContainerId() {
        return R.id.container;
    }

}
