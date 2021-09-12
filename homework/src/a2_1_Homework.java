public class a2_1_Homework {
    public static void main(String[] args){
        //关于字符及其编码
        System.out.println(0 == '0');
        System.out.println(0 == '\u0000');
        System.out.println('0' == '\u0000');
        System.out.println('8' == '5' + '3');
        System.out.println('8' == '5' + 3);
        System.out.println(8 == '5' + '3');
        System.out.println(8 == '5' + 3);
    }
}
