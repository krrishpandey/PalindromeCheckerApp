public class PalindromeChecker {

    public static void main(String[] args) {

        // Original string
        String text = "radar";

        // Convert string to character array
        char[] characters = text.toCharArray();

        // Two pointers
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        // Compare characters from start and end
        while (start < end) {

            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
        }
    }
}