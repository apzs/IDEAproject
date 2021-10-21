package eduCoder.a2_ava语言基础;

import java.util.Scanner;

/**
 * @author 无名氏
 * @date 2021/10/20
 * @Description: TODO
 */
public class 综合实验 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double perimeter, area;
        double radius = in.nextDouble();
        double angle = in.nextDouble();
        area = Math.PI*radius*radius*angle/360;
        perimeter = 2*Math.PI*radius*angle/360+2*radius;
        System.out.println("扇形的半径:"+radius);
        System.out.println("扇形的角度:"+angle);
        System.out.println("扇形的面积:"+area);
        System.out.println("扇形的周长(只保留整数部分):"+(int)perimeter);
    }
}

