package junit;

import java.util.LinkedList;

public class PalindromeChecker {

    // Function to check if a LinkedList of characters is a palindrome
    public static boolean isPalindrome(LinkedList<Character> linkedList) {
        LinkedList<Character> cleanList = new LinkedList<>();

        // Remove non-alphabetic characters and convert to lowercase
        for (Character c : linkedList) {
            if (Character.isLetter(c)) {
                cleanList.add(Character.toLowerCase(c));
            }
        }

        // Compare characters from both ends
        int left = 0;
        int right = cleanList.size() - 1;

        while (left < right) {
            if (!cleanList.get(left).equals(cleanList.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
