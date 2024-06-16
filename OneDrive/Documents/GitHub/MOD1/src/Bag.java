import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
    private Map<T, Integer> items;

    // Constructor to initialize the Bag
    public Bag() {
        items = new HashMap<>();
    }

    // Method to add an item to the Bag
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    // Method to remove an item from the Bag
    public void remove(T item) {
        if (items.containsKey(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    // Method to check if an item is in the Bag
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    // Method to count occurrences of an item in the Bag
    public int count(T item) {
        return items.getOrDefault(item, 0);
    }

    // Method to print the contents of the Bag
    public void printBagContents() {
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Main method to demonstrate the Bag class
    public static void main(String[] args) {
        // Create an instance of the Bag class
        Bag<String> bag = new Bag<>();

        // Add several elements to the bag, including duplicates
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("orange");
        bag.add("banana");

        // Print the bag contents
        System.out.println("Bag contents:");
        bag.printBagContents();

        // Test the contains method for a few elements
        System.out.println("\nContains 'apple': " + bag.contains("apple"));
        System.out.println("Contains 'grape': " + bag.contains("grape"));

        // Test the count method for a few elements
        System.out.println("\nCount of 'apple': " + bag.count("apple"));
        System.out.println("Count of 'banana': " + bag.count("banana"));
        System.out.println("Count of 'grape': " + bag.count("grape"));

        // Remove an element from the bag
        bag.remove("apple");

        // Print the bag contents again
        System.out.println("\nBag contents after removing 'apple':");
        bag.printBagContents();

        // Test the contains method for the removed element
        System.out.println("\nContains 'apple' after removal: " + bag.contains("apple"));

        // Test the count method for the removed element
        System.out.println("Count of 'apple' after removal: " + bag.count("apple"));
    }
}
