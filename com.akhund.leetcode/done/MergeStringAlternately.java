package done;

import java.util.Arrays;

public class MergeStringAlternately {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr131";

        System.out.println(mergeAlternately(word1, word2));
    }
    public static String mergeAlternately(String word1, String word2) {
        int length = Math.max(word2.length(), word2.length());

        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        for (int i = 0; i < length; i++) {
            if (word1.length() > i && word2.length() > i) {
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            } else if (word1.length() > i) {
                sb.append(word1.charAt(i));
            } else {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}
