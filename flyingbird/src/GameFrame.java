import javax.swing.*;
import java.awt.*;

/**
 * 游戏启动时进入准备状态
 *      游戏来说里面的对象都是静止的，并且有一张准备开始的图片
 *
 * 游戏运行状态
 *      游戏内的对象都开始运动
 *
 * 游戏结束状态
 *      游戏内的所有对象都静止
 */

public class GameFrame extends JFrame {
    public static final int FRAME_HIGHT = 644;
    public static final int FRAME_WEIGHT = 421;

    public GameFrame(){
        //设置窗体的尺寸（宽度，高度)
        setSize(FRAME_WEIGHT,FRAME_HIGHT);
        //设置居中显示
        setLocationRelativeTo(null);
        //设置关闭窗体的同时终止程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置标题
        setTitle("飞扬的小鸟");
        //设置窗体不可改变
        setResizable(false);
        //设置Logo
        setIconImage(App.getImg("../flyingbird/img/0.png"));

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->      //创建一个窗体对象；调用窗体的构造方法，制作窗体
        {
            GameFrame frame = new GameFrame();
            //创建一个画板对象；调用画板的构造方法，制作面板
            GamePanel panel = new GamePanel();
            frame.add(panel);
            //添加音乐
//        Mp3 mp3 = new Mp3("../flyingbird/img/Five Hundred Miles.wav");
//        mp3.p();
            //显示窗体
            frame.setVisible(true);
        });
    }
}
