import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    //定义背景图片
    BufferedImage bg;
    //定义背景图片
    BufferedImage money;
    //进度开始图片
    BufferedImage st;
    //进度结束图片
    BufferedImage ed;

    public GamePanel() {
        //设置背景
        setBackground(Color.BLACK);
        //使用工具方法读取背景图片
        bg = ImageUtil.getImg("/image/BG.png");
        //加载金币图片
        money = ImageUtil.getImg(("/img/money.png"));
        //加载开始图片按钮
        st = ImageUtil.getImg("/img/st.png");
        //加载结束图片按钮
        ed = ImageUtil.getImg("/img/ed.png");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画图片
        //drawImage(图片，横坐标，纵坐标，null
        g.drawImage(bg, 0, 0, 512, 790, null);

        //设置画笔的颜色
        g.setColor(Color.WHITE);
        //设置画笔的字体
        g.setFont(new Font("楷体", Font.BOLD, 25));
        //画文字
        //drawString(文字内容，横坐标，纵坐标）
        g.drawString("分数:0", 30, 30);

        //画金币图片
        g.drawImage(money, 300, 10, 30, 30, null);
        g.drawString("0.00", 340, 32);

        //画关卡
        g.setFont(new Font("楷体", Font.PLAIN, 20));
        g.drawString("关卡1", 30, 60);

        //画历史最高
        g.drawString("历史最高:0.00K", 340, 60);

        //画关卡进度
        g.drawImage(st, 20, 80, 5, 25, null);
        //画灰色进度条
        for (int i = 0; i < 30; i++) {
            g.setColor(Color.GRAY);
            //用颜色填充实心矩形fillRect(横坐标，纵坐标，宽度，高度)
            g.fillRect(30 + i * 15, 80, 10, 25);
        }
        //画蓝色进度条
        for (int i = 0; i < 30; i++) {
            g.setColor(Color.CYAN);
            //用颜色填充实心矩形fillRect(横坐标，纵坐标，宽度，高度)
            g.fillRect(30 + i * 15, 80, 10, 25);
        }
            g.drawImage(ed, 512 - 30, 80, 5, 25, null);
    }
}
