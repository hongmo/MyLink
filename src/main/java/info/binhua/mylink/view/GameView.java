package info.binhua.mylink.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import info.binhua.mylink.board.GameService;
import info.binhua.mylink.object.LinkInfo;
import info.binhua.mylink.util.ImageUtil;

/**
 * Created by Administrator on 14-2-19.
 */
public class GameView extends View{

    //游戏逻辑的实现类
    private GameService gameService;
    //保存当前已被选中的图片
    private Piece selectedPiece;
    //连接信息对象
    private LinkInfo linkInfo;
    private Paint paint;
    //选中标识的图片对象
    private Bitmap selectImage;

    public GameView(Context context, AttributeSet attrs){
        super(context,attrs);
        this.paint = new Paint();
        //设置连接线的颜色
        this.paint.setColor(Color.RED);
        //设置连接线的粗细
        this.paint.setStrokeWidth(3);
      //TODO:  this.selectImage = ImageUtil.getSelectImage(context);
    }

    public void setLinkInfo(LinkInfo linkInfo){
        this.linkInfo = linkInfo;
    }
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(this.gameService == null){
            return;
        }
        Piece[][] pieces = gameService.getPieces();
        if(pieces != null){
            //遍历pieces二维数组
            for(int i=0; i<pieces.length; i++){
                for(int j=0; j<pieces[i].length;j++){
                    //如果二维数组中该元素不为空（即有方块），将这个方块的图片画出来
                    if(pieces[i][j] != null){

                        //得到这个Piece对象
                        Piece piece = pieces[i][j];
                        //根据方块左上角的XY坐标绘制方块
                        canvas.drawBitmap(piece.getImage().getImage(), piece.getBeginX(), piece.getBeninY(), null);
                    }
                }
            }
        }

         //如果当前对象中有linkinfo对象，即连接信息
        if(this.linkInfo != null){
            //绘制连接线
            drawLine(this.linkInfo, canvas);
            //处理完后清空linkInfo对象
            this.linkInfo = null;
        }
    }

    //根据LinkInfo绘制连接线的方法
    public void drawLine(LinkInfo linkInfo, Canvas canvas){
        //获取LinkInfo中封装的所有链接点
        List<Point> points = linkInfo.getLinkPoints();
        //依次遍历points中的每个连接点
        for(int i=0; i<points.size()-1; i++){
            //获取当前连接点与下一个连接点
            Point currentPoint = points.get(i);
            Point nextPoint = points.get(i+1);
            //绘制连线
            canvas.drawLine(currentPoint.x, currentPoint.y,
                    nextPoint.x,nextPoint.y,this.paint);
        }
    }

    //设置当前方块选中的方法
    public void setSelectedPiece(Piece piece){
        this.selectedPiece = piece;
    }
    //开始游戏方法
    public void startGame(){
        this.gameService.start();
        this.postInvalidate();
    }
}
