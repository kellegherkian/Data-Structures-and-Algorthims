package dataStructures;
import java.util.Deque;
import java.util.LinkedList;

public class queue<T extends Comparable<T>> {
    private Deque<T> queue;
    private Deque<T> maxQueue; // This will help track the maximum element efficiently

    public queue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.addLast(item);
        // Maintain maxQueue to always have the maximum at the front
        while (!maxQueue.isEmpty() && maxQueue.peekLast().compareTo(item) < 0) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        T item = queue.removeFirst();
        if (item.equals(maxQueue.peekFirst())) {
            maxQueue.removeFirst();
        }
        return item;
    }

    public T peek() {
        return queue.peekFirst();
    }

    public T getMax() {
        return maxQueue.peekFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void demo() {
        queue<Integer> queue = new queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(15);
        System.out.println("Current queue: " + queue.queue);
        System.out.println("Maximum element in the queue: " + queue.getMax());

        queue.dequeue();
        System.out.println("Queue after one dequeue operation: " + queue.queue);
        System.out.println("Maximum element after dequeue: " + queue.getMax());

        queue.enqueue(25);
        System.out.println("Queue after enqueuing 25: " + queue.queue);
        System.out.println("Maximum element after enqueuing 25: " + queue.getMax());
    }
}
