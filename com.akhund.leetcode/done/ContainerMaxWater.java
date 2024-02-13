package done;

public class ContainerMaxWater {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,42,28,43,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);

        while (left != right) {
            if (height[left] > height[right])
                right--;
            else
                left++;

            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }

        return max;
    }
}
