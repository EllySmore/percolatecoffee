package percolatechallenge.eileenyau.coffee.api.responses;


public class CoffeeExpandedPost extends CoffeePost {

    private String last_updated_at;

    public String getLastUpdatedAt() {
        return last_updated_at;
    }

    public void setLast_updated_at(String last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        CoffeeExpandedPost that = (CoffeeExpandedPost) o;

        if (last_updated_at != null ? !last_updated_at.equals(that.last_updated_at)
                : that.last_updated_at != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (last_updated_at != null ? last_updated_at.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoffeeExpandedPost{" +
                "last_updated_at='" + last_updated_at + '\'' +
                '}';
    }
}
