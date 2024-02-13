package done;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");

        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        int pointer = 0;
        char[] chars = s.toCharArray();
        StringBuilder word = new StringBuilder();
        while (pointer < s.length()) {
            word.append(chars[pointer]);
            if (words.contains(word.toString())) {
                word = new StringBuilder();
            }

            pointer++;
        }

        return word.toString().length() == 0;
    }
}
