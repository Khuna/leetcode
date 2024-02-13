package done;

public class IsSubsequance {

    public static void main(String[] args) {
        String s = "abc";
        String t = "avbsdsgc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {

        int sPointer = 0;
        int tPointer = 0;

        while (tPointer < t.length() && sPointer < s.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            }
            else
                tPointer++;
        }

        return sPointer == s.length();
    }
}
