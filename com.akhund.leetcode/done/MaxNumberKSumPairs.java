package done;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberKSumPairs {

    public static void main(String[] args) {
        int[] nums = new int[] {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;

        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int pairsCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = k - nums[i];
            if (map.containsKey(key)) {
                pairsCount++;
                if (map.get(key) == 1)
                    map.remove(key);
                else
                    map.put(key, map.get(key) - 1);
            }
            else
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return pairsCount;
    }
}
