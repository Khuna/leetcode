package done;

import java.util.Arrays;

public class MaximumAverageSubarray {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,1,3,3};
        int k = 2;

        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {

        if (k <= 0)
            throw new ArithmeticException("k <= 0!");
        if (k == 1)
            return Arrays.stream(nums).max().getAsInt();
        if (k > nums.length)
            return 0;
        if (nums.length == 1)
            return nums[0];


        return 1;

    }
}
