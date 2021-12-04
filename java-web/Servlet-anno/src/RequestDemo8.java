import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Data:2021/5/16
 */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    /**请求转发*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("8");
        //存储数据到request域中
        req.setAttribute("msg","hello");
        //路径为"/requestDemo9"而不是"/RequestDemo9"
        req.getRequestDispatcher("/requestDemo9").forward(req,resp);
    }
}
