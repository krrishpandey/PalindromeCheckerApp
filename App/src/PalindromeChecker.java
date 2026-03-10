public class PalindromeChecker {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String text, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(text, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String text = "madam";

        // Call recursive function
        if (isPalindrome(text, 0, text.length() - 1)) {
            System.out.println("The string \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
        }
    }
}