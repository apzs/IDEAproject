import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiveChessFrame extends JFrame implements Runnable {

    int width = Toolkit.getDefaultToolkit().getScreenSize().width;   //取得屏幕的宽度
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;  //取得屏幕的高度

    BufferedImage bgImage = null;                                     //背景图片

    int x = 0;                                                      //绘制棋子的坐标
    int y = 0;

    int[][] allChess = new int[26][26];                             //保存之前下过的全部棋子的坐标
    // 其中数据内容 0:表示这个点并没有棋子，1:表示这个点是黑子  2:表示这个点是白子


    boolean isBlack = true;                                         //标识当前应该是黑棋还是白棋走下一步
    boolean canPlay = true;                                         //标识当前游戏是否可以继续
    String message = "黑方先行";                                     //保存显示的提示信息
    //保存最多拥有多少时间(秒)
    int maxTime = 0;

    Thread t =new Thread(this);                             //做倒计时线程类
    int blackTime = 0;                                             //保存黑方与白方的剩余时间
    int whiteTime = 0;

    String blackMessage = "无限制";                                //保存双方时间的显示信息
    String whiteMessage = "无限制";

    public FiveChessFrame() {
        this.setTitle("五子棋");                                  //设置标题
        this.setSize(619, 645);                     //设置窗体大小
        this.setLocation((width - 619) / 2, (height - 645) / 2);   //设置窗体出现的位置
        this.setResizable(false);                               //将窗体设置为不可改变
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //将窗体的关闭方式设置为默认关闭后程序结束
        this.addMouseListener(mouseAdapter);                         //为窗体加入监听器
        this.setVisible(true);                                  //将窗体显示出来

        t.start();
        t.checkAccess();
        this.repaint();                         //刷新屏幕，防止开始游戏出现无法显示的情况
    }

    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(619,645,BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = bi.createGraphics();              //在内存中创建一张图片并为这张图片创建画笔
        try {
            bgImage = ImageIO.read(new File(System.getProperty("user.dir")+ "/fivechess/src/background.jpg"));
//            bgImage = ImageIO.read(new File(System.getProperty("user.dir")+ "\\fivechess\\background.jpg"));也可以
        } catch (IOException e) {
            System.out.println("图片未加载成功");
            e.printStackTrace();
        }

        g2.drawImage(bgImage, 0, 30, this);              //绘制背景图片
        g2.setFont(new Font("黑体", Font.BOLD, 20));       //输出标题信息
        g2.setColor(Color.BLUE);
        g2.drawString("游戏信息:"+message, 420, 65);                //输出时间信息
        g2.setFont(new Font("宋体", Font.PLAIN, 14));
        g2.setColor(Color.red);
        g2.drawString("黑方时间："+blackMessage, 40, 600);
        g2.drawString("白方时间："+whiteMessage, 262, 600);


//        绘制棋盘
        for (int i = 0; i < 26; i++) {
//            Graphics2D g3 = (Graphics2D) g2 ;
//            g3.setStroke(new BasicStroke(1f));
            g2.drawLine(24, 82 + 19 * i, 499, 82 + 19 * i);
            g2.drawLine(24 + 19 * i, 82, 24 + 19 * i, 556);
        }

//        标注点位
        g2.fillOval(78, 136, 6, 6);    //左上点
        g2.fillOval(249, 135, 6, 6);   //中上点
        g2.fillOval(420, 136, 6, 6);   //右上点
        g2.fillOval(79, 306, 6, 6);    //左中点
        g2.fillOval(249, 307, 6, 6);   //正中点
        g2.fillOval(420, 307, 6, 6);   //右中点
        g2.fillOval(78, 478, 6, 6);    //左下点
        g2.fillOval(249, 479, 6, 6);   //中下点
        g2.fillOval(420, 477, 6, 6);   //右下点

//         绘制全部棋子
        g2.setColor(Color.BLACK);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int tempX = i * 19 + 24;
                int tempY = j * 19 + 79;
                if (allChess[i][j] == 1) {     //黑子
                    g2.fillOval(tempX - 7, tempY - 7, 14, 14);
                }
                if (allChess[i][j] == 2) {     //白子
                    g2.setColor(Color.WHITE);
                    g2.fillOval(tempX - 7, tempY - 7, 14, 14);
                    g2.setColor(Color.BLACK);
                    g2.drawOval(tempX - 7, tempY - 7, 14, 14);
                }
            }
        }
        g.drawImage(bi,0,0,this);
    }

    MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
//        System.out.println("X="+e.getX());
//        System.out.println("Y="+e.getY());
            if (canPlay) {
// 由于直接截断，导致点击一个19X19像素的点会显示在左上角，将点击的点的像素横、纵坐标+9
// 使以五子棋横纵坐标交线为中心的19*19的像素点向右下角移动9像素、即为要显示点的右下角的正方形
// 从而点击要显示的的点为中心，19*19的像素内、都能显示出该交线为圆心的圆
                x = e.getX() + 9;
                y = e.getY() + 9;
                if (x >= 24 && x <= 499 && y >= 79 && y <= 552) {
                    x = (x - 24) / 19;
                    y = (y - 79) / 19;

                    if (allChess[x][y] == 0) {

                        if (isBlack) {       //判断当前要下什么颜色的棋子
                            allChess[x][y] = 1;
                            isBlack = false;
                            message = "轮到白方";
                        } else {
                            allChess[x][y] = 2;
                            isBlack = true;
                            message = "轮到黑方";
                        }
                        boolean winFlag = checkWin();      //判断这个棋子是否和其他颜色相同的棋子连成5连，即判断游戏是否结束
                        if (winFlag) {
                            JOptionPane.showMessageDialog(null, "游戏结束,恭喜"
                                    + (allChess[x][y] == 1 ? "黑方" : "白方") + "获胜!");
                            canPlay = false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "当前位置有棋子，请重新落子!");
                    }


                    repaint();
                }
            }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=78 && e.getY() <= 118){                                      //重新开始游戏
            int result = JOptionPane.showConfirmDialog(null,"是否重新开始游戏");
            if(result == 0){
                //现在重新开始游戏
                //重新开始所要做的操作: 1)把棋盘清空，allChess[x][y]这个数组中全部数据归0
                //2)将游戏信息：的显示改回到开始位置
                //3)将下一步下棋的人改为黑方
                for(int i=0; i<26 ; i++){
                    for(int j=0; j<26; j++){
                    allChess[i][j] = 0;
                    }
                }
                //另一种方式allChess = new int[26][26];
                message = "黑方先行";
                isBlack = true;
                blackTime = maxTime ;
                whiteTime = maxTime ;
                if(maxTime > 0){
                    blackMessage = maxTime/60+":"+maxTime%60;
                    whiteMessage = maxTime/60+":"+maxTime%60;
                    t.checkAccess();
                }else {
                    blackMessage = "无限制";
                    whiteMessage = "无限制";
                }
                canPlay = true;
                repaint();
            }
        }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=153 && e.getY() <= 190){                                     //游戏设置
            String input = JOptionPane.showInputDialog("请输入游戏的最大时间(秒),输入0表示没有时间限制");
            try {
                maxTime = Integer.parseInt(input);
                if(maxTime < 0){
                    JOptionPane.showMessageDialog(null,"时间不能为负数");
                }
                if(maxTime == 0){
                    int result = JOptionPane.showConfirmDialog(null,"设置完成,是否重新开始游戏？");
                    if(result == 0){
                        for(int i=0; i<26 ; i++){
                            for(int j=0; j<26; j++){
                                allChess[i][j] = 0;
                            }
                        }
                        //另一种方式allChess = new int[26][26];
                        message = "黑方先行";
                        isBlack = true;
                        blackTime = maxTime ;
                        whiteTime = maxTime ;
                        blackMessage = "无限制";
                        whiteMessage = "无限制";
                        canPlay = true;
                        repaint();
                    }
                } if(maxTime > 0){
                    int result = JOptionPane.showConfirmDialog(null,"设置完成,是否重新开始游戏？");
                    if(result == 0) {
                        for (int i = 0; i < 26; i++) {
                            for (int j = 0; j < 26; j++) {
                                allChess[i][j] = 0;
                            }
                        }
                        //另一种方式allChess = new int[26][26];
                        message = "黑方先行";
                        isBlack = true;
                        blackTime = maxTime ;
                        whiteTime = maxTime ;
                        blackMessage = maxTime/60+":"+maxTime%60;
                        whiteMessage = maxTime/60+":"+maxTime%60;
                        t.checkAccess();
                        canPlay = true;
                        repaint();
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null,"请正确输入信息!");
            }
        }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=218 && e.getY() <= 258){                                     //游戏说明
            JOptionPane.showMessageDialog(null,"这是一个五子棋游戏程序，黑白双方轮流下棋，当某一方连到5子时，游戏结束");
        }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=340 && e.getY() <= 380){                                     //认输
            int result = JOptionPane.showConfirmDialog(null,"是否确认认输");
            if(result == 0){
                if(isBlack) {
                    JOptionPane.showMessageDialog(null, "黑方已经认输，游戏结束!");
                }else {
                    JOptionPane.showMessageDialog(null, "白方已经认输，游戏结束!");
                }
                canPlay = false;
            }

        }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=414 && e.getY() <= 454){                                     //关于
            JOptionPane.showMessageDialog(null,"本游戏由无名氏制作，有相关问题，自行解决");
        }
        if(e.getX() >= 510 && e.getX() <= 595 && e.getY()>=494 && e.getY() <= 553){                                     //退出
            JOptionPane.showMessageDialog(null,"游戏结束");
            System.exit(0);
        }
        }
    };

    private boolean checkWin() {     //判断这个棋子是否和其他的颜色相同的棋子连成5连
        boolean flag = false;
        int count=1;
        int color = allChess[x][y];

/*   //判断横向是否有5个棋子相连，特点 纵坐标 是相同， 即allChess[x][y]中y值是相同的
         int count = 1;              //保存共有相同颜色多少棋子相连
         //通过循环来做棋子相连的判断
         for(int i=1;color==allChess[x+i][y];i++){
             count++;
         }
         for(int i=1;color==allChess[x-i][y];i++){
             count++;
         }
         if(count >= 5) flag = true;

     //纵向判断
        int count2=1;
         for(int i=1;color==allChess[x][y+i];i++){
             count2++;
         }
         for(int i=1;color==allChess[x][y-i];i++){
             count2++;
         }
         if(count2 >= 5) flag = true;

     //左斜方向的判断
         int count3=1;
         for(int i=1;color==allChess[x+i][y-i];i++){
             count3++;
         }
         for(int i=1;color==allChess[x-i][y+i];i++){
             count3++;
         }
         if(count3 >= 5) flag = true;

     //右斜方向的判断
         int count4=1;
         for(int i=1;color==allChess[x-i][y-i];i++){
             count4++;
         }
         for(int i=1;color==allChess[x+i][y+i];i++){
             count4++;
         }
         if(count4 >= 5) flag = true;
*/

        count = this.checkCount(1, 0, color);                        //判断横向
        if (count >= 5) {
        flag = true;
        } else {
            count = this.checkCount(0, 1, color);           //判断纵向
            if (count >= 5) {
            flag = true;
            } else {
                count = this.checkCount(1, -1, color);      //判断右上、左下
                if (count >= 5) {
                flag = true;
                } else {
                    count = this.checkCount(1, 1, color);   //判断右下、左上
                    if (count >= 5) {
                    flag = true;
                    }
                }
            }
        }

        return flag;
    }

    //判断棋子连接的数量
    private int checkCount(int xChange, int yChange, int color) {
        int count = 1;
        int tempX = xChange;               //保存xChange和yChange的值
        int tempY = yChange;

        while ((x+xChange)>=0&&(x+xChange)<26&&(y+yChange)>=0&&(y+yChange)<26&&color == allChess[x + xChange][y + yChange]) {
            count++;
            if (xChange != 0) xChange++;
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }

        xChange = tempX;
        yChange = tempY;
        while ((x-xChange)>=0&&(x-xChange)<26&&(y-yChange)>=0&&(y-yChange)<26&&color == allChess[x - xChange][y - yChange]) {
            count++;
            if (xChange != 0) xChange++;
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }
        return count;
    }

    @Override
    public void run() {
        if(maxTime > 0){       //判断是否有时间的限制
            while (true){
                if(isBlack){
                    blackTime--;
                    if(blackTime == 0) {
                        JOptionPane.showMessageDialog(this, "黑方超时，游戏结束!");
                    }
                }else {
                    whiteTime--;
                    if(whiteTime == 0){
                        JOptionPane.showMessageDialog(this, "白方超时，游戏结束!");

                    }
                }
                blackMessage = blackTime/60+":"+blackTime%60;
                whiteMessage = whiteTime/60+":"+whiteTime%60;
                this.repaint();
                try {
                    Thread.sleep(1000);             //睡眠1000毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}