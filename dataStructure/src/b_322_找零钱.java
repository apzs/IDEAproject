import java.util.Arrays;

public class b_322_找零钱 {
    public static void main(String[] args) {
        int[] value = {1,2,5,7,10};
        Arrays.sort(value);
        int spend = 14;
        int[] money = new int[spend+1];
        String[] string =new String[spend+1];
        money[0] = 0;
        string[0] = "";
        for (int i = 1; i <= spend; i++) {
            money[i] = Integer.MAX_VALUE;
            for (int j = 0; j < value.length; j++) {
              if (i-value[j]<0){
                  break;
              }
//            min = Math.min(min,money[i-value[j]] +1);
              if (money[i]>money[i-value[j]] +1){
                  money[i] = money[i-value[j]] +1;
                  string[i]= string[i-value[j]]+value[j]+" ";
              }
            }
        }
        for (int i = 0; i <= spend; i++) {
            System.out.print("需要的钱数："+i+" 需要张数:" +money[i] + " ");
            System.out.println(" 面值分别为："+string[i]);
        }
    }
}
