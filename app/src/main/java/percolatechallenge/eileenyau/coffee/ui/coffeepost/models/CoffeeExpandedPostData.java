package percolatechallenge.eileenyau.coffee.ui.coffeepost.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getFormattedLastTimeUpdated() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastDate = dateFormat.parse(mCoffeeExpandedPost.getLastUpdatedAt());
        Date todayDate = new Date();
        long timeDifference = lastDate.getTime() - todayDate.getTime();
        long diffHours = timeDifference / (60 * 60 * 1000);
        int diffInDays = (int) timeDifference / (1000 * 60 * 60 * 24);
        int diffInWeek = (int) timeDifference / (1000 * 60 * 60 * 24 * 7);
        if (diffInWeek != 0) {
            return String.valueOf(diffInWeek).replaceAll("\\D+", "") + " Week";
        }
        if (diffInDays != 0) {
            return String.valueOf(diffInDays).replaceAll("\\D+", "") + " Day";
        }
        if (diffHours != 0) {
            return String.valueOf(diffHours).replaceAll("\\D+", "") + " Hour";
        }
        return "Now";
    }
}
