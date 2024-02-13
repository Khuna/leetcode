package todo;

import java.util.Map;
import java.util.stream.IntStream;

public class LomgestPalindrome {

    public static void main(String[] args) {
        String s = "aaSsSsddffaaAA";
        System.out.println(longestPalindrome(s));

    }

    public static int longestPalindrome(String s) {
        int[] letterCount = new int[52];

        for (char c : s.toCharArray()) {
            if (c < 96)
                letterCount[c - 'A']++;
            else
                letterCount[26 + c - 'a']++;
        }

        int odds = 0;
        int polyLength = 0;
        for (int i : letterCount) {
            if (i % 2 == 1)
                odds++;
            else
                polyLength += (i / 2) * 2;
        }

        if (odds >= 1)
            polyLength++;

        return polyLength;
    }
}
