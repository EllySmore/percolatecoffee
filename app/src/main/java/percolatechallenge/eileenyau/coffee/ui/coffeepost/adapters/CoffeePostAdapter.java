package percolatechallenge.eileenyau.coffee.ui.coffeepost.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePostListing;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.widgets.CoffeePostRow;

public class CoffeePostAdapter extends BaseAdapter {

    private CoffeePostListing mCoffeePostListing = new CoffeePostListing();

    @Override
    public int getCount() {
        return mCoffeePostListing.getCoffeeData().size();
    }

    @Override
    public CoffeePost getItem(int position) {
        return mCoffeePostListing.getCoffeeData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CoffeePostRow rowView = (CoffeePostRow) convertView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (rowView == null) {
            rowView = (CoffeePostRow) inflater
                    .inflate(R.layout.row_coffee_post_impl, parent, false);
        }
        rowView.updateUI(getItem(position));
        return rowView;
    }

    public void setCoffeePostListing(CoffeePostListing mCoffeePostListing) {
        this.mCoffeePostListing = mCoffeePostListing;
    }
}
