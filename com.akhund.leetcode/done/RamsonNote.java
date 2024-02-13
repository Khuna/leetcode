package done;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RamsonNote {

    public static void main(String[] args) {

        String ramsonNote = "aasdd";
        String magazine = "asaaaaaaaassssssddddddddddddddddd";

        System.out.println(canConstruct(ramsonNote, magazine));

    }


    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];
        for(int i = 0; i < magazine.length(); i++)
            letters[magazine.charAt(i) - 'a']++;

        for(int i = 0; i < ransomNote.length(); i++) {
            if (letters[ransomNote.charAt(i) - 'a'] == 0)
                return false;
            else
                letters[ransomNote.charAt(i) - 'a']--;
        }

        return true;
    }
}
