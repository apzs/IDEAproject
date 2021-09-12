
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird {
    //鸟的图片
    BufferedImage img;
    //x坐标
    int x;
    //y坐标
    int y;
    //鸟的宽度
    int w;
    //鸟的高度
    int h;
    //用来装一组图片的容器
    List<BufferedImage> list;

    //初速度
    double v0;
    //时间间隔(往上移动的时间）
    double t;
    //距离
    double s;
    //重力
    double g;

    //鸟的构造器
    public Bird(){
        img = App.getImg("../flyingbird/img/0.png");
        //设置x坐标
        x = 150;
        //设置y坐标
        y = 200;
        //设置宽度
        w = img.getWidth()/2;
        //设置高度
        h = img.getHeight()/2;
        //初始化装图片容器
        list = new ArrayList<BufferedImage>();
        //向容器中添加图片
        for(int i = 0;i <= 7;i++) {
            list.add(App.getImg("../flyingbird/img/"+i+".png"));

        v0 = 3;
        //时间
        t = 0.2;
        //距离
        s = 0;
        //重力
        g = 5;
        }
    }
    int index = 0;
    //鸟的翅膀动态方法
    public  void  fly(){
            img = list.get(index % list.size());
            index++;
    }

    //小鸟的落体运动
    public void move(){
        //计算小鸟上抛的距离
        s = v0 * t;
        //得到小鸟抛到最高点是的y坐标
        y = y + (int) s ; //小鸟到的最高点
        //计算小鸟到达最高点时的速度
        double v2 = v0 + g * t;
        //最高点速度就是小鸟落下的初速度
        v0 = v2;
    }

    //小鸟上抛
    public void moveUp(){
        v0 = -10;  //向下飞为正方向
    }
}
