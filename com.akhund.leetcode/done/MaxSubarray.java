package done;

public class MaxSubarray {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, -10, 3, 4, -1, 7};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = sum > 0 ? sum : 0;
        }

        return max;
    }
}
