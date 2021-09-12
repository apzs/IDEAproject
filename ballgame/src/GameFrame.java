import javax.swing.*;
import java.awt.*;

/**
 * 游戏的窗体类： JFrame
 * 自定义窗体步骤
 * 1、写一个类继承JFrame
 * 2、写一个构造方法、确定窗体的特点
 * 类：一系列具有相同特点和行为的东西归纳一起称为类
 * 对象：实际存在的个体
 *
 * extends : 继承
 */

public class GameFrame extends JFrame {
    public GameFrame(){
        //设置标题
        setTitle("球球大作战");
        //设置大小
        setSize(512,800);
        //设置位置居中显示
        setLocationRelativeTo(null);
        //设置不允许改变界面大小
        setResizable(false);
        //当关闭窗体时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Java程序的入口
     */
    public static void main(String[] args){
        EventQueue.invokeLater(()->
        {
            //创建窗体对象
            GameFrame frame = new GameFrame();
            //创建面板对象
            GamePanel panel = new GamePanel();
            //将面板加入到窗体中
            frame.add(panel);
            //让窗体显示setVisible(true)设置可见性 true 显示 ，false 隐藏
            frame.setVisible(true);

        }
        );
    }


}
