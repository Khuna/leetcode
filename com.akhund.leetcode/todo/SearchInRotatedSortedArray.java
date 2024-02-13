package todo;

import javax.management.remote.rmi.RMIConnectionImpl;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,8,1,2,3};
        int target = 2;

        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        if (nums.length == 2)
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;

        int left = 0;
        int right = nums.length - 1;
        int middle;

        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;

        while (left < right) {
            middle = (right + left) / 2;
            if (middle == right || middle == left)
                break;

            if (nums[left] < nums[right]) {
                if (target < nums[left] || target > nums[right])
                    return -1;

                if (nums[middle] == target)
                    return middle;
                else if (nums[middle] > target)
                    right = middle;
                else
                    left = middle;
            }

            else {
                if (nums[middle] == target)
                    return middle;

                if (nums[middle] < target) {
                    if (nums[left] < nums[middle])
                        left = middle;
                    else
                        right = middle;
                }
                else {
                    if (nums[right] < target)
                        right = middle;
                    else
                        left = middle;
                }
            }
        }
        return -1;
    }
}
