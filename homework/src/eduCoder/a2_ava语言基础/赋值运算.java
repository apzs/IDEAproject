package eduCoder.a2_ava语言基础;

/**
 * @author 无名氏
 * @date 2021/10/20
 * @Description: TODO
 */
public class 赋值运算 {
    public static void main(String[] args) {
        int j = 2;
        int k = 3;
        int i=j=k=1;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        i=(j=10)*(k=2);
        System.out.println(i);
    }

}
