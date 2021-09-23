/**
 * @Data:2021/5/14
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        二. 获取请求头数据
//      通过请求头的名称获取请求头的值,user-agent不区分大小写
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌...");
        }else if (agent.contains("Firefox")){
            //火狐
            System.out.println("火狐...");
        }

        System.out.println();
//      获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + "===" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
