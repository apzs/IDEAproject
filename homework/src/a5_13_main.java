import java.util.Scanner;

public class a5_13_main {
    public static void main(String[] args) {
        a5_12_MultiQuestion multiQuestion = new a5_12_MultiQuestion("三国演义中的三绝是谁？",
                new String[]{"A、曹操","B、刘备","C、关羽","D、诸葛亮"},new char[] {'A','C','D'});
        multiQuestion.print();
        System.out.println("请选择：");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        char[] answers= answer.toCharArray();
        if (multiQuestion.check(answers)){
            System.out.println("恭喜,答对了！");
        }else {
            System.out.println("还得努力呀！");
        }


        a5_11_SingleQuestion singleQuestion = new  a5_11_SingleQuestion("最早向刘备推荐诸葛亮的是谁？",
                new String[]{"A、徐庶","B、司马懿","C、鲁肃","D、关羽"},'B');
        singleQuestion.print();
        System.out.println("请选择：");
        String answer2 = sc.next();
        char[] answers2= answer2.toCharArray();
        if (singleQuestion.check(answers2)){
            System.out.println("恭喜,答对了！");
        }else {
            System.out.println("还得努力呀！");
        }
    }
}
