/**
 * 美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。
 * 他曾在1935~1936年应邀来中国清华大学讲学。
 * 一次，他参加某个重要会议，年轻的脸孔引人注目。
 * 于是有人询问他的年龄，他回答说：
 * “我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。”
 * 请你推算一下，他当时到底有多年轻。
 */

import java.util.HashSet;

public class Fruit {
    public static void main(String[] args) {
        int age = 0;
        for (int i = 0; i <100 ; i++) {
          String m =String.valueOf((int) Math.pow(i,3));
          String n =String.valueOf((int) Math.pow(i,4));
            if(m.length()== 4 && n.length() == 6){
                HashSet<String> set = new HashSet<String>();
                for(int a = 0; a < m.length(); a++){
                    set.add(String.valueOf(m.charAt(a)));
                }
                for(int b = 0; b<n.length(); b++){
                    set.add(String.valueOf(n.charAt(b)));
                }
                if(set.size()==10){
                    System.out.println(i);
                }
          }
        }
    }

}
