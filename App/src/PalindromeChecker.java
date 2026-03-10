public class PalindromeChecker {

    // Function to check palindrome
    public static boolean isPalindrome(String text) {

        // Normalize string: remove non-alphanumeric characters & convert to lowercase
        String normalized = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Two-pointer comparison
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String text = "A man a plan a canal Panama";

        if (isPalindrome(text)) {
            System.out.println("The string \"" + text + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
        }
    }
}