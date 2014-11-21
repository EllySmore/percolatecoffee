package percolatechallenge.eileenyau.coffee.api.events;

public class BaseEvent {

    private boolean mIsSuccess;

    private String mErrorMsg;

    public BaseEvent() {
    }

    public BaseEvent(boolean isSuccess) {
        mIsSuccess = isSuccess;
    }

    public BaseEvent(String error) {
        mIsSuccess = false;
        mErrorMsg = error;
    }

    public boolean isSuccess() {
        return mIsSuccess;
    }
}
