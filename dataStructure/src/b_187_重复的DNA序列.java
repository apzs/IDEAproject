import java.util.HashSet;

/**
 * 已知一个DNA序列，求所有序列长度为10的子序列重复的这些序列
 */
public class b_187_重复的DNA序列 {
    public static void main(String[] args) {
        String s = "AAAAAGGGTTCCCCCCAAAAAGGGTTC";
        //所有可能的序列
        HashSet<String> set = new HashSet<>();
        //有重复的序列
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
                String tmp = s.substring(i,i+10);
                if (!set.contains(tmp)){
                    set.add(tmp);
                }else {
                    ans.add(tmp);
                }
        }
        for (String string: ans) {
            System.out.println(string);
        }
//        Iterator<String> a = ans.iterator();
//        while (a.hasNext()){
//            System.out.println(a.next());
//        }
    }
}
