import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 重定向的特点
 1.重定向地址栏发生变化
 2.重定向可以访问其他站点(服务器)的资源
 3.重定向是两次请求
 需要写虚拟目录,不可以使用request对象来共享数据
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("responseDemo1");
        //访问/response Demo1,会自动跳转到/responseDemo2的资源
        //1.设置状态码为302
        resp.setStatus(302);
        //2.获取虚拟目录
        String contextPath = req.getContextPath();
        //3.设置响应头localhost
        resp.setHeader("location",contextPath+"/responseDemo2");

        //简单的重定向
        //String contextPath = req.getContextPath();
        //resp.sendRedirect(contextPath+"/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
