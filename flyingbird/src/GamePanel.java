
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * 如果是在准备状态下，点击鼠标就是进入游戏运行状态
 *
 * 如果是在游戏运行状态，点击鼠标就是小鸟上抛
 *
 * 如果是在游戏结束状态，点击鼠标就是进入游戏准备状态
 */
public class GamePanel extends JPanel {
    //背景图片
    BufferedImage bg;
    //地面
    Ground ground;
    //柱子
    Column column1;
    Column column2;
    Column column3;
    //鸟类
    Bird bird;
    //初始化游戏状态(没有开始，为准备状态，若为true则为游戏运行状态)
    boolean start = false;
    //得分
    int score = 0;
    //判断线程是否运行完毕
    boolean isRunnable = true;

    //构造器
    public GamePanel() {
        //设置背景色
        setBackground(Color.BLUE);
        bg = App.getImg("../flyingbird/img/bg.png");
        ground = new Ground();
        column1 = new Column(1);
        column2 = new Column(2);
        column3 = new Column(3);
        bird = new Bird();

        //初始化鼠标监听器
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (start) {  //游戏运行状态
                    //小鸟上抛
                    bird.moveUp();
                } else {
                    //改变游戏状态为运行状态
                    start = true;
                    //将线程所有执行的任务装入到线程对象中
                    Thread thread = new Thread(runnable);
                    //将线程纳入线程调度
                    thread.start();
                }
            }
        };
        //添加鼠标监听
        this.addMouseListener(adapter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画文字
        g.drawString("飞翔的小鸟", 23, 23);
        g.drawImage(bg, 0, 0, null);
        g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
        g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
        g.drawImage(column3.img, column3.x, column3.y, column3.w, column3.h, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
        g.drawImage(ground.img, ground.x, ground.y, null);
        g.setFont(new Font("幼圆",Font.BOLD,15));
        g.setColor(Color.white);
        g.drawString("分数：" + score,25,25);
        if(start == false && isRunnable == true)
            g.drawImage(App.getImg("../flyingbird/img/start.png"),0,0,null);
        if(isRunnable == false)
            g.drawImage(App.getImg("../flyingbird/img/gameover.png"),0,0,null);
    }

    Runnable runnable = () -> {
        while (canRun()) {
            //地面移动
            ground.move();
            //柱子移动
            column1.move();
            column2.move();
            column3.move();
            //鸟飞
            bird.fly();
            //小鸟落体运动
            bird.move();
            try {
                Thread.sleep(25);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isRunnable = false;
        start = false;
    };
    public boolean canRun(){
        boolean isRun = true;
        if (bird.y < 0 || bird.y > 644) isRun = false;
        if((bird.x + bird.w > column1.x  && bird.x < column1.x+38) &&(bird.y < 264 + column1.y || bird.y + bird.h> 264 + 74 + column1.y)) isRun = false;
        if(bird.x  == column1.x + 38 && bird.y > 264 + column1.y && bird.y < 264 + 74 + column1.y) score++;
        if((bird.x + bird.w > column2.x  && bird.x < column2.x+38) &&(bird.y < 264 + column2.y || bird.y + bird.h> 264 + 74 + column2.y)) isRun = false;
        if(bird.x  == column2.x + 38 && bird.y > 264 + column2.y && bird.y < 264 + 74 + column2.y) score++;
        if((bird.x + bird.w > column3.x  && bird.x < column3.x+38) &&(bird.y < 264 + column3.y || bird.y + bird.h> 264 + 74 + column3.y)) isRun = false;
        if(bird.x  == column3.x + 38 && bird.y > 264 + column3.y && bird.y < 264 + 74 + column3.y) score++;
        return isRun;
    }
}
