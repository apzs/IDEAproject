import java.awt.image.BufferedImage;
import java.util.Random;

//柱子类
public class Column {
    //柱子图片
    BufferedImage img;
    //x坐标
    int x;
    //y坐标
    int y;
    //柱子宽度
    int w;
    //柱子高度
    int h;
    //柱子间距
    int dis;

    Random random;

    //构造器初始化柱子对象
    public Column(int i){
        dis = 160;
        //初始化柱子图片
        img = App.getImg("../flyingbird/img/column.png");
        //获取图片的宽度
        w = img.getWidth()/2;
        //获取图片的高度
        h = img.getHeight()/2;
        //x坐标
        x = 300 + dis*(i -1);
        //y坐标
        random = new Random();
        y = -random.nextInt(h + 146 - 644); //柱子的高度 - 地面的高度 - 窗体的高度 = 可移动的范围
    }

    //柱子移动
    public void move(){
        x--;
        if(x <= -w){
            x= 3*dis - w;
            y = -random.nextInt(h + 146 - 644);
        }
    }
}
