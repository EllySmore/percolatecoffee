package percolatechallenge.eileenyau.coffee.ui.coffeepost;

import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.ParseException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.events.CoffeeExpandedPostEvent;
import percolatechallenge.eileenyau.coffee.api.requests.CoffeeExpandedPostRequest;
import percolatechallenge.eileenyau.coffee.commons.BaseFragment;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.models.CoffeeExpandedPostData;
import percolatechallenge.eileenyau.coffee.util.ContactUtil;

public class CoffeePostFragment extends BaseFragment {

    private static final String TAG = CoffeePostFragment.class.getSimpleName();

    private static final String PARAM_COFFEE_ID = "PARAM_COFFEE_ID";

    private static final int MENU_EMAIL = 100;

    @InjectView(R.id.entry)
    protected LinearLayout mEntry;

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    @InjectView(R.id.entry_name)
    protected TextView mEntryName;

    @InjectView(R.id.entry_description)
    protected TextView mEntryDescription;

    @InjectView(R.id.entry_img)
    protected ImageView mEntryImage;

    @InjectView(R.id.entry_time_updated)
    protected TextView mEntryLastUpdated;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_coffee_post, container, false);
        ButterKnife.inject(this, mRootView);
        fetchCoffeePost();
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ActionBarActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(mCoffeeId);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(Menu.NONE, MENU_EMAIL, Menu.NONE, R.string.email).
                setIcon(R.drawable.nav_mail).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                removeCurrentFragment();
                break;
            case MENU_EMAIL:
                emailPost();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchCoffeePost() {
        showLoading(true);
        CoffeeExpandedPostRequest request = new CoffeeExpandedPostRequest(mCoffeeId);
        getSpiceManager().execute(request, request);
    }

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            mProgressBar.setVisibility(View.VISIBLE);
            mEntry.setVisibility(View.INVISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
            mEntry.setVisibility(View.VISIBLE);
        }
    }

    private void updateUI() throws ParseException {
        mEntryName.setText(mCoffeeData.getEntryName());
        mEntryDescription.setText(mCoffeeData.getEntryDescription());
        if (!mCoffeeData.getEntryImageUrl().isEmpty()) {
            Picasso.with(getActivity()).load(mCoffeeData.getEntryImageUrl()).into(mEntryImage);
        }
        mEntryLastUpdated.setText("Updated " + mCoffeeData.getFormattedLastTimeUpdated() + " ago");
    }

    private void emailPost() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mCoffeeData.getEntryName());
        stringBuilder.append(mCoffeeData.getEntryDescription());
        stringBuilder.append(mCoffeeData.getEntryImageUrl());
        stringBuilder.append(mCoffeeData.getLastTimeUpdated());
        String emailBody = stringBuilder.toString();
        try {
            ContactUtil.sendEmail(getActivity(), "", getString(R.string.app_name), emailBody);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), getString(R.string.email_error_msg),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(CoffeeExpandedPostEvent event) throws ParseException {
        showLoading(false);
        if (event.isSuccess()) {
            mCoffeeData = new CoffeeExpandedPostData(event.getResult());
            updateUI();
        }
    }

}
