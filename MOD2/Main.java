package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add an item to bag1");
            System.out.println("2. Add an item to bag2");
            System.out.println("3. Remove an item from bag1");
            System.out.println("4. Check if item exists in bag1");
            System.out.println("5. Count occurrences of an item in bag1");
            System.out.println("6. Print bag1 contents");
            System.out.println("7. Print bag2 contents");
            System.out.println("8. Print size of bag1");
            System.out.println("9. Print size of bag2");
            System.out.println("10. Merge bag2 into bag1");
            System.out.println("11. Print distinct items in bag1");
            System.out.println("12. Exit");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Enter item to add to bag1:");
                    String itemToAddBag1 = scanner.nextLine();
                    bag1.add(itemToAddBag1);
                    System.out.println(itemToAddBag1 + " added to bag1.");
                    break;
                case "2":
                    System.out.println("Enter item to add to bag2:");
                    String itemToAddBag2 = scanner.nextLine();
                    bag2.add(itemToAddBag2);
                    System.out.println(itemToAddBag2 + " added to bag2.");
                    break;
                case "3":
                    System.out.println("Enter item to remove from bag1:");
                    String itemToRemove = scanner.nextLine();
                    bag1.remove(itemToRemove);
                    System.out.println(itemToRemove + " removed from bag1.");
                    break;
                case "4":
                    System.out.println("Enter item to check in bag1:");
                    String itemToCheck = scanner.nextLine();
                    System.out.println("Bag1 contains " + itemToCheck + ": " + bag1.contains(itemToCheck));
                    break;
                case "5":
                    System.out.println("Enter item to count in bag1:");
                    String itemToCount = scanner.nextLine();
                    System.out.println("Count of " + itemToCount + " in bag1: " + bag1.count(itemToCount));
                    break;
                case "6":
                    System.out.println("Bag1 contents:");
                    bag1.printBagContents();
                    break;
                case "7":
                    System.out.println("Bag2 contents:");
                    bag2.printBagContents();
                    break;
                case "8":
                    System.out.println("Size of bag1: " + bag1.size());
                    break;
                case "9":
                    System.out.println("Size of bag2: " + bag2.size());
                    break;
                case "10":
                    bag1.merge(bag2);
                    System.out.println("Bag2 merged into bag1.");
                    break;
                case "11":
                    Bag<String> distinctBag = bag1.distinct();
                    System.out.println("Distinct items in bag1:");
                    distinctBag.printBagContents();
                    break;
                case "12":
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
