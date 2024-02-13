package done;

import java.util.Arrays;

public class ProductOfArray {

    public static void main(String[] args) {
        int[] nums =  new int[] {1,2,3,4,0};

        Arrays.stream(productExceptSelf(nums))
                .forEach(i -> System.out.print(i + " "));
    }
    public static int[] productExceptSelf(int[] nums) {

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0)
                zeroCount++;

        if (zeroCount > 1) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }

            return nums;
        }

        if (zeroCount == 1) {
            int product = 1;
            int zeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    product = product * nums[i];
                    nums[i] = 0;
                } else {
                    zeroIndex = i;
                }
            }
            nums[zeroIndex] = product;

            return nums;
        }

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = product / nums[i];
        }


        return nums;
    }
}
