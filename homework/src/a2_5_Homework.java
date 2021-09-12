import java.util.Scanner;

public class a2_5_Homework {
    public static void main(String[] args) {
        int x = 0;
        System.out.println("请输入你的里程数:");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        if(x < 0){
            System.out.println("输入不合法");
        }else if(x <= 6){
            System.out.println("票价为3元");
        }else if(x <= 12){
            System.out.println("票价为4元");
        }else if(x <= 22){
            System.out.println("票价为5元");
        }else if(x <= 32){
            System.out.println("票价为6元");
        }else {
            System.out.println("票价为" + (6 + Math.ceil( ( (double)(x-32) )/20) ) + "元");
        }
    }

}
