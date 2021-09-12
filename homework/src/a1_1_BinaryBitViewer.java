import java.util.Scanner;

public class a1_1_BinaryBitViewer {
    public static void main(String[] args) {
        boolean isNotInteger = true;
        int  number= 0;
        System.out.println("请输入一个整数:");
        while (isNotInteger) {
            try {
                Scanner sc =new Scanner(System.in);
                number = sc.nextInt();
                isNotInteger = false;
            } catch (Exception e) {
                System.out.println("输入数据不合法,请重新输入");
            }
        }
        String string="";
        System.out.print("转换成二进制位为:");
        if(number < 0){
            System.out.print("1");
            number = Math.abs(number);
        }
         else if(number == 0){
            System.out.print("0");
        }
        else {
            System.out.print("0");
        }
        while(number>0)
        {
            string=string+number%2;
            number=number/2;
        }
        for(int i=string.length()-1;i>=0;i--) {
            System.out.print(string.charAt(i));
        }

    }
}
