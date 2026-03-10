import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeChecker {

    // 1. Stack-based palindrome
    public static boolean stackPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) stack.push(ch);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        return text.equals(reversed);
    }

    // 2. Deque-based palindrome
    public static boolean dequePalindrome(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) deque.addLast(ch);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // 3. Two-pointer array approach
    public static boolean twoPointerPalindrome(String text) {
        char[] arr = text.toCharArray();
        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        String testString = "A man a plan a canal Panama";
        // Normalize input (ignore spaces & case)
        String normalized = testString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Measure Stack approach
        long startTime = System.nanoTime();
        stackPalindrome(normalized);
        long stackTime = System.nanoTime() - startTime;

        // Measure Deque approach
        startTime = System.nanoTime();
        dequePalindrome(normalized);
        long dequeTime = System.nanoTime() - startTime;

        // Measure Two-pointer approach
        startTime = System.nanoTime();
        twoPointerPalindrome(normalized);
        long twoPointerTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("Palindrome Performance Comparison:");
        System.out.println("----------------------------------");
        System.out.println("Stack-based:      " + stackTime + " ns");
        System.out.println("Deque-based:      " + dequeTime + " ns");
        System.out.println("Two-pointer array:" + twoPointerTime + " ns");
    }
}