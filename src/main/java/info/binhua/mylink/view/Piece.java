package info.binhua.mylink.view;

/**
 * Created by Administrator on 14-2-18.
 */
public class Piece {
    //保存方块对象所对应的图片
    private PieceImage image;
    //方块的左上角坐标
    private int beginX;
    //方块的左上角的Y坐标
    private int beninY;
    //该对象在Piece[][]数组中的第一维索引值
    private int indexX;
    //该对象在Piece[][]数组中的第二维索引值
    private int indexY;
    //只设置该Piece对象在棋盘数组中的位置
    public Piece(int indexX, int indexY){
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public int getBeginX() {
        return beginX;
    }

    public void setBeginX(int beginX) {
        this.beginX = beginX;
    }

    public int getBeninY() {
        return beninY;
    }

    public void setBeninY(int beninY) {
        this.beninY = beninY;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public PieceImage getImage() {
        return image;
    }

    public void setImage(PieceImage image) {
        this.image = image;
    }

    //判断两个Pieces上的图片时候相等
    public boolean isSameImage(Piece other){
        if(image == null){
            if(other.image != null){
                return false;
            }
        }
        //主要Piece封装图片ID相同，即可以认为两个Piece相等
        return image.getImageId() == other.image.getImageId();
    }
}
