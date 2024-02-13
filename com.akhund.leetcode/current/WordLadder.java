package current;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        if (beginWord.equals(endWord))
            return 1;

        if (distance(beginWord, endWord) == 1)
            return 2;

        int[] min = new int[] {Integer.MAX_VALUE};
        backtrack(beginWord, endWord, wordList, 0, min);

        return min[0];
    }

    public static void backtrack(String beginWord, String endWord, List<String> wordList, int length, int[] min) {
        if (beginWord.equals(endWord)) {
            min[0] = Math.min(length, min[0]);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (distance(beginWord, word) == 1) {
                wordList.remove(word);
                backtrack(word, endWord, wordList, length + 1, min);
                wordList.add(i, word);
            }

        }
    }

    public static int distance(String word1, String word2) {
        if (word2.equals(word1))
            return 0;

        if (word2.equals("*") || word1.equals("*"))
            return 100;

        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                distance++;
        }

        return distance;
    }
}
