

/**
 * @Data:2021/5/4
 */
public class b_5_最长回文子串_my动态规划 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabad"));
    }

    private static String longestPalindrome(String s) {
        int length = s.length();
        if(length<2){
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] visit = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            visit[i][i] = true;
        }
        int maxlength = 1;
        int begin = 1;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){

                    visit[i][j] =  false;
                }else {
                    if (j-i < 3){
                        visit[i][j] = true;
                    }else {
                        visit[i][j] = visit[i+1][j-1];
                    }
                }
                if (visit[i][j] && j-i+1 > maxlength){
                    maxlength = j-i+1;
                    begin = i;
                }
            }
        }
//        for (int i = 0; i < length; i++) {
//            System.out.println(Arrays.toString(visit[i]));
//        }
        return s.substring(begin,begin+maxlength);
    }
}
