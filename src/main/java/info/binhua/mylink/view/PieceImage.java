package info.binhua.mylink.view;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 14-2-19.
 */
public class PieceImage {
    private Bitmap image;
    private int imageId;

    public PieceImage(Bitmap image, int imageId){
        super();
        this.image = image;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
