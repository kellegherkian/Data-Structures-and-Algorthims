package dataStructures;
import java.util.Stack;

public class stack<T extends Comparable<T>>{
    private Stack<T> mainStack;
    private Stack<T> minStack;

    public stack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T item) {
        mainStack.push(item);
        if (minStack.isEmpty() || item.compareTo(minStack.peek()) <= 0) {
            minStack.push(item);
        }
    }

    public T pop() {
        if (!mainStack.isEmpty()) {
            T item = mainStack.pop();
            if (item.equals(minStack.peek())) {
                minStack.pop();
            }
            return item;
        }
        return null;
    }

    public T peek() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        return null;
    }

    public T getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return null;
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    public static void demo() {
        stack<Integer> stack = new stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(3);
        stack.push(8);
        System.out.println("Current stack: " + stack.mainStack);
        System.out.println("Current minimum: " + stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println("Current stack after two pops: " + stack.mainStack);
        System.out.println("Current minimum after two pops: " + stack.getMin());
    }
}
