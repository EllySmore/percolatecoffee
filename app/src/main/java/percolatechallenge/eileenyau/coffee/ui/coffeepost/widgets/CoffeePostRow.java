package percolatechallenge.eileenyau.coffee.ui.coffeepost.widgets;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import percolatechallenge.eileenyau.coffee.R;
import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;

public class CoffeePostRow extends RelativeLayout {

    @InjectView(R.id.entry_name)
    protected TextView mEntryName;

    @InjectView(R.id.entry_description)
    protected TextView mEntryDescription;

    @InjectView(R.id.entry_img)
    protected ImageView mEntryImg;

    @InjectView(R.id.expand_post_button)
    protected ImageView mEntryExpandButton;

    public CoffeePostRow(Context context) {
        this(context, null);
    }

    public CoffeePostRow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CoffeePostRow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.row_coffee_post, this);
        ButterKnife.inject(this);
    }

    public void updateUI(CoffeePost post) {
        mEntryName.setText(post.getName());
        mEntryDescription.setText(post.getDesc());
        Uri uri = Uri.parse(post.getImageUrl());
        Picasso.with(getContext().getApplicationContext()).load(uri).into(mEntryImg);

    }

}
