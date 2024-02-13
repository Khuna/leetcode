package done;

public class PlaceFlower {

    public static void main(String[] args) {
        int[] flowerbed = new int[] {1,0,0,0,0,1};
        int n = 2;

        System.out.println(canPlaceFlowers(flowerbed, n));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length < n)
            return false;

        int width = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 )
                width++;
            else
                width = 0;

            if (width == 3) {
                n--;
                width = 1;
            }

            if (n == 0) {
                return true;

            }

        }

        return (n == 1 && width == 2);
    }
}
