package slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithKDistinctChars {

    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // Shrink the window until the number of distinct characters is less than or equal to k
            while (charFrequency.size() > k) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            // Update the maximum length found so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        int maxLen = longestSubstringKDistinct(s, k);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + maxLen);
    }
}
