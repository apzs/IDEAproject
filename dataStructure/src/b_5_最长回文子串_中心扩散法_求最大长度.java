public class b_5_最长回文子串_中心扩散法_求最大长度 {
    /**
     * 示例 1：
     * 输入：s = "babad"
     * 示例 2：
     * 输入：s = "cbbd"
     * 示例 3：
     * 输入：s = "a"
     * 示例 4：
     * 输入：s = "ac"
     */
    public static void main(String[] args) {
        String string = "babad";
        int ans = fun(string);
        System.out.println(ans);
    }
    static int fun(String s){
        if (s.length()<2){
            return s.length();
        }
        int longest = 1;
        int result = fun2(s,0,1);
        longest = Math.max(longest,result);
        for (int i = 1; i < s.length()-1; i++) {

            int res1 = fun2(s,i-1,i+1);
            int res2 = fun2(s, i,i+1);
            int res = Math.max(res1,res2);
            longest = Math.max(longest,res);
        }
        return longest;
    }
  static int fun2(String s,int l,int r){
        char[] chars = s.toCharArray();
        while (chars[l]==chars[r]){
            l--;
            r++;
            if (l<0 || r>=chars.length){
                break;
            }
        }
      //l和r存储失配的下标
      //  fun2(s,0,2)
      //  0   1   2   3   4
      //  b   a   b   a   d
      //  (3 - (-1) )/2 = 2

      //  fun2(s,1,2)
      //  0   1   2   3   4
      //  b   a   b   a   d
      //  (2-1)/2=0 但longest初始化为1

      //  fun2(s,1,2)
      //  0   1   2   3   4
      //  b   a   a  a   d
      //  (3-0)/2=1
        return (r-l)/2;
  }

}
