public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = new int[] {0};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumpTo = nums.length - 1;
        int jumps = 0;
        while (true) {
            jumpTo = oneMoreJump(nums, jumpTo);
            if (jumpTo == -1) {
                return 0;
            } else {
                jumps++;
            }

            if(jumpTo == 0) {
                break;
            }
        }

        return jumps;
    }

    public static int oneMoreJump(int[] nums, int jumpTo) {
        int lastJump = -1;
        for (int i = jumpTo; i >= 0; i--) {
            if (nums[i] + i >= jumpTo) {
                lastJump = i;
            }
        }

        return lastJump;
    }
}
