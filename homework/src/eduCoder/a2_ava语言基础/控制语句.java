package eduCoder.a2_ava语言基础;

import java.util.Scanner;

/**
 * @author 无名氏
 * @date 2021/10/20
 * @Description: TODO
 */
public class 控制语句 {
    public static void main(String[] args){
        int x,y,temp;
        Scanner In=new Scanner(System.in);
        x=In.nextInt();
        y=In.nextInt();
        System.out.println("交换前两个整数的值是：");
        System.out.println("x,y="+x+","+y);
        /****Begin****/
        x=x+y;
        y=x-y;
        x=x-y;
        /****End****/
        System.out.println("交换后两个整数的值是：");
        System.out.println("x,y="+x+","+y);
    }
}
