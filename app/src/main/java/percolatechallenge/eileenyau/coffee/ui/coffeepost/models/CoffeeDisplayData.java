package percolatechallenge.eileenyau.coffee.ui.coffeepost.models;

import percolatechallenge.eileenyau.coffee.api.responses.CoffeePost;

public class CoffeeDisplayData {

    private CoffeePost mCoffeePost;

    public CoffeeDisplayData(CoffeePost coffeePost) {
        this.mCoffeePost = coffeePost;
    }

    public String getEntryName() {
        return mCoffeePost.getName();
    }

    public String getEntryId() {
        return mCoffeePost.getId();
    }

    public String getEntryDescription() {
        return mCoffeePost.getDesc();
    }

    public String getEntryImageUrl() {
        return mCoffeePost.getImageUrl();
    }

}
