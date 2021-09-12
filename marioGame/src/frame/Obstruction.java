package frame;

import java.awt.image.BufferedImage;

/**
 * 障碍物类
 */
public class Obstruction {
    //坐标
    private int x;
    private int y;

    //类型
    private int type;
    //初始的类型
    private int startType;
    //显示图片
    private BufferedImage showImage = null;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //构造方法
    public Obstruction(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        setImage();
    }


    public BufferedImage getShowImage() {
        return showImage;
    }

    //重置方法
    public void reset(){
        //先修改类型为初始类型
        this.type = startType;
        //改变显示图片
        this.setImage();
    }

    //根据类型改变显示图片
    public void setImage(){
        showImage = StaticValue.allObstructionImage.get(type);
    }
}
