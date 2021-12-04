import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author 无名氏
 * @Data 2021/7/2
 */
public class URL {
    public static void main(String[] args) {
         String str = "啊 啊 啊";
        String encode = null;
        try {
             encode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encode);

        String decode = null;
        try {
             decode = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);
    }
}
