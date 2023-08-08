package linkedlistreversal;

public class StringReversal {
    public static String reverseString(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }
    // char[] charArray = input.toCharArray();
    // int left = 0;
    // int right = input.length() - 1;

    // while (left < right) {
    //     char temp = charArray[left];
    //     charArray[left] = charArray[right];
    //     charArray[right] = temp;
    //     left++;
    //     right--;
    // }

    // return new String(charArray);

    // Example usage:
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        String reversedString = StringReversal.reverseString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }
}
