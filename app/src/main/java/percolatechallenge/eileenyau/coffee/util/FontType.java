package percolatechallenge.eileenyau.coffee.util;

public enum FontType {

    ROBOTO_REGULAR("Roboto-Regular.ttf"),
    ROBOTO_LIGHT("Roboto-Light.ttf"),;

    private String mFileName;

    private FontType(String fileName) {
        mFileName = fileName;
    }

    public String getFileName() {
        return mFileName;
    }
}