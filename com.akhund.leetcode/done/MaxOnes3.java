package done;

public class MaxOnes3 {

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,0,0};
        int k = 0;

        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {

        if (nums.length <= k)
            return nums.length;

        if (nums.length == 1)
            return nums[0];

        int start = 0;
        int wide = 0;
        int zeros = k;

        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                start = i + 1;
                if (nums[i] == 1) {
                    wide = 1;
                    break;
                }

            }
        }
        else {
            wide = 1;
            start = 1;
            zeros = zeros - (nums[0] == 1 ? 0 : 1);
        }

        if (wide >= nums.length)
            return wide;

        for (int i = start; i < nums.length; i++) {
            if (nums[i - wide] == 0 && nums[i] == 0) {
                if (zeros > 0) {
                    wide++;
                    zeros--;
                }
            }
            else if (nums[i - wide] == 0 && nums[i] == 1) {
                if (zeros < 0)
                    zeros++;
                else
                    wide++;
            }
            else if (nums[i - wide] == 1 && nums[i] == 1) {
                if (zeros >= 0)
                    wide++;
            }
            else if (nums[i - wide] == 1 && nums[i] == 0) {
                if (zeros > 0) {
                    zeros--;
                    wide++;
                }
                else
                    zeros--;
            }
        }

        return wide;
    }
}