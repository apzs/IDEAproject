package mario;

import frame.BackGround;
import frame.Obstruction;
import frame.StaticValue;

import java.awt.image.BufferedImage;

public class Mario implements Runnable{
    //坐标
    private int x;
    private int y;

    //定义一个场景对象，保存当前Mario所在的场景
    private BackGround bg = null;

   //加入线程
   private  Thread  t = null;

    //定义一个速度属性
    private int xMove = 0;
    private int yMove = 0;

    //状态
    private String status;
    //显示的图片
    private BufferedImage showImage;
    //生命数和分数
    private int score;
    private int life;

    //当前移动显示的图片索引
    private int moving = 0;

    //构造方法
    public Mario(int x, int y) {
        this.x = x;
        this.y = y;
        //初始化Mario图片
        this.showImage = StaticValue.allMarioImage.get(0);
        this.score = 0;
        this.life = 3;

        t = new Thread(this);
        t.start();
        //判断当前状态
        this.status = "right--standing";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBg(BackGround bg) {
        this.bg = bg;
    }

    @Override
    public void run() {
        while (true){
            //判断当前mario是否与障碍物碰撞
            //定义标记
            boolean canLeft = true;
            boolean canRight = true;
            for (Obstruction ob : bg.getAllObstruction()){
                //不允许继续向左移动
                if(this.x == ob.getX() + 60 && this.y  > ob.getY() - 60 && this.y  < ob.getY() + 60){
                    canLeft = false;
                }
                //不允许继续向右移动 (此时Mario在障碍物的左边）
                if(this.x == ob.getX() - 60 && this.y  > ob.getY() - 60 && this.y  < ob.getY() + 60){
                    canRight = false;
                }

            }
            if((canLeft && xMove < 0) || (canRight && xMove > 0)) {
                //改变坐标
                x += xMove;
            }
            //定义一个图片取得的初始索引数
            int temp = 0;
            //判断当前是否为向左
            if (status.contains("left")){
                temp += 5;
            }

            //判断当前是否为移动
            if(status.contains("moving")){
                temp += moving;
                moving++;
                if (moving == 4){
                    moving = 0;
                }
            }

            //改变显示图片
            showImage = StaticValue.allMarioImage.get(temp);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage getShowImage() {
        return showImage;
    }

    public void leftMove(){
        //改变速度
        xMove = -5;
        //改变状态
        this.status = "left--moving";
    }

    public void rightMove(){
       xMove = 5;
       this.status = "right--moving";
    }

    public void leftStop(){
        xMove = 0;
        this.status = "left--standing";

    }

    public void rightStop(){
        xMove = 0;
        this.status = "right--standing";
    }

    public void jump(){

    }
}
