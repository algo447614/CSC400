import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * CustomDeque class implements a double-ended queue using Java's Deque interface.
 * It allows for insertion and removal of elements from both ends of the queue.
 */
class CustomDeque {
    private Deque<Integer> deque;

    /**
     * Constructor initializes the deque using a LinkedList.
     */
    public CustomDeque() {
        this.deque = new LinkedList<>();
    }

    /**
     * Adds an element to the front of the deque.
     * @param data The integer to be added to the front.
     */
    public void enqueueFront(int data) {
        deque.addFirst(data);
    }

    /**
     * Adds an element to the rear of the deque.
     * @param data The integer to be added to the rear.
     */
    public void enqueueRear(int data) {
        deque.addLast(data);
    }

    /**
     * Removes and returns the front element of the deque.
     * @return The front element of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public int dequeueFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeFirst();
    }

    /**
     * Removes and returns the rear element of the deque.
     * @return The rear element of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public int dequeueRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }

    /**
     * Returns an iterator over the elements in the deque.
     * @return An Iterator for the elements in the deque.
     */
    public Iterator<Integer> iterator() {
        return new DequeIterator();
    }

    /**
     * Checks if the deque is empty.
     * @return true if the deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /**
     * Inner class that implements the Iterator interface for the CustomDeque.
     */
    private class DequeIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator = deque.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return iterator.next();
        }
    }
}

/**
 * Main class to demonstrate the functionality of CustomDeque.
 */
public class Main {
    public static void main(String[] args) {
        CustomDeque customDeque = new CustomDeque();
        Random random = new Random();

        // Enqueue 10 random integers
        System.out.println("Enqueuing 10 random integers:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100); // Generate random number between 0 and 99
            if (i % 2 == 0) {
                customDeque.enqueueFront(randomNumber);
                System.out.println("Enqueued " + randomNumber + " at front");
            } else {
                customDeque.enqueueRear(randomNumber);
                System.out.println("Enqueued " + randomNumber + " at rear");
            }
        }

        // Iterate and display elements
        System.out.println("\nIterating through the deque:");
        Iterator<Integer> iterator = customDeque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Demonstrate dequeue operations
        System.out.println("\nDemonstrating dequeue operations:");
        System.out.println("Dequeued from front: " + customDeque.dequeueFront());
        System.out.println("Dequeued from rear: " + customDeque.dequeueRear());

        // Display remaining elements
        System.out.println("\nRemaining elements in the deque:");
        iterator = customDeque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
