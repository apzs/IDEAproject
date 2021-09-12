/**
 * @author 无名氏
 * @Data 2021/7/5
 */

import java.io.*;

public class StringBuffer {
    public static void main(String[] args) {
        //读文件到StringBuffer
        java.lang.StringBuffer sb = new java.lang.StringBuffer();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("D:\\1.txt"));
            String str;
            //逐行读取
            while ((str = br.readLine()) != null) {
                //加在StringBuffer尾
                sb.append(str);
                //行尾 加换行符
                sb.append("\r\n");
            }
            //别忘记，切记
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\2.txt"));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}