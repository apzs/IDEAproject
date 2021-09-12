public class b_5_最长回文子串_中心扩散法 {
    /**
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     */
    public static void main(String[] args) {
        String s = "ac";
        String ans = fun(s);
//        String ans = fun2(s,0,2);
        System.out.println(ans);
    }
    //求最长回文子串
    static String fun(String s){
        //长度为 0 或 1 直接返回
        if (s.length()<2){
            return s;
        }
        //longest返回最大回文字符长度
        // b a b a d
        // ^ ^
        String longest =s.substring(0,1);
        String result = fun2(s,0,1);
        if (result.length()>longest.length()){
            longest = result;
        }
        for (int i = 1; i < s.length()-1; i++) {
        //分为以i为中点和以(i+ (i+1) )/2 为中点两种情况
        // i-1  i  i+1
        //  b   a   b   a   d
        //  ^       ^
            String res1 = fun2(s,i-1,i+1);
            if (res1.length()>longest.length()){
                longest = res1;
            }
        //      i  i+1
        //  b   a   b   a   d
        //      ^   ^
            String res2 = fun2(s, i,i+1);
            if (res2.length()>longest.length()){
                longest = res2;
            }
        }
        return longest;
    }
    static String fun2(String s,int l,int r){
        char[] chars = s.toCharArray();
        //由于s.substring(1,1)返回为空所以加一条判断
        if (l+1==r && chars[l]!=chars[r]){
            return s.substring(l,l+1);
        }
        //寻找能匹配的最大长度
        while (chars[l]==chars[r]){
            l--;
            r++;
            //l和r不能越界
            if (l<0 || r>=chars.length){
                break;
            }
        }
        //l和r存储失配的下标
        return s.substring(l+1,r);
    }
}
