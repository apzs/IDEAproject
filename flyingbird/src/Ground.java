import java.awt.image.BufferedImage;
//地面类
public class Ground {
    //x坐标
    int x;
    //y坐标
    int y;
    //地面的图片
    BufferedImage img;
    //地面宽度
    int w;
    //地面的高度
    int h;

    public Ground(){
        //初始化地面图片
        img = App.getImg("../flyingbird/img/ground.png");
        //获取图片高度
        h = img.getHeight();
        //获取图片高度
        w = img.getWidth();
        //初始化x
        x = 0;
        //初始化y
        y = 644 - h;
    }

    //地面移动方法
    public void  move(){
        if(x <= -(w - 432))
            x = 0;
        x--;
    }
}
