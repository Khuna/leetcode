package done;

public class ReverseWords {

    public static void main(String[] args) {

        String s = "  123  456   ";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int k = 0;
        int l = s.length() - 1;

        while (l >= 0) {
            if (s.charAt(l) == ' ') {
                l--;
                continue;
            }
            else
                k = l - 1;

            while (k > 0 && s.charAt(k) != ' ') {
                k--;
            }
            if (!sb.isEmpty())
                sb.append(' ');

            sb.append(s.substring(k + 1, l + 1));

            l = k - 1;
        }

        return sb.toString();
    }
}
