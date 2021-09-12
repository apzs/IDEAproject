import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * JFrame是创建窗体的swing类，用来创建一个图形界面的原始窗口
 * 并设置其大小，位置等属性，是swing编程的基础类之一。
 *
 * JFrame中的方法：
 * setTitle()      设置窗体标题
 * setSize()       设置窗体大小
 * setLocation()   设置窗体初始显示的位置
 * setResizable()  设置窗体是否可以改变大小
 * setDefaultCloseOperation(JFrame.EXT_ON_CLOSE)       设置窗体关闭方式，关闭窗体时同时结束程序
 * setVisible()    设置窗体是否显示
 * 取得屏幕大小
 * Toolkit.getDefaultToolkit().getScreenSize().width
 * Toolkit.getDefaultToolkit().getScreenSize().height
 *
 * MouseListener中的方法
 * MouseListener的使用方法，需要调用JFrame的addMouseListener方法加入监听。
 * mouseClicked(MouseEvent e)   监听鼠标点击事件的操作
 * mouseEntered(MouseEvent e)   监听鼠标进入事件的操作
 * mouseExited(MouseEvent e)    监听鼠标离开事件的操作
 * mousePressed(MouseEvent e)   监听鼠标按下事件的操作
 * mouseReleased(MouseEvent e)  监听鼠标抬起事件的操作
 * 鼠标点击时执行的顺序是：
 * mousePressed-->mouseReleased-->mouseClicked (判断按下与抬起是否在同一位置)
 *
 * MouseEvent
 * getX()   得到鼠标的横向位置坐标
 * getY()   饿到鼠标的纵向位置坐标
 *
 * Graphics中的方法
 * drawString()    绘制字符串
 * drawOval()      绘制一个空心的圆形
 * fillOval()      绘制一个实心的圆形
 * drawLine()      绘制一条线
 * drawRect()      绘制一个空心的矩形
 * fillRect()      绘制一个实心的矩形
 * drawImage()     绘制一个已经存在的图片，将一个图片直接显示到窗体中
 * setColor        绘制画笔颜色
 * setFont()       绘制文字的字体
 */
public class MyChessFrame extends JFrame implements MouseListener {

    public MyChessFrame() {
        this.setTitle("五子棋");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//        System.out.println("宽度为"+width);
//        System.out.println("高度为"+height);
        this.setLocation((width - 200) / 2, (height - 100) / 2);
//        this.setLocationRelativeTo(null);
        this.addMouseListener(this); //this传入MoseListener
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
//        g.drawString("五子棋游戏",20,40);
//        g.drawOval(20,40,40,40);
//        g.fillOval(20,40,40,40);
//        g.drawLine(20,40,80,40);
//        g.drawRect(20,40,40,20);
//        g.fillRect(80,40,40,20);
         BufferedImage image=null;
        try {
            image= ImageIO.read(new File("../fiveChess/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image,0,0,this);
         g.drawOval(20,40,40,40);
         g.setColor(Color.red);
         g.fillRect(80,40,40,20);
         g.setFont(new Font("宋体",40,40));
          g.drawString("五子棋游戏",20,100);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("鼠标点击");
//        JOptionPane.showMessageDialog(this, "鼠标点击");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("鼠标进入");
//        JOptionPane.showMessageDialog(this,"鼠标进入");

    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("鼠标离开");
//        JOptionPane.showMessageDialog(this,"鼠标离开");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("鼠标按下");
//        JOptionPane.showMessageDialog(this,"鼠标按下");
        System.out.println("点击位置，X-->"+e.getX());
        System.out.println("点击位置，Y-->"+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("鼠标抬起");
//        JOptionPane.showMessageDialog(this,"鼠标抬起");
    }


}
