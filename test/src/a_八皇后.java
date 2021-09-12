

public class a_八皇后 {
    public static void main(String[] args) {
        solveNQueens(8);
    }

    private static void solveNQueens(int n) {
        char[][] queen = new char[n][n];
        boolean[][] attack = new boolean[n][n];
        //将attack初始化为false
        for (boolean[] booleans:attack) {
            for (boolean b:booleans) {
                b = false;
            }
        }
        //将queue初始化为'.'
        for (char[] chars:queen) {
            for (char s:chars) {
                s = '.';
            }
        }

        for (int i = 0; i < n; i++) {
             backtrak(0,n,queen,attack);
        }
    }

    /**
     * @param k         表示当前处理的行
     * @param n         表示N皇后问题
     * @param queue     存储皇后的位置
     * @param attack    标记皇后的攻击位置
     */
    private static void backtrak(int k, int n, char[][] queue,boolean[][] attack) {
       if(k==n){
           for (char[] chars:queue) {
               System.out.print("[");
               for (char c:chars) {
                   System.out.print(c+ " ");
               }
               System.out.print("]");
           }
           System.out.println();
           return;
       }

        for (int i = 0; i < n; i++) {
            if(attack[k][i]==false){
                boolean[][] tmp = attack.clone();
                queue[k][i] = 'Q';

            }
        }
    }
}
