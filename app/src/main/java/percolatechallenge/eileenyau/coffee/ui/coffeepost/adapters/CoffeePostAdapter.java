package percolatechallenge.eileenyau.coffee.ui.coffeepost.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.models.CoffeeDisplayData;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.widgets.CoffeePostRow;

public class CoffeePostAdapter extends BaseAdapter {

    private ArrayList<CoffeeDisplayData> mData = new ArrayList<CoffeeDisplayData>();

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CoffeeDisplayData getItem(int position) {
        return mData.get(position);
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
            rowView = (CoffeePostRow) inflater.inflate(R.layout.row_coffee_post_impl, parent, false);
        }
        rowView.updateUI(getItem(position));
        return rowView;
    }

    public void setData(ArrayList<CoffeeDisplayData> data) {
        this.mData = data;
    }
}
