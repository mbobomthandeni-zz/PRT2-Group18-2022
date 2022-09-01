package za.ac.cput.browse;

public class Model {

    String mBookName;
    String mBookDetail;
    int mBookPhoto;

    public Model(String mBookName, String mBookDetail, int mBookPhoto) {
        this.mBookName = mBookName;
        this.mBookDetail = mBookDetail;
        this.mBookPhoto = mBookPhoto;
    }

    public String getmBookName() {
        return mBookName;
    }

    public String getmBookDetail() {
        return mBookDetail;
    }

    public int getmBookPhoto() {
        return mBookPhoto;
    }
}
