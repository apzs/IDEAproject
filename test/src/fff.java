import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Auther:无名氏
 *
 * @Data:2021/5/3
 */
public class fff {
    public static void main(String[] args) {
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(new File("D:/1.txt"));
            byte[] bytes=new byte[1024];
            int n=0;
            //循环读取
            //把fis里的东西读到bytes数组里去
            while((n=fis.read(bytes))!=-1)
            {
                //把字节转成String 从0到N变成String
                String w=new String(bytes,0,n);
                System.out.println(w);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            //一定要关闭文件流。并且关闭文件流必须放在finally里面
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
