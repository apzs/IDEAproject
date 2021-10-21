package eduCoder.a2_ava语言基础;

import java.util.Scanner;

/**
 * @author 无名氏
 * @date 2021/10/20
 * @Description: TODO
 */
public class 综合实验2 {
    public static void main(String[] args){
        int i=0;
        char min = 'z';
        Scanner in=new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        for ( i = 0; i < chars.length; i++) {
            if (chars[i]<min){
                min = chars[i];
            }
        }
        System.out.println(min);
    }
}
