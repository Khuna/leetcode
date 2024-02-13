package done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 10, 3, 5, 34, -1, 10, 15};
        int target = 9;

        Arrays.stream(twoSum(nums, target))
                .forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target - nums[i])) {
                return new int[] {memo.get(target - nums[i]), i};
            }
            else {
                memo.put(nums[i], i);
            }
        }

        return new int[]{};
    }

}
