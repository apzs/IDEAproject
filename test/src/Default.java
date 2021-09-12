import java.util.Scanner;

public class Default {
    public static void main(String[] args) {
      int[] nums = {12,34,35,65,76,34,45,12,43};
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == number) {
                    System.out.println(nums[i] + "+" + nums[j] + "=" + number);
                }
            }
        }
    }
}
