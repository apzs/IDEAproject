

class KMP {
    static int[] next = new int[7];

    static int Index_KMP(char S[], char T[], int pos) {
        int i = pos;
        int j = 1;
        while (i <= S[0] && j <= T[0]) {
            if (j == 0 || S[i] == T[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j > T[0]){
            return i - T[0];
        }else{
            return 0;
        }
    }

    static void get_next(char T[]) {
        int i = 1, j = 0;
        next[1] = 0;
        while (i < T[0]) {
            if (j == 0 || T[i] == T[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    void get_next2(char T[], int nextVal[]) {
        int i = 1, j = 0;
        nextVal[1] = 0;
        while (i < T[0]) {
            if (j == 0 || T[i] == T[j]) {
                i++;
                j++;
                if (T[i] != T[j]) {
                    nextVal[i] = j;
                }
                else {
                    nextVal[i] = nextVal[j];
                }
            } else {
                j = nextVal[j];
            }
        }
    }

    public static void main(String[] args) {
        char S[] = {17, 'a', 'c', 'a', 'b', 'a', 'a', 'b', 'a', 'a', 'b', 'c', 'a', 'c', 'a', 'a', 'b', 'c'};
        char T[] = {6, 'a', 'b', 'a', 'a', 'b', 'c'};
        get_next(T);
        int m = Index_KMP(S, T, 1);
        System.out.println(m);
        for (int i = 1; i < T.length; ++i) {
            System.out.print(next[i]+" ");
        }
    }
}

