import java.util.Stack;

public class PalindromeChecker {

    public static void main(String[] args) {

        // Original string
        String text = "madam";

        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Push characters into the stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Pop characters and build reversed string
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Compare original and reversed strings
        if (text.equals(reversed)) {
            System.out.println("The string \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
        }
    }
}