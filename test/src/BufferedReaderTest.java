import java.io.*;
import java.lang.StringBuffer;

/**
 * @author 无名氏
 * @Data 2021/7/5
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1(){
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;

        try {
            String str;
            br = new BufferedReader(new FileReader("D:\\1.txt"));
            //将字节输入流转换成字符输入流
//            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\1.txt")));
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test2(){
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\1.txt");
            byte[] bytes = new byte[1024];
            while (fis.read(bytes)!= -1){
                sb.append(bytes);
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
