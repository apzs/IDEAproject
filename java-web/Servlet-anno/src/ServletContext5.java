import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Data:2021/5/21
 */
@WebServlet("/servletContext5")
public class ServletContext5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //获取文件的真实路径
        String path  = context.getRealPath("/index.jsp");//web目录下的资源访问
        String path2 = context.getRealPath("/WEB-INF/1.txt");//WEB-INF目录下的资源访问
        String path3 = context.getRealPath("/WEB-INF/classes/2.txt");//src下的文件在/WEB-INF/classes内创建
        String path4 = context.getRealPath("/WEB-INF/classes/a/3.txt");
        System.out.println(path);
        System.out.println(path2);
        System.out.println(path3);
        System.out.println(path4);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
