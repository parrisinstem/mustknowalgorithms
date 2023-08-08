

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charIndexMap.containsKey(c)) {
                left = Math.max(left, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Example usage:
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();

        String input1 = "abcdefghijkliabcbb";
        int result1 = longestSubstring.lengthOfLongestSubstring(input1);
        System.out.println("Longest substring without repeating characters: " + result1); // Output: 3 ("abc")

        String input2 = "bbbbb";
        int result2 = longestSubstring.lengthOfLongestSubstring(input2);
        System.out.println("Longest substring without repeating characters: " + result2); // Output: 1 ("b")

        String input3 = "pwwkew";
        int result3 = longestSubstring.lengthOfLongestSubstring(input3);
        System.out.println("Longest substring without repeating characters: " + result3); // Output: 3 ("wke")
    }
}
