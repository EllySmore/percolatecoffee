package percolatechallenge.eileenyau.coffee.ui.coffeepost.models;

import percolatechallenge.eileenyau.coffee.api.responses.CoffeeExpandedPost;

public class CoffeeExpandedPostData {

    private CoffeeExpandedPost mCoffeeExpandedPost;

    public CoffeeExpandedPostData(CoffeeExpandedPost coffeeExpandedPost) {
        mCoffeeExpandedPost = coffeeExpandedPost;
    }

    public String getEntryName() {
        return mCoffeeExpandedPost.getName();
    }

    public String getEntryId() {
        return mCoffeeExpandedPost.getId();
    }

    public String getEntryDescription() {
        return mCoffeeExpandedPost.getDesc();
    }

    public String getEntryImageUrl() {
        return mCoffeeExpandedPost.getImageUrl();
    }

    public String getLastTimeUpdated() {
        return mCoffeeExpandedPost.getLastUpdatedAt();
    }
}
