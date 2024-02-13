package done;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[] {1,0,4,0,0,1,34,6};

        Arrays.stream(nums)
                .forEach(i -> System.out.print(i + " "));
    }

    public static void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pointer] == 0) {
                if (nums[i] != 0) {
                    int value = nums[i];
                    nums[i] = nums[pointer];
                    nums[pointer] = value;
                    pointer++;
                }
            }
            else
                pointer++;
        }
    }
}
