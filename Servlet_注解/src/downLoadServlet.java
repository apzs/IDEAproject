import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Data:2021/5/21
 */
@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //使用字节输出流加载文件进内存
        //找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //使用字节流关联
        FileInputStream file = new FileInputStream(realPath);
        //设置response的响应头类型content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        resp.setHeader("content-type",mimeType);
        //设置响应头打开方式content-disposition
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);//解决不同浏览器中文文件名问题
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = file.read(buff)) != 0){
                sos.write(buff,0,len);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
