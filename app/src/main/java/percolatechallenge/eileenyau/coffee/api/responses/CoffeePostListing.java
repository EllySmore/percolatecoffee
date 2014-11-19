package percolatechallenge.eileenyau.coffee.api.responses;

import java.util.ArrayList;

public class CoffeePostListing {

    private ArrayList<CoffeePost> mCoffeeData = new ArrayList<CoffeePost>();

    public ArrayList<CoffeePost> getCoffeeData() {
        return mCoffeeData;
    }

    public void setCoffeeData(ArrayList<CoffeePost> mCoffeeData) {
        this.mCoffeeData = mCoffeeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CoffeePostListing that = (CoffeePostListing) o;

        if (mCoffeeData != null ? !mCoffeeData.equals(that.mCoffeeData) : that.mCoffeeData != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mCoffeeData != null ? mCoffeeData.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ListingOfCoffeePost{" +
                "mCoffeeData=" + mCoffeeData +
                '}';
    }
}
