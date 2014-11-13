package percolatechallenge.eileenyau.coffee.ui.coffeepost.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.ui.coffeepost.widgets.CoffeePostRow;

public class CoffeePostAdapter extends BaseAdapter {

    //TODO: WIP
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CoffeePostRow rowView = (CoffeePostRow) convertView;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (rowView == null) {
            rowView = (CoffeePostRow) inflater
                    .inflate(R.layout.row_coffee_post_impl, parent, false);
        }
        return rowView;
    }
}
