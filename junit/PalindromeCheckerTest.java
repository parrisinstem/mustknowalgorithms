package junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class PalindromeCheckerTest {

    @Test
    public void testIsPalindrome() {
        // Test a palindrome LinkedList
        LinkedList<Character> palindromeList = new LinkedList<>();
        palindromeList.add('R');
        palindromeList.add('a');
        palindromeList.add('c');
        palindromeList.add('e');
        palindromeList.add('c');
        palindromeList.add('a');
        palindromeList.add('r');
        assertEquals(true, PalindromeChecker.isPalindrome(palindromeList));

        // Test a non-palindrome LinkedList
        LinkedList<Character> nonPalindromeList = new LinkedList<>();
        nonPalindromeList.add('H');
        nonPalindromeList.add('e');
        nonPalindromeList.add('l');
        nonPalindromeList.add('l');
        nonPalindromeList.add('o');
        assertEquals(false, PalindromeChecker.isPalindrome(nonPalindromeList));

        // Test an empty LinkedList
        LinkedList<Character> emptyList = new LinkedList<>();
        assertEquals(true, PalindromeChecker.isPalindrome(emptyList));

        // Test a single-character LinkedList
        LinkedList<Character> singleCharList = new LinkedList<>();
        singleCharList.add('a');
        assertEquals(true, PalindromeChecker.isPalindrome(singleCharList));
    }
}
