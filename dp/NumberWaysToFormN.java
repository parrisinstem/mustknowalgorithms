package dp;

public class NumberWaysToFormN {

    public static int countWaysToFormN(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            // Recursively calculate the number of ways for each of the given three numbers
            return countWaysToFormN(n - 1) + countWaysToFormN(n - 3) + countWaysToFormN(n - 5);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int totalWays = countWaysToFormN(n);
        System.out.println(totalWays); // Output: 8
    }
}
