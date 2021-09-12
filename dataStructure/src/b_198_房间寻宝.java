/*

 */
public class b_198_房间寻宝 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 3, 0, 2, 7};
        int[] value = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            value[i] = -1;
        }

        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //前i房屋总金币的最大解为（前i-2房屋的最大解+第i屋的金币数）与（前i-1房屋的最大解）较大的金币数
            value[i] = Math.max(value[i - 2] + nums[i], value[i-1]);
        }
            System.out.println(value[nums.length-1]);
    }
}
