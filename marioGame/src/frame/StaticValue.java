package frame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class StaticValue {
    //马里奥图片
    public static List<BufferedImage> allMarioImage = new ArrayList<>();
    //开始图片
    public static BufferedImage startImage = null;
    //结束图片
    public static BufferedImage endImage = null;
    //背景图片
    public static BufferedImage bgImage = null;
    //花
    public static List<BufferedImage> allFlowerImage = new ArrayList<>();
    //蘑菇头
    public static List<BufferedImage> allTriangleImage = new ArrayList<>();
    //乌龟
    public static List<BufferedImage> allTurtleImage = new ArrayList<>();
    //障碍物
    public static List<BufferedImage> allObstructionImage = new ArrayList<>();
    //马里奥死亡图片
    public static BufferedImage marioDeadImage = null;

    //初始化图片
    public static void init(){
        //马里奥图片
        for(int i = 1;i <= 10;i++){
        allMarioImage.add(MyImage.getImage("/img/" + i + ".gif"));
        }
        //开始图片
        startImage = MyImage.getImage("/img/start.gif");
        //结束图片
        endImage = MyImage.getImage("/img/firststageend.gif");
        //背景图片
        bgImage = MyImage.getImage("/img/firststage.gif");
        //花
        for(int i= 1;i <= 2;i++) {
            allMarioImage.add(MyImage.getImage("/img/flower" + i + ".gif"));
        }
        //蘑菇头
        for (int i = 1;i <= 3;i++){
            allTriangleImage.add(MyImage.getImage("/img/triangle" + i + ".gif"));
        }
        //乌龟
        for (int i = 1;i <= 5;i++) {
            allTurtleImage.add(MyImage.getImage("/img/Turtle" + i +".gif"));
        }
        //障碍物
        for(int i= 1;i <= 12;i++){
            allObstructionImage.add(MyImage.getImage("/img/ob" + i + ".gif"));
        }
        //马里奥死亡图片
        marioDeadImage = MyImage.getImage("/img/over.gif");
    }
}
