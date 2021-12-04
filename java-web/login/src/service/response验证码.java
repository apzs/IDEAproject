package service;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Data:2021/5/21
 */
@WebServlet("/checkCode")
public class response验证码 extends HttpServlet {
    private Random random = new Random();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 80;
        int height = 30;
        //1.创建一个对象，在内存中（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //填充背景色
        Graphics g = image.getGraphics(); //创建画笔对象
        g.setColor(Color.GRAY);//设置画笔颜色
        g.fillRect(0,0,width,height);

        //画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);//边框占一个字符
        String checkCode_session = getCheckCode();
        HttpSession session = req.getSession();
        session.setAttribute("checkCode_session",checkCode_session);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("黑体",Font.BOLD,24));
        g.drawString(checkCode_session,15,25);
        //画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    private String getCheckCode(){
        //生成随机数
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //拼接随机字符
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            String s ="" + str.charAt(index);
            sb.append(s);
        }
        //把随机字符写到session中
        return sb.toString();
    }
}
