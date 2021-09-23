import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * @Data:2021/5/14
 */
@WebServlet({"/d1","/dd1","/d1/dd1","/demo1","/dd1/*"}) /*---(  /*的优先级较低 ） ,（ 加随意后缀名的不能在前面加/ )----*/
//@WebServlet("1.do")
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.Servlet.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
