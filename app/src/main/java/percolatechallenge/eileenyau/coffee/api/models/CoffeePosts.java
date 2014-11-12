package percolatechallenge.eileenyau.coffee.api.models;

import com.google.api.client.util.Key;

public class CoffeePosts {

    @Key
    private String desc;

    @Key
    private String image_url;

    @Key
    private String id;

    @Key
    private String name;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
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

        CoffeePosts that = (CoffeePosts) o;

        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (image_url != null ? !image_url.equals(that.image_url) : that.image_url != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = desc != null ? desc.hashCode() : 0;
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoffeePosts{" +
                "desc='" + desc + '\'' +
                ", image_url='" + image_url + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
