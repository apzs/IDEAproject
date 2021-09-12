import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test6 {
    static Pattern p = Pattern.compile("\\w+");

    public static void main(String[] args) {
        Matcher m = p.matcher("adddffg2344");
        //匹配整个字符串
        boolean ans = m.matches();
        //匹配到一个后继续查找
//        System.out.println(ans);
    }
}
