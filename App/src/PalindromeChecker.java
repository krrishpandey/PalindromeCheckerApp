import java.util.Stack;

public class PalindromeChecker {

    // Private variable to hold the string
    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Public method to check palindrome
    public boolean checkPalindrome() {

        // Use Stack internally to reverse characters
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return text.equals(reversed);
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {

        String input = "level";

        // Create an instance of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker(input);

        // Call the encapsulated method
        if (checker.checkPalindrome()) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}