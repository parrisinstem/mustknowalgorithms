package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinSlidingWindow {

    public static String minWindowSubstring(String s, String t) {
        Map<Character, Integer> targetChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetChars.put(c, targetChars.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int requiredChars = targetChars.size();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetChars.containsKey(c)) {
                targetChars.put(c, targetChars.get(c) - 1);
                if (targetChars.get(c) == 0) {
                    requiredChars--;
                }
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }

                char leftChar = s.charAt(left);
                if (targetChars.containsKey(leftChar)) {
                    targetChars.put(leftChar, targetChars.get(leftChar) + 1);
                    if (targetChars.get(leftChar) > 0) {
                        requiredChars++;
                    }
                }

                left++;
            }

            right++;
        }

        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
