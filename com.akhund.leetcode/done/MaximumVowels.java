package done;

public class MaximumVowels {

    public static void main(String[] args) {
        String s = "dfsdfsd8131ieysdafaeseeeeseses";
        int k = 4;

        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {

        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return isVovel(s.charAt(0)) ? 1 : 0;
        if (k >= s.length()) {
            k = s.length();
        }

        int maxVowels = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++)
            if (isVovel(chars[i]))
                maxVowels++;

        if (k == s.length())
            return maxVowels;

        int vowels = maxVowels;

        for (int i = k; i < s.length(); i++) {
            if (isVovel(chars[i]))
                vowels++;
            if (isVovel(chars[i-k]))
                vowels--;

            maxVowels = Math.max(vowels, maxVowels);
        }

        return maxVowels;
    }

    static boolean isVovel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }
}
