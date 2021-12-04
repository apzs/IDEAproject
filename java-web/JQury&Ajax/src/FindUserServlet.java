import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 无名氏
 * @Data:2021/6/15
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名
        String username = req.getParameter("username");
        //2.调用service层判断用户是否存在
        //期望服务器响应格式，{"userExist":true,"msg":"用户名已存在"}
        //                {"userExist":false,"msg":"用户名可用"}
        Map<String,Object> map = new HashMap<String, Object>();
        //如果用户名为tom则存在
        String name = "tom";
        if (name.equals(username)) {
            map.put("userExist", true);
            map.put("msg", "用户名已存在");
        }else {
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }
        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        //将map转换为json并返回到客户端
        mapper.writeValue(resp.getWriter(),map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
