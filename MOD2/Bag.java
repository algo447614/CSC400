package main;

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
        if (items.isEmpty()) {
            System.out.println("The bag is empty.");
        } else {
            for (Map.Entry<T, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Method to get the total size of the Bag
    public int size() {
        int size = 0;
        for (int count : items.values()) {
            size += count;
        }
        return size;
    }

    // Method to merge another Bag into this Bag
    public void merge(Bag<T> otherBag) {
        for (Map.Entry<T, Integer> entry : otherBag.items.entrySet()) {
            items.put(entry.getKey(), items.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    // Method to get a new Bag with distinct elements
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (T item : items.keySet()) {
            distinctBag.add(item);
        }
        return distinctBag;
    }
}
