package done;

import java.util.*;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 3, 3 ,3};
        System.out.println(permuteUnique(nums));
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<LinkedListWithEqauls<Integer>> set = new HashSet<>();
        int maxLen = nums.length;
        return getPermuteUnique(nums, set, maxLen);


    }

    public static List<List<Integer>> getPermuteUnique(int[] nums, Set<LinkedListWithEqauls<Integer>> set, int maxLen) {
        int len = nums.length;

        if (len == 1) {
            return List.of(List.of(nums[0]));
        }

        if (len == 2) {
            if (nums[0] == nums[1]) {
                return List.of(List.of(nums[0], nums[1]));

            } else {
                return List.of(
                        List.of(nums[0], nums[1]),
                        List.of(nums[1], nums[0]));
            }
        }

        List<List<Integer>> lists= new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int[] nums2 = new int[len - 1];
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                nums2[index] = nums[j];
                index++;
            }

            var permutes = getPermuteUnique(nums2, set, maxLen);
            for (List<Integer> permute : permutes) {
                LinkedListWithEqauls<Integer> list = new LinkedListWithEqauls<>();
                list.add(nums[i]);
                list.addAll(permute);

                if (nums.length == maxLen) {
                    if (!set.contains(list)) {
                        set.add(list);
                        lists.add(list);
                    }
                } else {
                    lists.add(list);
                }
            }
        }

        return lists;
    }

    static class LinkedListWithEqauls<T extends Integer> extends LinkedList<T> {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;

            LinkedListWithEqauls<T> anotherList = (LinkedListWithEqauls<T>) o;

            if (anotherList.size() != this.size()) return false;

            var point = this.listIterator();
            var anotherPoint = anotherList.listIterator();
            while (point.hasNext()) {
                if (point.next() != anotherPoint.next()) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            int sum = 1;
            for (Integer i : this) {
                sum = sum + i;
            }

            return (101 * sum) % 17 ;
        }
    }


}
