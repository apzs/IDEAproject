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
@WebServlet("/servletContext")
public class ServletContext1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象两种获取方式
        //通过request对象获取
        ServletContext context = this.getServletContext();
        //通过HttpServlet获取
        //ServletContext context1 = req.getServletContext();
        String filename = "a.jpg";
        //获取jpg的MIME类型“text/jpeg”
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
