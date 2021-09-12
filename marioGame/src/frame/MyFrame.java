package frame; /**
 * 一、程序分析
 * a）使用Java的面向对象设计思路来完成游戏程序，和类的设计
 *   1、Mario对象
 *   2、敌人
 *   3、障碍物
 *   4、场景对象
 *   5、窗体对象
 *   6、图片及背景图片、在该类中，所有的属性都应该是静态的属性
 * b）总代码量：1000-2000行
 *
 * 五、障碍物的开发
 *  a）所包含的属性：
 *    1、坐标（X，Y）
 *    2、显示的图片
 *    3、类型
 *    4、初始的类型
 * b）拥有的方法
 *    1、重置障碍物的方法
 *    2、改变障碍物的显示图片(依据障碍物的类型）
 * c）建立一个Class类
 *
 * 六.Mario的开发
 *  a）所包含的属性
 *    1、坐标（X，Y）
 *    2、显示的图片
 *    3、使用一个String类型的变量来描述Mario当前的状态（移动、方向、跳跃等）
 *    4、生命数及分数
 *  b）拥有的方法
 *    1、移动（左、右）
 *    2、停止（左、右）
 *    3、跳跃
 *  c）建立一个Class类
 *     将Mario对象显示到窗体中
 *     为Mario加入移动功能
 *     为mario和 窗体 加入线程
 *     移动功能完成，再在Mario类中加入显示图片的控制
 *     完成Mario与障碍物的横向坐标的判断
 */

import mario.Mario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyFrame extends JFrame implements Runnable{

    private List<BackGround> allBG = new ArrayList<BackGround>();
    //绘制初始的Mario
    private Mario mario = null;

    private BackGround nowBG = null;

    private Thread t = new Thread(this);

    public MyFrame(){
        this.setTitle("马里奥游戏");
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //初始化全部的图片
        StaticValue.init();
        //创建全部的场景
        for(int i = 1;i <= 3;i++){
            this.allBG.add(new BackGround(i , i == 3));
        }
        //将第一个场景设置为当前场景
        this.nowBG = this.allBG.get(0);
        //初始化Mario对象
        this.mario = new Mario(0,480);
        //将场景放入mario对象的属性中
        this.mario.setBg(nowBG);

        this.repaint();
        this.addKeyListener(keyAdapter);
        t.start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        //建立临时的缓存图片
        BufferedImage image = new BufferedImage(900,600,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g2 = image.getGraphics();
        //绘制背景
        g2.drawImage(this.nowBG.getBgImage(),0,0,this);
        //绘制障碍物
        Iterator<Obstruction> iterator = this.nowBG.getAllObstruction().iterator();
        while (iterator.hasNext()){
           Obstruction ob = iterator.next();
           g2.drawImage(ob.getShowImage(),ob.getX(),ob.getY(),this);
        }
        g2.drawImage(this.mario.getShowImage(),this.mario.getX(),this.mario.getY(),this);
        //把缓冲图片绘制到窗体中
        g.drawImage(image,0,0,this);
    }
    KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyTyped (KeyEvent e){
            e.getKeyChar();
        }

        @Override
        public void keyPressed (KeyEvent e){
//            得到 左、右、上 箭头的值
//            System.out.println(e.getKeyCode());
            //当按下39时（右箭头），mario向右移动
            if(e.getKeyCode() == 39){
                mario.rightMove();
            }
            //当按下37时（左箭头），mario向右移动
            if(e.getKeyCode() == 37){
                mario.leftMove();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //当抬起39时（右箭头），mario向右移动
            if(e.getKeyCode() == 39){
                mario.rightStop();
            }
            //当抬起37时（左箭头），mario向右移动
            if(e.getKeyCode() == 37){
                mario.leftStop();
            }
        }
    };

    @Override
    public void run() {
        while (true){
            this.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
    }
}
