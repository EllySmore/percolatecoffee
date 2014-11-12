package percolatechallenge.eileenyau.coffee.api.models;

import com.google.api.client.util.Key;

public class CoffeeExpandedPost {

    @Key
    private String last_updated_at;

    @Key
    private String desc;

    @Key
    private String image_url;

    @Key
    private String id;

    @Key
    private String name;

    public String getLastUpdatedAt() {
        return last_updated_at;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.last_updated_at = lastUpdatedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeExpandedPost that = (CoffeeExpandedPost) o;

        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (image_url != null ? !image_url.equals(that.image_url) : that.image_url != null)
            return false;
        if (last_updated_at != null ? !last_updated_at.equals(that.last_updated_at) : that.last_updated_at != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = last_updated_at != null ? last_updated_at.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoffeeExpandedPost{" +
                "last_updated_at='" + last_updated_at + '\'' +
                ", desc='" + desc + '\'' +
                ", image_url='" + image_url + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
