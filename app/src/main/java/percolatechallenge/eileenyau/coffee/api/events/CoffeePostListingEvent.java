package percolatechallenge.eileenyau.coffee.api.events;

import percolatechallenge.eileenyau.coffee.api.responses.CoffeePostListing;

public class CoffeePostListingEvent extends BaseEvent {

    private CoffeePostListing mResult;

    public CoffeePostListingEvent(CoffeePostListing mResult) {
        super(true);
        this.mResult = mResult;
    }

    public CoffeePostListingEvent(String errorMsg) {
        super(errorMsg);
    }


    public CoffeePostListing getResult() {
        return mResult;
    }
}
