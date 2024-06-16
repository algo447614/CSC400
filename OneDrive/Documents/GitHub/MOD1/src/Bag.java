import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        if (items.isEmpty()) {
            System.out.println("The bag is empty.");
        } else {
            for (Map.Entry<T, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Main method to demonstrate the Bag class with user interaction
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. Check if item exists");
            System.out.println("4. Count occurrences of an item");
            System.out.println("5. Print bag contents");
            System.out.println("6. Exit");

            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Enter item to add:");
                    String itemToAdd = scanner.nextLine();
                    bag.add(itemToAdd);
                    System.out.println(itemToAdd + " added to the bag.");
                    break;
                case "2":
                    System.out.println("Enter item to remove:");
                    String itemToRemove = scanner.nextLine();
                    bag.remove(itemToRemove);
                    System.out.println(itemToRemove + " removed from the bag.");
                    break;
                case "3":
                    System.out.println("Enter item to check:");
                    String itemToCheck = scanner.nextLine();
                    System.out.println("Bag contains " + itemToCheck + ": " + bag.contains(itemToCheck));
                    break;
                case "4":
                    System.out.println("Enter item to count:");
                    String itemToCount = scanner.nextLine();
                    System.out.println("Count of " + itemToCount + ": " + bag.count(itemToCount));
                    break;
                case "5":
                    System.out.println("Bag contents:");
                    bag.printBagContents();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }
}
