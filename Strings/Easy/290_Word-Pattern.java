import java.util.*;

class Solution {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(ch) && !map1.get(ch).equals(word)) {
                return false;
            }

            if (map2.containsKey(word) && map2.get(word) != ch) {
                return false;
            }

            map1.put(ch, word);
            map2.put(word, ch);
        }

        return true;
    }

    // 🔥 Main method for VS Code testing
    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(sol.wordPattern("abba", "dog cat cat fish")); // false
    }
}