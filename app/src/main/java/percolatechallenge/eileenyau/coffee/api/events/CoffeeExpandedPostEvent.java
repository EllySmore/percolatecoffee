package percolatechallenge.eileenyau.coffee.api.events;

import percolatechallenge.eileenyau.coffee.api.responses.CoffeeExpandedPost;

public class CoffeeExpandedPostEvent extends BaseEvent {

    private CoffeeExpandedPost mResult;

    public CoffeeExpandedPostEvent(CoffeeExpandedPost mResult) {
        super(true);
        this.mResult = mResult;
    }

    public CoffeeExpandedPostEvent(String errorMsg) {
        super(errorMsg);
    }


    public CoffeeExpandedPost getResult() {
        return mResult;
    }
}
