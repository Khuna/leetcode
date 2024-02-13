package done;

public class ReverseVowels {

    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int k = 0;
        int l = s.length() - 1;

        while (k < l) {
            if (isVowel(s.charAt(k)) && isVowel(s.charAt(l))) {
                sb.setCharAt(k, s.charAt(l));
                sb.setCharAt(l, s.charAt(k));
                l--;
                k++;
            }
            else if (isVowel(s.charAt(k)) && !isVowel(s.charAt(l)))
                l--;
            else if (!isVowel(s.charAt(k)) && isVowel(s.charAt(l)))
                k++;
            else {
                l--;
                k++;
            }
        }

        return sb.toString();
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }


}
