import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// 1. Strategy Interface
interface PalindromeStrategy {
    boolean check(String text);
}

// 2. Concrete Strategy – Stack
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return text.equals(reversed);
    }
}

// 3. Concrete Strategy – Deque
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4. Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.check(text);
    }

    // Optionally allow strategy switching at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

// 5. Main class to demonstrate
public class PalindromeChecker {

    public static void main(String[] args) {

        String text = "radar";

        // Use Stack Strategy
        PalindromeContext context = new PalindromeContext(new StackStrategy());
        System.out.println("Using Stack Strategy: " +
                (context.executeStrategy(text) ? "Palindrome" : "Not Palindrome"));

        // Switch to Deque Strategy dynamically
        context.setStrategy(new DequeStrategy());
        System.out.println("Using Deque Strategy: " +
                (context.executeStrategy(text) ? "Palindrome" : "Not Palindrome"));
    }
}