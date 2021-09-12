import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
//        int[] value = {1,2,5,7,10};
        int[] value = {2};
        Arrays.sort(value);
        int spend = 3;
        int[] money = new int[spend+1];
        String[] string =new String[spend+1];
        money[0] = 0;
        string[0] = "";
        for (int i = 1; i <= spend; i++) {
            money[i] = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < value.length; j++) {
                if (i-value[j]<0){
                    break;
                }
                if (money[i-value[j]]!=-1 && min>money[i-value[j]] +1){
                    min = money[i-value[j]] +1;
                    string[i]= string[i-value[j]]+value[j]+" ";
                }
                if (min<Integer.MAX_VALUE){
                    money[i] = min;
                }
            }
        }
        for (int i = 0; i <= spend; i++) {
            System.out.print("需要的钱数："+i+" 需要张数:" +money[i] + " ");
            System.out.println(" 面值分别为："+string[i]);
        }
    }
}
