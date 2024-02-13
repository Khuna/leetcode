package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraCandies {

    public static void main(String[] args) {
        int[] candies = new int[] {1,3,5,1,3};
        int extraCandies = 3;

        System.out.println(kidsWithCandies(candies, extraCandies));

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Arrays.stream(candies)
                .max()
                .getAsInt();

        List<Boolean> result = new ArrayList<>();
        Arrays.stream(candies)
                .forEach(kidCandies -> {
                    if (kidCandies + extraCandies >= max)
                        result.add(true);
                    else
                        result.add(false);
                });

        return result;
    }
}
