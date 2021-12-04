/**
 * @Data:2021/5/14
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
转发的特点
1.转发地址栏路径不变
2.转发只能访问当前服务器下的资源
3.转发是一次请求
 不需要写虚拟目录，可以使用request对象来共享数据
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        一. 获取请求行数据
//        GET /day14/demo1?name=zhangsan HTTP/1.1
//        1. 获取请求方式 ：GET
        String method = request.getMethod();
        System.out.println(method);
//        2. (*)获取虚拟目录：/day14
        String contextPath =  request.getContextPath();
        System.out.println(contextPath);
//        3. 获取Servlet路径: /demo1
        String ServletPath = request.getServletPath();
        System.out.println(ServletPath);
//        4. 获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
//        5. (*)获取请求URI：/day14/demo1
        String RequestURI = request.getRequestURI();
        System.out.println(RequestURI);
//        5. 获取请求URI：http://localhost/day14/demo1
        StringBuffer RequestURL = request.getRequestURL();
        System.out.println(RequestURL);
//        6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
//        7. 获取客户机的IP地址：
        String remoteAddr = request.getRemoteAddr();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
